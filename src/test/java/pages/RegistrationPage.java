package pages;

import com.github.javafaker.Faker;
import model.RegistrationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    private HeaderPage headerPage;


    public RegistrationPage(WebDriver driver) {
        super(driver);

        headerPage = new HeaderPage(driver);

    }



    // Authenticate page selectors:
    @FindBy(id = "email_create")
    WebElement emailAddressInput;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountSubmitButton;

    //     YOUR PERSONAL INFORMATION SELECTORS
    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement radioButtonMr;

    @FindBy(id = "customer_firstname")
    WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    WebElement lastNameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "days")
    WebElement dayDateOfBirthDropDown;

    @FindBy(id = "months")
    WebElement monthDateOfBirthDropDown;

    @FindBy(id = "years")
    WebElement yearDateOfBirthDropDown;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;


    @FindBy(id = "submitAccount")
    WebElement registerSubmitButton;

    @FindBy(className = "page-heading")
    WebElement myAccountTitle;



    public void clickOnCreateAnAccountEmailInput() {
        emailAddressInput.click();
    }

    public void clickOnGenderRadioButton() {
        radioButtonMr.click();
    }

    public void fillEmailAddressInputAndSubmit() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        emailAddressInput.sendKeys(email);
        createAccountSubmitButton.click();
    }


    public void openRegistrationFormPage() {
        wait.until(ExpectedConditions.visibilityOf(headerPage.signInButton));
        headerPage.clickOnSignInButton();
        clickOnCreateAnAccountEmailInput();
        fillEmailAddressInputAndSubmit();
    }

    public void sendRegistrationForm(RegistrationForm registrationForm) {
        wait.until(ExpectedConditions.visibilityOf(radioButtonMr));
        radioButtonMr.click();
        firstNameInput.sendKeys(registrationForm.getFirstNameCustomer());
        lastNameInput.sendKeys(registrationForm.getLastNameCustomer());
        passwordInput.sendKeys(registrationForm.getPassword());

        //TODO: change selectByIndex TO MONTH enums
        Select day = new Select(dayDateOfBirthDropDown);
        day.selectByIndex(1);

        Select month = new Select(monthDateOfBirthDropDown);
        month.selectByIndex(1);

        Select year = new Select(yearDateOfBirthDropDown);
        year.selectByIndex(23);

        newsletterCheckbox.click();
        registerSubmitButton.click();
    }

    public WebElement getMyAccountTitle() {
        return myAccountTitle;
    }
}
