import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class HomePageTest {

    private WebDriver driver; // komunikacja z przegladarka
    private WebElement element; // interakcje z elementami na stronie

    // przed testami
    @BeforeAll
    public static void setuoClass() {
        WebDriverManager.chromedriver().setup();
    }

    // przed kazdym testem
    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
    }
    // po kazdym tescie
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void shouldReturnCorrectPageTitle() {
        driver.get("http://automationpractice.pl/index.php?");

        Assertions.assertThat(driver.getTitle().equals("My Shop"));


    }



}
