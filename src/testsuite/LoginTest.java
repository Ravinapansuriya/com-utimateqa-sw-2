package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setUP() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on sign in link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a")).click();
        //Verify the welcome back text
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("ravina@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("ravina@123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//ul[@class='form-error__list']/li")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }

}
