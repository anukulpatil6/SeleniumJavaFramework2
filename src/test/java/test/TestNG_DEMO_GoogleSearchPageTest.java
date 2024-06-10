package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.GoogleSearchPageObject;

public class TestNG_DEMO_GoogleSearchPageTest {
   public static WebDriver driver = null;
   @BeforeTest
   public void setUpTest(){
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public static void googleSearchTest(){
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);

        driver.get("https://google.com/");
        searchPageObj.setTextInSearchBox("automation is life");
        searchPageObj.clickSearchButton();
    }
    @AfterTest
    public void tearDownTest(){
        //close driver
        driver.close();
        driver.quit();
        System.out.println("test completed");
    }
}
