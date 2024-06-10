//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//public class DesiredCapabilities_Demo {
//    public static void main(String[] args) {
//           String projectpath = System.getProperty("user.dir");
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        caps.setCapability("ignoreProtectedModeSettings",true);
//
//        InternetExplorerOptions options = new InternetExplorerOptions();
//        options.merge(caps);
//
//        System.setProperty("webdriver.ie.driver",projectpath+"\\driver\\iedriver\\IEDriverServer.exe");
//
//        WebDriver driver = new InternetExplorerDriver(options);
//        driver.get("https://google.com/");
//
//        driver.findElement(By.name("q")).sendKeys("automation");
//        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
//
//        driver.close();
//        driver.quit();
//
//    }
//}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {
    public static void main(String[] args) {
        // Get the project directory path
        String projectPath = System.getProperty("user.dir");

        // Set the desired capabilities for Internet Explorer
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("ignoreProtectedModeSettings", true);

        // Create InternetExplorerOptions and merge with desired capabilities
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.merge(caps);

        // Set the path for the IE driver executable
        System.setProperty("webdriver.ie.driver", projectPath + "\\driver\\iedriver\\IEDriverServer.exe");

        // Initialize the Internet Explorer driver with the specified options
        WebDriver driver = new InternetExplorerDriver(options);

        // Navigate to Google
        driver.get("https://google.com/");

        // Perform search operation
        driver.findElement(By.name("q")).sendKeys("automation");
        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

        // Close the browser
        driver.close();
        driver.quit();
    }
}
