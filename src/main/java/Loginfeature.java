import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Loginfeature {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        System.setProperty ("webdriver.chrome.driver",".\\chromedriver.exe" );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        //Verify login without credentials
        login.loginWithoutCred();
        Assert.assertEquals("Epic sadface: Username is required",login.getErrorMessage());
        //Verify login with invalid credentials
        login.userLogin("","");
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
                login.getErrorMessage());
        login.clearText();
        //Verify login for locked out user
        login.userLogin("locked_out_user","secret_sauce");
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.",login.getErrorMessage());
    }
}
