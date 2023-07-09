package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        popularItemsPage = new PopularItemsPage(driver);
    }


    @Test
    public void ShouldSeeBestSellersItemsOnHomePage() {
        List<String> productNames = popularItemsPage.getProductNames();
//        List<WebElement> xpath = driver.findElements(By.xpath("//*[@id='blockbestsellers']//*[@class='product-name']"));

//        for (WebElement productName : productNames) {
//            System.out.println(productName.getText());
//        }

        List<String> productsWithEmptyNames = productNames.stream()
                .filter(el -> el.isEmpty())
                .collect(Collectors.toList());
        // TODO Make the assertion better
        assertThat(productsWithEmptyNames).isNotEmpty();
    }


}
