package tests;

import model.LogInForm;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.LogInPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogInTest extends BaseTest{

    private LogInPage logInPage;
    private HeaderPage headerPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        logInPage = new LogInPage(driver);
        headerPage = new HeaderPage(driver);
    }


    @Test
    @Order(1)
    // TODO implement parsing user credentials data from properties file
    public void userIsAbleToLoginWithValidData() {
        logInPage.openLoginFormPage();
        LogInForm logInForm = new LogInForm();
        logInForm.setEmail("test@example.com");
        logInForm.setPassword("Password123!");
        logInPage.sendFilledInLogInFormWithData(logInForm);

        assertThat(headerPage.getSignOutButton().equals("Sign out")).isTrue();






    }





}
