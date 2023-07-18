package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WomanCategoryPage extends BasePage {

    public WomanCategoryPage(WebDriver driver) {
        super(driver);
    }

    // //*[@id="center_column"]/ul
    @FindBy(xpath = "//*[contains(text(), '$')]")
    List<WebElement> productPrices;


    public List<String> getStringProductPricesOnPlp() {
        return productPrices.stream()
                .map(el -> el.getText().replace("$", ""))
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }

//    public List<Integer> updatedList() {
//       return getStringProductPricesOnPlp().stream()
//                .filter(str -> !str.isEmpty())
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//    }




}
