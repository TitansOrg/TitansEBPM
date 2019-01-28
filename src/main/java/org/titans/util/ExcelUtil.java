package org.titans.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.titans.bean.sys.SysUserBean;

public class ExcelUtil {

    
    public static void exportExcel(List<SysUserBean> userList, ServletOutputStream outputStream) {
        try {
            //1、创建工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            //1.1、创建合并单元格对象
            CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);
            //1.2、头标题样式
            HSSFCellStyle styleHeader = createCellStyle(workbook , (short)16);
            //1.3、列标题样式
            HSSFCellStyle styleTitle = createCellStyle(workbook , (short)13);
            //2、创建工作表
            HSSFSheet sheet = workbook.createSheet("用户列表");
            //2.1、加载合并单元格对象
            sheet.addMergedRegion(cellRangeAddress);
            // 设置默认列换
            sheet.setDefaultColumnWidth(25);
            //3、创建行
            //3.1、创建头标题行；并且设置头标题
            HSSFRow rowHeader = sheet.createRow(0);
            HSSFCell cellHeader = rowHeader.createCell(0);
            cellHeader.setCellStyle(styleHeader);
            cellHeader.setCellValue("用户列表");
            //3.2、创建列标题行；并且设置列标题
            String [] titles = {"账号","用户名","密码","创建时间","更新时间"};
            HSSFRow rowTitle = sheet.createRow(1);
            for (int i = 0; i < titles.length; i++) {
                HSSFCell cell = rowTitle.createCell(i);
                cell.setCellStyle(styleTitle);
                cell.setCellValue(titles[i]);
            }
            //4、操作单元格；将用户列表写入excel
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (userList != null) {
                for (int j = 0; j < userList.size(); j++) {
                    HSSFRow row = sheet.createRow(j+2);
                    HSSFCell cell11 = row.createCell(0);
                    cell11.setCellValue(userList.get(j).getUsercode());
                    HSSFCell cell12 = row.createCell(1);
                    cell12.setCellValue(userList.get(j).getUsername());
                    HSSFCell cell13 = row.createCell(2);
                    cell13.setCellValue(userList.get(j).getPassword());
                    HSSFCell cell14 = row.createCell(3);
                    cell14.setCellValue(sdf.format(userList.get(j).getCreateTime()));
                    HSSFCell cell15 = row.createCell(4);
                    cell15.setCellValue(sdf.format(userList.get(j).getUpdateTime()));
                }
            }
            //5、输出
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    /**
     * 创建单元格样式.
     * @param workbook 工作簿
     * @param fontSize 字体大小
     * @return 单元格样式
     */
    private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 创建字体
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗字体// 加粗字体
        font.setFontHeightInPoints(fontSize);
        // 加载字体
        style.setFont(font);
        return style;
    }
    
    /**
     * 导入工作表.
     * @param file
     * @param userExcelFileName
     */
    public static List<SysUserBean> importExcel(MultipartFile file, String userExcelFileName) {
        List<SysUserBean> userList = new ArrayList<SysUserBean>();
        try {
            Workbook workbook = null;
            try {
                workbook = new HSSFWorkbook(file.getInputStream());
            } catch (Exception e) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
            // 获取工作表
            Sheet sheetAt = workbook.getSheetAt(0);
            // 获取行
            if(sheetAt.getPhysicalNumberOfRows() > 2) {
                // 获取单元格第三行开始
                for (int k = 2; k < sheetAt.getPhysicalNumberOfRows(); k++) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String nowDate = sdf.format(new Date()).toString();
                    Row row = sheetAt.getRow(k);
                    SysUserBean user = new SysUserBean();
                    //设置用户名
                    user.setUsercode(row.getCell(0).getStringCellValue());
                    user.setUsername(row.getCell(1).getStringCellValue());
                    user.setPassword(row.getCell(2).getStringCellValue());
                    user.setCreateTime(sdf.parse(nowDate));
                    user.setUpdateTime(sdf.parse(nowDate));
                    userList.add(user);
                }
                return userList;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userList;
    }
}
