package tests;

import model.LogInForm;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckoutTest extends BaseTest {


    private CartPage cartPage;
    private LogInPage logInPage;
    private WomanCategoryPage womanCategoryPage;
    private CheckoutPage checkoutPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        cartPage = new CartPage(driver);
        logInPage = new LogInPage(driver);
        womanCategoryPage = new WomanCategoryPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }


    @Test
    @Order(1)
    public void loggedInUserIsAbleToEnterCheckout() {
        logInPage.openLoginFormPage();
        LogInForm logInForm = new LogInForm();
        logInForm.setEmail("test@example.com");
        logInForm.setPassword("Password123!");
        logInPage.sendFilledInLogInFormWithData(logInForm);
        womanCategoryPage.addWomanCategoryProductToCart();
        cartPage.clickOnCartCheckoutButton();
        checkoutPage.clickOnCheckoutAddressSubmitButton();

        assertThat(checkoutPage.getCheckoutAddressSubmitButton().isDisplayed()).isTrue();




    }


}
