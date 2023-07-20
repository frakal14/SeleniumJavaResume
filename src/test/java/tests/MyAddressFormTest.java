package tests;

import enums.Country;
import enums.State;
import model.AddressForm;
import model.LogInForm;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.MyAddressFormPage;
import utils.MyAddressFormPageTitleUtils;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyAddressFormTest extends BaseTest {


    LogInPage logInPage;
    HeaderPage headerPage;
    MyAddressFormPage myAddressFormPage;
    MyAccountPage myAccountPage;

    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        logInPage = new LogInPage(driver);
        headerPage = new HeaderPage(driver);
        myAccountPage = new MyAccountPage(driver);
        myAddressFormPage = new MyAddressFormPage(driver);

    }


    @Test
    @Order(1)
    public void userIsAbleToAddMyFirstAddress() {
        logInPage.openLoginFormPage();
        LogInForm logInForm = new LogInForm();
        logInForm.setEmail("test@example.com");
        logInForm.setPassword("Password123!");
        logInPage.sendFilledInLogInFormWithData(logInForm);
        headerPage.clickOnMyAccountHeaderButton();
        myAccountPage.clickOnaAdMyFirstAddressButton();

        AddressForm addressForm = new AddressForm();
        addressForm.setCompany("Company");
        addressForm.setAddress("Broadway Ave 12");
        addressForm.setCity("New York");
        addressForm.setState(State.NEW_YORK);
        addressForm.setPostalCode("12345");
        addressForm.setCountry(Country.UNITED_STATES);
        addressForm.setHomePhone("0001124441");
        addressForm.setMobilePhone("090909090");
        addressForm.setAdditionalInformation("test");
        addressForm.setAddressAlias("Main test billing address");
        myAccountPage.clickOnaAdMyFirstAddressButton();
        myAddressFormPage.clickOnAddressDeleteButton();

        assertThat(driver.getTitle().equals(MyAddressFormPageTitleUtils.MY_ADDRESS_PAGE_TITLE));

    }
}
