package tests;

import model.RegistrationForm;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;
import utils.MyAccountTitleUtils;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTest extends BaseTest {

    private RegistrationPage registrationPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        registrationPage = new RegistrationPage(driver);

    }

    @Test
    @Order(1)
    public void userRegistrationFormWithValidData() {
        registrationPage.openRegistrationFormPage();
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setFirstNameCustomer("John");
        registrationForm.setLastNameCustomer("Doe");
        registrationForm.setPassword("Password123!");
        registrationPage.sendRegistrationForm(registrationForm);

        assertThat(registrationPage.getMyAccountTitle().equals(MyAccountTitleUtils.MY_ACCOUNT_PAGE_TITLE));

    }


}
