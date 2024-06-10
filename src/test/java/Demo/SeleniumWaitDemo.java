package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

public class SeleniumWaitDemo {
    public static void main(String[] args) {
        seleniumWaits();

    }
    public static  void seleniumWaits(){
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20) );
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));


        driver.findElement(By.name("abcd")).click();

        driver.close();
        driver.quit();

    }

}
