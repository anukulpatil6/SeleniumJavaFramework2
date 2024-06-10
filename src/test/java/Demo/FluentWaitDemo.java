package Demo;

import java.util.function.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class FluentWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        test();
    }
    public static void test() throws InterruptedException {

        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("abcd");
        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

//        driver.findElement(By.xpath("//h3[contains(text(),'ABCD & Company')]")).sendKeys(Keys.ENTER);

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(2L))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement linkelement= driver.findElement(By.xpath("//h3[contains(text(),'ABCD Study')]"));

                if(linkelement.isEnabled()){
                    System.out.println("element found");
                }
                return linkelement;

            }
        });
        element.click();

        Thread.sleep(2000);
//        driver.close();
//        driver.quit();
    }
}
