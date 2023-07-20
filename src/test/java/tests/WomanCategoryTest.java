package tests;


import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.WomanCategoryPage;
import utils.PageTitleUtils;


import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WomanCategoryTest extends BaseTest {


    private HeaderPage headerPage;
    private WomanCategoryPage womanCategoryPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        headerPage = new HeaderPage(driver);
        womanCategoryPage = new WomanCategoryPage(driver);


    }


    @Test
    @Order(1)
    // TODO Change list of strings to int and assert prices => 0
    public void plpPricesAreNotNull() {
        headerPage.clickOnWomanCategoryPage();
        System.out.println(womanCategoryPage.getStringProductPricesOnPlp());

        assertThat(womanCategoryPage.getStringProductPricesOnPlp()).isNotEmpty();

    }

}
