import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private final static String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUpDriver() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
