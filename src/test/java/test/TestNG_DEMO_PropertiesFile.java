package test;

import config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.GoogleSearchPageObject;

import java.util.Properties;

public class TestNG_DEMO_PropertiesFile {
   public static WebDriver driver = null;
   public static String browsername = null;
   @BeforeTest
   public void setUpTest(){
       String projectpath = System.getProperty("user.dir");
       PropertiesFile.getProperties();
       if(browsername.equalsIgnoreCase("chrome")) {
           System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
           driver = new ChromeDriver();
       } else if (browsername.equalsIgnoreCase("firefox")) {
           System.setProperty("webdriver.gecko.driver","C:\\Users\\LENOVO\\IdeaProjects\\MyMavenproject\\driver\\geckodriver\\geckodriver.exe");
           driver = new FirefoxDriver();

       }
   }

    @Test
    public static void googleSearchTest(){
//        String projectpath = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
//        driver = new ChromeDriver();

        GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);

        driver.get("https://google.com/");
        searchPageObj.setTextInSearchBox("automation is life");
        searchPageObj.clickSearchButton();
    }
    @AfterTest
    public void tearDownTest(){
        //close driver
        driver.close();
//        driver.quit();
        System.out.println("test completed");
        PropertiesFile.setProperties();
    }
}
