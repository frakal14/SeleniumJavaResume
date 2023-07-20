package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@title=\"Add my first address\"]")
    WebElement addMyFirstAddressButton;




    public void clickOnaAdMyFirstAddressButton() {
        wait.until(ExpectedConditions.visibilityOf(addMyFirstAddressButton));
        addMyFirstAddressButton.click();
    }

    public String getAddMyFirstAddressButton() {
       return addMyFirstAddressButton.getText();
    }










}
