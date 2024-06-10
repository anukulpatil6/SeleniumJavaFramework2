package utils;

import config.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
//    public static void main(String[] args) {
//        String excelpath ="C:\\Users\\LENOVO\\IdeaProjects\\MyMavenproject\\excel\\data.xlsx";
//        testData(excelpath,"Sheet1");
//    }
    WebDriver driver= null;
@BeforeTest
public void setUpTest() {
    String projectpath = System.getProperty("user.dir");
   // PropertiesFile.getProperties();
    System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
}



        @Test(dataProvider = "test1data")
    public void test1(String Username,String Password) throws InterruptedException {
        System.out.println(Username + " | "+ Password);

        driver.get("https://www.orangehrm.com/en/");
        driver.findElement(By.name("EmailHomePage")).sendKeys(Username);
        driver.findElement(By.name("action_request")).sendKeys(Keys.ENTER);
        Thread.sleep(200);
//        driver.close();


    }



    @DataProvider(name = "test1data")
    public static Object[][] getData(){
        String excelpath ="C:\\Users\\LENOVO\\IdeaProjects\\MyMavenproject\\excel\\data.xlsx";

        Object data[][]= testData(excelpath,"Sheet1");
        return data;

    }

    public static Object[][] testData(String excelPath, String sheetName){

        ExcelUtils excel = new ExcelUtils(excelPath,sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];
        for(int i=1; i <rowCount;i++)
        {
            for(int j=0;j<colCount;j++)
            {
               String cellData = excel.getCellDatastring(i,j);
                System.out.println(cellData);
                data[i-1][j]= cellData;
            }
            System.out.println( );
        }
        return data;
    }
}
