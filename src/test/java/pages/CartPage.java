package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends  BasePage {

    WomanCategoryPage womanCategoryPage;
    HeaderPage headerPage;

    public CartPage(WebDriver driver) {
        super(driver);

        womanCategoryPage = new WomanCategoryPage(driver);
        headerPage = new HeaderPage(driver);

    }



    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement checkoutCartButton;


    public String getCheckoutButtonElement() {
       return checkoutCartButton.getText();
    }




}
