package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(id = "search_query_top")
    WebElement searchFieldInput;

    @FindBy(name = "submit_search")
    WebElement searchSubmitButton;

    @FindBy(className = "product-count")
    WebElement searchResultConfirmation;

    @FindBy(xpath = "//div[@id='center_column']//a[@class='product-name']")
    WebElement searchResultProductName;

    @FindBy(xpath = "(//span[@class='price product-price'])[2]")
    WebElement searchResultProductPrice;

    @FindBy(xpath = "//a[text()='Women']")
    WebElement womanCategoryLink;

    @FindBy(linkText = "Sign in")
    WebElement signInButton;

    @FindBy(className = "logout")
    WebElement signOutButton;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement cartButton;

    @FindBy (className = "account")
    WebElement myAccountHeaderButton;


    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnMyAccountHeaderButton() {
        myAccountHeaderButton.click();
    }

    public void sendSearchQuery() {
        searchFieldInput.click();
        searchFieldInput.sendKeys("Blouse");
        searchSubmitButton.click();

    }

    public WebElement getSearchResultConfirmation() {
        return searchResultConfirmation;
    }

    public String getSearchResultProductName() {
        return searchResultProductName.getText();
    }

    public String getSearchResultProductPrice() {
        return searchResultProductPrice.getText();
    }

    public void clickOnWomanCategoryPage() {
        womanCategoryLink.click();

    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public String getSignOutButton() {
        return signOutButton.getText();
    }
}
