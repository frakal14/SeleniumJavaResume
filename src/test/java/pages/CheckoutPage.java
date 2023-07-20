package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(className = "submit2")
    WebElement checkoutAddressSubmitButton;


    public void clickOnCheckoutAddressSubmitButton () {
        checkoutAddressSubmitButton.click();
    }

    public WebElement getCheckoutAddressSubmitButton() {
        return checkoutAddressSubmitButton;
    }
}
