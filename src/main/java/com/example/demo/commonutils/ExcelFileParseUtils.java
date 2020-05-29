package com.example.demo.commonutils;

import com.example.demo.dto.ExcelDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/***
 add by xiadongming on 2020/5/6
 **/
public class ExcelFileParseUtils {

    public static List<ExcelDTO> excelFileParse() throws Exception {
        String fileName = "class_8.xls";
        String filePath = "C:\\Users\\999\\Desktop\\yinji\\";
        File file =  new File(filePath + fileName);
        InputStream fileInputStream = new FileInputStream(file);
        //获取excel中的数据信息集合
        List<ExcelDTO> courseListByExcel1 = getCourseListByExcel(fileInputStream, fileName);
        System.out.println(courseListByExcel1.size());
        return courseListByExcel1;
    }
    public static List getCourseListByExcel(InputStream in, String fileName) throws Exception {
        List<ExcelDTO> list = new ArrayList<>();
        // 创建excel工作簿
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet =  work.getSheetAt(i);
            if(sheet == null) {
                continue;
            }
            // 滤过第一行标题
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                ExcelDTO excelDTO = new ExcelDTO();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    if(0 == y){
                        excelDTO.setPathology(cell.toString());
                    }else if(1 == y){
                        excelDTO.setSex(cell.toString());
                    }else if(2 == y){
                        excelDTO.setAge(cell.toString());
                    }else if(3 == y){
                        excelDTO.setPathologyResult(cell.toString());
                    }else if(4 == y){
                        excelDTO.setFinalResult(cell.toString());
                    }
                }
                list.add(excelDTO);
                //  System.out.println(excelDTO);
            }
        }
        work.close();
        return list;
    }

    /**
     * 判断文件格式
     * @param in
     * @param fileName
     * @return
     */
    private static Workbook getWorkbook(InputStream in, String fileName) throws Exception {
       //通过此方法，兼容excel2003/2007
        Workbook book = WorkbookFactory.create(in);
       /* Workbook book = null;
        String filetype = fileName.substring(fileName.lastIndexOf("."));

        if(".xls".equals(filetype)) {
            book = new XSSFWorkbook(in);
        } else if (".xlsx".equals(filetype)) {
            book = new HSSFWorkbook(in);
        } else {
            throw new Exception("请上传excel文件！");
        }*/

        return book;
    }

}
