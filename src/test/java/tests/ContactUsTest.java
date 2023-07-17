package tests;

import enums.MessageSubject;
import model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsPage;
import pages.HeaderPage;
import utils.PageTitleUtils;


import static org.assertj.core.api.Assertions.*;

public class ContactUsTest extends BaseTest {

    private HeaderPage headerPage;
    private ContactUsPage contactUsPage;


    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle().equals(PageTitleUtils.HOME_PAGE_TITLE));

        headerPage = new HeaderPage(driver);
        contactUsPage = new ContactUsPage(driver);

    }


    @Test
    public void shouldNotSendEmptyContactForm() {
        // implicit wait - Global wait for all of the elements
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        headerPage.clickOnContactUsLink();
        contactUsPage.sendContactUsClick();

        // hard wait
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


//        // Explicit Wait - for individual actions
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(contactUsPage.alertBoxContactUs));

        assertThat(contactUsPage.IsRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldNotSendContactUsFormWithEmailOnly() {

        headerPage.clickOnContactUsLink();
        contactUsPage.emailContactUsSendKeys("tester@gmail.com");
        contactUsPage.sendContactUsClick();

        assertThat(contactUsPage.IsRedAlertBoxDisplayed()).isTrue();


    }

    @Test
    public void shouldSendContactUsFormWithValidData() {
        headerPage.clickOnContactUsLink();

        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail("test@example.com");
        message.setOrderReference("123");
        message.setMessage("text for testing purposes");

        contactUsPage.sendContactUsForm(message);

        assertThat(contactUsPage.IsGreenAlertBoxDisplayed()).isTrue();

    }


}
