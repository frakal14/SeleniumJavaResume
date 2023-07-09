package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "submitMessage")
    WebElement sendContactUsButton;

    @FindBy(className = "alert-danger")
    WebElement alertBoxContactUs;

    @FindBy(id = "email")
    WebElement emailInput;

    public boolean IsRedAlertBoxDisplayed() {
        boolean isDisplayed = false;
        try {
           isDisplayed = alertBoxContactUs.isDisplayed();
        } catch (NoSuchElementException e) { }

        return isDisplayed;
    }

    public void sendContactUsClick(){
        sendContactUsButton.click();

    }

    public void emailContactUsSendKeys (String email) {
        emailInput.sendKeys(email);
    }





}
