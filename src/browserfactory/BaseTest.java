package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();
        driver.get(baseUrl); // Launch the URL
        driver.manage().window().maximize(); // Maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Implicit time out
    }

    public void closeBrowser(){
        driver.quit(); // Close all windows
    }
}


