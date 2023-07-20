package tests;

import model.LogInForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.LogInPage;
import pages.MyAccountPage;
import utils.MyAccountTitleUtils;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyAccountTest extends BaseTest {

    LogInPage logInPage;
    HeaderPage headerPage;
    MyAccountPage myAccountPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        logInPage = new LogInPage(driver);
        headerPage = new HeaderPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }


    @Test
    @Order(1)
    public void userIsAbleToOpenMyAccount() {
        logInPage.openLoginFormPage();
        LogInForm logInForm = new LogInForm();
        logInForm.setEmail("test@example.com");
        logInForm.setPassword("Password123!");
        logInPage.sendFilledInLogInFormWithData(logInForm);
        headerPage.clickOnMyAccountHeaderButton();

        assertThat(MyAccountTitleUtils.MY_ACCOUNT_PAGE_TITLE).isEqualTo(MyAccountTitleUtils.MY_ACCOUNT_PAGE_TITLE);

    }


}
