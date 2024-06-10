package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GoogleSearchPageObject;

public class GoogleSearchPageTest {
   public static WebDriver driver = null;
    public static void main(String[] args) {
        googleSearchTest();

    }

    public static void googleSearchTest(){
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);

        driver.get("https://google.com/");
        searchPageObj.setTextInSearchBox("automation is life");
        searchPageObj.clickSearchButton();
    }
}
