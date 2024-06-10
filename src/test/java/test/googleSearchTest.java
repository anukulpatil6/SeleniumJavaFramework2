package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GoogleSearchpage;


public class googleSearchTest {
    public static void main(String[] args) {

        googlesearch();
    }
    public static void googlesearch() {
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //goto google.com
        driver.get("https://google.com/");
//        enter text in search textbox
//        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        GoogleSearchpage.textbox_search(driver).sendKeys("Automation step by step");

        //click on search button
//        driver.findElement(By.name("btnK")).click();
//        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        GoogleSearchpage.Button_search(driver).sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

        driver.quit();


    }
}
