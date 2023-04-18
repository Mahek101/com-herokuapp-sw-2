package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp() {
        openBrowser(baseUrl); // Browser setup method from BaseTest class
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.tagName("h2"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text is not Displayed",expectedText,actualText);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedText = "Your username is invalid!";
        String actualText = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue("Text is not Displayed",actualText.contains(expectedText));
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue("Text is not Displayed",actualText.contains(expectedText));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
