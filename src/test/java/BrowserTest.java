import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {
    public static void main(String[] args) throws InterruptedException {

      //   String projectpath = System.getProperty("user.dir");
//        System.setProperty("webdriver.gecko.driver","C:\\Users\\LENOVO\\IdeaProjects\\MyMavenproject\\driver\\geckodriver\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\IdeaProjects\\MyMavenproject\\driver\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


//        System.setProperty("webdriver.ie.driver",projectpath+"\\driver\\iedriver\\IEDriverServer.exe");
//        WebDriver driver = new InternetExplorerDriver();

        driver.get("https://seleniumhq.org/");
        Thread.sleep(300);
        driver.close();
    }
}
