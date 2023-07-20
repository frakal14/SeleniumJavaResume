package pages;

import model.LogInForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class LogInPage extends BasePage {

    HeaderPage headerPage;

    public LogInPage(WebDriver driver) {
        super(driver);

        headerPage = new HeaderPage(driver);
    }


    // Authenticate page selectors:
    @FindBy(id = "email_create")
    WebElement emailAddressInput;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountSubmitButton;

    @FindBy(id = "email")
    WebElement emailAddressLogInInput;

    @FindBy(id = "passwd")
    WebElement passwordLogInInput;

    @FindBy(id = "SubmitLogin")
    WebElement loginSubmitButton;


    public WebElement getEmailAddressInput() {
        return emailAddressInput;
    }

    public WebElement getCreateAccountSubmitButton() {
        return createAccountSubmitButton;
    }

    public void clickOnEmailLogInInput() {
        emailAddressInput.click();
    }

    public void openLoginFormPage() {
        wait.until(ExpectedConditions.visibilityOf(headerPage.signInButton));
        headerPage.clickOnSignInButton();
    }



    public void sendFilledInLogInFormWithData(LogInForm logInForm) {
        clickOnEmailLogInInput();
        emailAddressLogInInput.sendKeys(logInForm.getEmail());
        passwordLogInInput.sendKeys(logInForm.getPassword());
        loginSubmitButton.click();



    }







}


