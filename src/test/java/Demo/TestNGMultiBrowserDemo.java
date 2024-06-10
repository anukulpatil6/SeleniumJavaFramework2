package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

    WebDriver driver = null;
    String projectpath = System.getProperty("user.dir");

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName){

        System.out.println("Browser name is "+ browserName);
        System.out.println("thread is "+ Thread.currentThread().getId());

        if(browserName.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.com",projectpath + "\\driver\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.com", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", projectpath+ "\\driver\\iedriver\\IEDriverServer.exe");

            driver = new InternetExplorerDriver();
        }
    }

    @Test
    public void test1() throws InterruptedException {

    driver.get("http://google.com");
    Thread.sleep(10000);

    }

    @AfterTest
    public void teardown(){
//        driver.close();
        driver.quit();
        System.out.println("Test completed successfully");


    }
}
