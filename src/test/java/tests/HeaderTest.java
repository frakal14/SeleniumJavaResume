package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HeaderTest extends BaseTest {


    private HeaderPage headerPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        headerPage = new HeaderPage(driver);
    }

    @Test
    @Order(1)
    public void searchQueryShouldHaveResults() {
        headerPage.sendSearchQuery();

        assertThat(headerPage.getSearchResultConfirmation().isDisplayed()).isTrue();

    }

    // Compares title and price of the searched product
    @Test
    @Order(2)
    public void searchSpecificProductAndCompareData() {
        headerPage.sendSearchQuery();

        assertThat(headerPage.getSearchResultProductName()).isEqualTo("Blouse");
        assertThat(headerPage.getSearchResultProductPrice()).isEqualTo("$27");

    }




}