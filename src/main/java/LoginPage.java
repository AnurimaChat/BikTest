import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id= "user-name") private WebElement userName;
    @FindBy(id= "password") private WebElement password;
    @FindBy(id= "login-button") private WebElement loginBtn;
    WebDriver driver;
    public LoginPage(WebDriver driver){
      this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Catalog userLogin(String UserName, String Password) {
        userName.sendKeys(UserName);
        password.sendKeys(Password);
        loginBtn.click();
        return new Catalog(driver);
    }

}
