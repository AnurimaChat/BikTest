import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id= "user-name") private WebElement userName;
    @FindBy(id= "password") private WebElement password;
    @FindBy(id= "login-button") private WebElement loginBtn;
    @FindBy(xpath= ".//div[@class='error-message-container error']//h3") private WebElement errorMessage;
    WebDriver driver;
    public LoginPage(WebDriver driver){
      this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void userLogin(String UserName, String Password) {
        userName.sendKeys(UserName);
        password.sendKeys(Password);
        loginBtn.click();
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }
    public void loginWithoutCred(){
        loginBtn.click();
    }
    public void clearText(){
        userName.clear();
        password.clear();
    }
}
