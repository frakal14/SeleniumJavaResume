package tests;

import model.LogInForm;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.LogInPage;
import pages.WomanCategoryPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartTest extends BaseTest {


    WomanCategoryPage womanCategoryPage;
    LogInPage logInPage;
    CartPage cartPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        womanCategoryPage = new WomanCategoryPage(driver);
        logInPage = new LogInPage(driver);
        cartPage = new CartPage(driver);

    }


    @Test
    @Order(1)
    //TODO Construct helper login method for all methods involved
    public void loggedInUserIsAbleToEnterCartWithProduct() {
        logInPage.openLoginFormPage();
        LogInForm logInForm = new LogInForm();
        logInForm.setEmail("test@example.com");
        logInForm.setPassword("Password123!");
        logInPage.sendFilledInLogInFormWithData(logInForm);
        womanCategoryPage.addWomanCategoryProductToCart();

        assertThat(cartPage.getCheckoutButtonElement().equals("Proceed to checkout")).isTrue();


    }






}
