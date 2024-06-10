package utils;

public class ExclUtilsDemo {
    public static void main(String[] args) {
        String projectpath = System.getProperty("user.dir");
        ExcelUtils excel = new ExcelUtils(projectpath+ "\\excel\\data.xlsx","sheet1");
        excel.getRowCount();
        excel.getColCount();
        excel.getCellDatastring(1,0);
        excel.getCellDataNumber(1,1);


    }
}
