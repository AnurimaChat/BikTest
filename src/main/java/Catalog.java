import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Catalog {
    @FindBy(xpath= ".//div[@class='inventory_list']//button") private List<WebElement> productBtn;
    @FindBy(xpath= ".//div[@id='shopping_cart_container']/a/span") private WebElement cartCounter;
    WebDriver driver;
    public Catalog(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void addProductToCart() {
        for(int i=0;i<productBtn.size();i++){
            productBtn.get(i).click();
        }
    }
    public void removeProductFromCart() {
            productBtn.get(0).click();
    }
    public String getCartItemCount() {
        return cartCounter.getText();
        }
    }

