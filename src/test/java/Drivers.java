
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class Drivers {
    public static ExtentTest test;
    static ExtentReports report;
    ExtentHtmlReporter reporter;
    public static WebDriver driver;
    @BeforeTest
    public void Driver() {

        reporter = new ExtentHtmlReporter("./MyReport.html");
        report = new ExtentReports();
        report.attachReporter(reporter);
        driver = new ChromeDriver();
        driver.get("https://www.takealot.com/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void FlushDriver()
    {
        report.flush();
       // driver.quit();
    }
}
