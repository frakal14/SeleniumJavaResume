package pages;

import model.AddressForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MyAddressFormPage extends BasePage {

    public MyAddressFormPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "id_state")
    WebElement stateDropDown;

    @FindBy(id = "postcode")
    WebElement postalCodeInput;

    @FindBy(id = "id_country")
    WebElement countryDropDown;

    @FindBy(id = "other")
    WebElement additionalInformationInput;

    @FindBy(id = "phone")
    WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    WebElement addressAliasInput;

    @FindBy(className = "submit2")
    WebElement addressFormSubmitButton;

    @FindBy(xpath = "//*[@title='Delete']")
    WebElement addressDeleteButton;



    public void clickOnAddressDeleteButton() {
        addressFormSubmitButton.click();
    }


    public void sendFilledAddressForm(AddressForm addressForm) {

//         TODO: change selectByIndex to enums

        companyInput.sendKeys(addressForm.getCompany());
        address.sendKeys(addressForm.getAddress());
        cityInput.sendKeys(addressForm.getAddress());
        Select state = new Select(stateDropDown);
        state.selectByVisibleText(addressForm.getState().getValue());
        postalCodeInput.sendKeys(addressForm.getPostalCode());
        Select country = new Select(countryDropDown);
        country.selectByVisibleText(addressForm.getCountry().getValue());
        additionalInformationInput.sendKeys(addressForm.getAdditionalInformation());
        homePhoneInput.sendKeys(addressForm.getHomePhone());
        mobilePhoneInput.sendKeys(addressForm.getMobilePhone());
        addressAliasInput.sendKeys(addressForm.getAddressAlias());
        addressFormSubmitButton.click();


    }
}
