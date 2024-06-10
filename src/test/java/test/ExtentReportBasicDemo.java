package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.*;

public class ExtentReportBasicDemo {
    private static WebDriver driver;
    public static void main(String[] args) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReport.html");

        //Create extent report and attach reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //create a toggle for the given test , add all log event under it
        ExtentTest test1 = extent.createTest("Google search test one","this is a test to validate google search functionality");
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectpath+"\\driver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        test1.log(Status.INFO,"starting test case");
        driver.get("https://google.com/");
        test1.pass("Navigating to google .com");
        driver.findElement(By.name("q")).sendKeys("automation is life");
        test1.pass("entered text in searchbox");
        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
        test1.pass("pressed keyboard enter key");
        driver.close();


        test1.pass("closed the browser");
        test1.info( "test completed");
        extent.flush();

    }
}
