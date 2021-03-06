package com.stu.util.file;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/**
 * ClassName：PDFUtil
 * Description：
 *
 * @author lihw
 * CreateTime: 2019/12/31 15:40
 * @version 1.0.0
 */
public class PdfUtil {


    // 利用模板生成pdf
    public static void pdfout(Map<String, Object> o, String pdfName, int flag) {
        String templatePath = null;
        if (flag == 1) {
            // 模板路径
            templatePath = PdfPath.PDF_TEMPLATE_LOAN_APP_PATH;
        } else if (flag == 2) {
            System.out.println(pdfName);
            templatePath = PdfPath.PDF_TEMPLATE_LOAN_CONTRACT_PATH;
        }

        // 生成的新文件路径
        String newPDFPath = PdfPath.PDF_NEW_PATH + pdfName;

        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font FontChinese = new Font(bf, 5, Font.NORMAL);
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            //文字类的内容处理
            Map<String, String> dataMap = (Map<String, String>) o.get("dataMap");
            form.addSubstitutionFont(bf);

            for (String key : dataMap.keySet()) {
                String value = dataMap.get(key);
                form.setField(key, value);
            }
            //图片类的内容处理
            if (o.get("imgmap") != null) {
                Map<String, String> imgmap = (Map<String, String>) o.get("imgmap");
                for (String key : imgmap.keySet()) {
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
            }
            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.close();
            Document doc = new Document();
            Font font = new Font(bf, 32);
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(e);
        } catch (DocumentException e) {
            System.out.println(e);
        }

    }

//    public static void main(String[] args) {
//        Map<String,String> map = new HashMap();
//        map.put("userName","张三");
//        map.put("createDate",String.format("YYYY年MM月DD日",new Date()));
//        map.put("weather","晴朗");
//        map.put("sports","打乒乓球");
//
//        Map<String,String> map2 = new HashMap();
//        map2.put("img","D:/实习/简历/蓝桥logo.png");
//
//        Map<String,Object> o=new HashMap();
//        o.put("dateMap",map);
//        o.put("imgMap",map2);

//        Map<String, String> map = new HashMap();
//        map.put("name", "李宏伟");
//        map.put("sex", "男");
//        map.put("age", String.valueOf(22));
//        Map<String, Object> o = new HashMap();
//        o.put("dataMap", map);
//        pdfout(o);
//    }
}
