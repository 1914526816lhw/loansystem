package com.stu.util.fileExport;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.stu.util.filePath.PdfPath;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/**
 * ClassName：PDFUtil
 * Description：
 *
 * @author lihw
 * CreateTime: 2019/12/31 15:40
 * @version 1.0.0
 */
public class PdfExportUtil {

    /**
     * MethodName: PDFOut
     * Description: 按照PDF模板中的渲染样式将JSONObject中的数据填入其中
     *
     * @param
     * @return
     * @author lhw
     * CreateTime 2019/12/31 15:58
     */
    public static void PdfOut(JSONObject json) {
        //模版路径
        String templatePath = PdfPath.PDF_TEMPLATE_PATH;
        //生成的新文件路径
        String newPDFPath = PdfPath.PDF_NEW_PATH;

        //读取PDF文件
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper; //pdf模板


       // BaseFont baseFont = BaseFont.createFont()

    }
}
