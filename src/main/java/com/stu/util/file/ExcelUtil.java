package com.stu.util.file;

//import com.stu.domain.User;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExcelUtil {

    public static byte[] exportExcel(String sheetTitle, String[] title, List<Object> list) {
        HSSFWorkbook wb = new HSSFWorkbook();//创建HSSFWorkBook对象，创建excel表
        HSSFSheet sheet = wb.createSheet(sheetTitle);
        sheet.setDefaultColumnWidth(20);//设置默认行宽

        //表头样式（加粗，水平居中，垂直居中）
        HSSFCellStyle cellStyle = wb.createCellStyle();
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中

        //设置边框样式
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        HSSFFont fontStyle = wb.createFont();
        fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        cellStyle.setFont(fontStyle);

        //标题样式（加粗，垂直居中）
        HSSFCellStyle cellStyle1 = wb.createCellStyle();
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle1.setFont(fontStyle);

        //设置边框样式
        cellStyle1.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellStyle1.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
        cellStyle1.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellStyle1.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        //字段样式（垂直居中）
        HSSFCellStyle cellStyle2 = wb.createCellStyle();
        cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);

        //设置边框样式
        cellStyle2.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
        cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellStyle2.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        //创建表头
        HSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(20);//行高

        HSSFCell cell = row.createCell(0);
        cell.setCellValue(sheetTitle);
        cell.setCellStyle(cellStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (title.length - 1)));

        //创建标题
        HSSFRow rowTitle = sheet.createRow(1);
        rowTitle.setHeightInPoints(20);

        HSSFCell hc;
        for (int i = 0; i < title.length; i++) {
            hc = rowTitle.createCell(i);
            hc.setCellValue(title[i]);
            hc.setCellStyle(cellStyle1);
        }

        byte[] result = null;
        ByteArrayOutputStream out = null;
        try {
            //创建表格数据
            Field[] fields;
            int i = 2;
            for (Object obj : list) {
                fields = obj.getClass().getDeclaredFields();
                HSSFRow rowBody = sheet.createRow(i);
                rowBody.setHeightInPoints(20);
                int j = 0;
                for (Field f : fields) {
                    f.setAccessible(true);
                    Object va = f.get(obj);
                    if (va == null) {
                        va = "";
                    }
                    hc = rowBody.createCell(j);
                    hc.setCellValue(va.toString());
                    hc.setCellStyle(cellStyle2);
                    j++;
                }
                i++;
            }
            out = new ByteArrayOutputStream();
            wb.write(out);
            result = out.toByteArray();
        } catch (Exception e) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e){
                Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE,null,e);
            }finally {
                try {
                    wb.close();
                } catch (IOException e) {
                    Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String sheetTitle = "用户信息";
        String[] title = {"姓名", "年龄"};

        List<Object> list = new ArrayList<Object>();
//
//        for(int i=0;i<10;i++){
//            User u = new User();
//            u.setName("张三"+i);
//            u.setAge(10+i);
//            list.add(u);
//        }

        byte b[] = ExcelUtil.exportExcel(sheetTitle, title, list);

        File f = new File("d:\\"+sheetTitle+".xls");
        try {
            FileUtils.writeByteArrayToFile(f, b, true);
        } catch (IOException ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
