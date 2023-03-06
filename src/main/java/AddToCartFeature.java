import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class AddToCartFeature {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        System.setProperty ("webdriver.chrome.driver",".\\chromedriver.exe" );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.userLogin("standard_user","secret_sauce");
        Catalog catalog = new Catalog(driver);
        //Verify Number of Items in Cart is equal to total items selected on page
        catalog.addProductToCart();
        Assert.assertEquals("6",catalog.getCartItemCount(),"Number of Items in Cart does not match to items selected");
        //Verify Number of Items in Cart after item removed from cart
        catalog.removeProductFromCart();
        Assert.assertEquals("5",catalog.getCartItemCount(),"Number of Items in Cart does not match to items selected");
    }
}