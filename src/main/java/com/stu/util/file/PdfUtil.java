package com.stu.util.file;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName：PDFUtil
 * Description：
 *
 * @author lihw
 * CreateTime: 2019/12/31 15:40
 * @version 1.0.0
 */
public class PdfUtil {

    /**
     * MethodName: PDFOut
     * Description: 按照PDF模板中的渲染样式将JSONObject中的数据填入其中
     *
     * @param
     * @return
     * @author lhw
     * CreateTime 2019/12/31 15:58
     */
    public static void pdfExport(Map<String,Object> map) {
        //模版路径
        String templatePath = PdfPath.PDF_TEMPLATE_PATH;
        //生成的新文件路径
        String newPDFPath = PdfPath.PDF_NEW_PATH;

        //读取PDF文件
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper; //pdf模板

        try {
            BaseFont baseFont = BaseFont.createFont("c://windows//fonts//simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font FontChinese = new Font(baseFont,5, Font.NORMAL);
            out = new FileOutputStream(newPDFPath);//输出流
            reader = new PdfReader(templatePath);//读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();//模板表单
            //文字类的内容处理
            Map<String,String> datemap = (Map<String,String>)map.get("dateMap");
            form.addSubstitutionFont(baseFont);
            for(String key : datemap.keySet()){
                String value = datemap.get(key);
                form.setField(key,value);
            }
            //图片类的内容处理
            Map<String,String> imgmap = (Map<String,String>)map.get("imgMap");
            for(String key : imgmap.keySet()) {
                String value = imgmap.get(key);
                String imgpath = value;
                int pageNo = form.getFieldPositions(key).get(0).page;
                Rectangle signRect = form.getFieldPositions(key).get(0).position;
                float x = signRect.getLeft();
                float y = signRect.getBottom();
                //根据路径读取图片
                Image image = Image.getInstance(imgpath);
                //获取图片页面
                PdfContentByte under = stamper.getOverContent(pageNo);
                //图片大小自适应
                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
                //添加图片
                image.setAbsolutePosition(x, y);
                under.addImage(image);
            }
            stamper.setFormFlattening(true);//如果为false，生成的PDF文件可编辑，如果为true，生成的PDF文件不可以编辑
            stamper.close();
            Document document = new Document();
            Font font = new Font(baseFont,32);
            PdfCopy pdfCopy = new PdfCopy(document,out);
            document.open();
            PdfImportedPage pdfImportedPage = pdfCopy.getImportedPage(new PdfReader(bos.toByteArray()),1);
            pdfCopy.addPage(pdfImportedPage);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("userName","张三");
        map.put("createDate",String.format("YYYY年MM月DD日",new Date()));
        map.put("weather","晴朗");
        map.put("sports","打乒乓球");

        Map<String,String> map2 = new HashMap();
        map2.put("img","D:/实习/简历/蓝桥logo.png");

        Map<String,Object> o=new HashMap();
        o.put("dateMap",map);
        o.put("imgMap",map2);
        pdfExport(o);
    }
}
