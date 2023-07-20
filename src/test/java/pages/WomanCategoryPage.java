package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class WomanCategoryPage extends BasePage {

    HeaderPage headerPage;

    public WomanCategoryPage(WebDriver driver) {
        super(driver);

        headerPage = new HeaderPage(driver);

    }

    @FindBy(xpath = "//*[contains(text(), '$')]")
    List<WebElement> productPrices;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")
    WebElement addToCartWOmanFirstProduct;

    @FindBy(xpath = "//*[@title='Close']")
    WebElement addToCartClosePopUp;


    public List<String> getStringProductPricesOnPlp() {
        return productPrices.stream()
                .map(el -> el.getText().replace("$", ""))
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }

    public void addFirstWomanFirstProduct() {
        addToCartWOmanFirstProduct.click();
    }

    public void clickOnCLoseAddToCartPopUp() {
        addToCartClosePopUp.click();
    }

    public void clickOnCart() {
        headerPage.cartButton.click();
    }

    // TODO Re-do the method to click on a first object from the product list
    // TODO Create helper method for wait to be re-used globally
    public void addWomanCategoryProductToCart() {
        headerPage.clickOnWomanCategoryPage();
        addFirstWomanFirstProduct();
        wait.until(ExpectedConditions.visibilityOf(addToCartClosePopUp));
        clickOnCLoseAddToCartPopUp();
        clickOnCart();

    }


//    public List<Integer> updatedList() {
//       return getStringProductPricesOnPlp().stream()
//                .filter(str -> !str.isEmpty())
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//    }


}
