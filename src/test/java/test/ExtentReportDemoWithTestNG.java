package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



public class ExtentReportDemoWithTestNG {
    ExtentSparkReporter htmlReporter;
    WebDriver driver;
    ExtentReports extent;
    @BeforeSuite
    public void setUp(){
        htmlReporter = new ExtentSparkReporter("extentreport1.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }
    @BeforeTest
    public void setUpTest(){
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test1(){

        ExtentTest test = extent.createTest("My First Test");

        driver.get("https://google.com/");
        test.pass("navigating to google .com");
        test.log(Status.INFO,"this step show usage of log status" );
        test.info("this step shows usage of info");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("Screenshot.png").build());
        test.addScreenCaptureFromPath("Screenshot.png");
    }
    @Test
    public void test2(){
        ExtentTest test = extent.createTest("My First Test");
        test.log(Status.INFO,"this step show usage of lof status" );
        test.info("this step shows usage of info");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("Screenshot.png").build());
        test.addScreenCaptureFromPath("Screenshot.png");
    }
@AfterSuite
public void tearDown(){
extent.flush();

}
    @AfterTest
    public void tearDownTest(){
        //close driver
        driver.close();
        driver.quit();
        System.out.println("test completed");
    }

}
