package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    static String projectpath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName){
       try{
//           projectpath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);
    }catch (Exception e){
    e.printStackTrace();}
    }

    public static void main(String[] args) {
//        getRowCount();
        getCellDatastring(1,0);
        getCellDataNumber(1,1);
    }
    public static int getRowCount(){
        int rowCount=0;
        rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("no. of rows :"+rowCount);
        return rowCount;
    }

    public static int getColCount(){
        int colCount=0;
        colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("number of col : " + colCount);
        return colCount;
    }
    public static String getCellDatastring(int rownum,int colnum){
        String celldata=null;
        celldata =   sheet.getRow(rownum).getCell(colnum).getStringCellValue();
//        System.out.println(celldata);
        return celldata;

    }
    public static void getCellDataNumber(int rownum,int colnum){

        double  pass = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
//        System.out.println("password :"+ pass);

    }
}
