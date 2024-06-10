package Listeners;


import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(TestNGListeners.class)
public class TestNGListenerDemo2 {

    @Test
    public void test5(){

        System.out.println("i am inside test1");
    }

    @Test
    public void test6(){

        System.out.println("i am inside test2");

        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("flipkart");
        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("abc")).sendKeys("asdf");

        driver.close();

    }

    @Test
    public void test7(){

        System.out.println("i am inside test3");
        throw new SkipException("this test is skipped");
    }

    @Test
    public void test8(){

        System.out.println("i am inside test4");
    }
}
