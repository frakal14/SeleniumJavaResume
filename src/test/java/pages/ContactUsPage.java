package pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "submitMessage")
    WebElement sendContactUsButton;

    @FindBy(className = "alert-danger")
    WebElement alertBoxContactUs;

    @FindBy(className = "alert-success")
    WebElement greenAlertBoxContactUs;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "id_contact")
    WebElement subjectSelect;

    @FindBy(id = "id_order")
    WebElement orderReferenceInput;

    @FindBy(id = "message")
    WebElement messageTextArea;


    public boolean IsRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(alertBoxContactUs);
    }

    public boolean IsGreenAlertBoxDisplayed() {
        return isAlertBoxDisplayed(greenAlertBoxContactUs);
    }

    private boolean isAlertBoxDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));
        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;

    }

    public void sendContactUsClick() {
        sendContactUsButton.click();

    }

    public void emailContactUsSendKeys(String email) {
        emailInput.sendKeys(email);
    }

    public void sendContactUsForm(Message message) {
        Select subject = new Select(subjectSelect);
        subject.selectByVisibleText(message.getSubject().getValue());

        emailInput.sendKeys(message.getEmail());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageTextArea.sendKeys(message.getMessage());
        sendContactUsButton.click();

    }


}
