package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPasswordPage extends BasePage{
    //Ссылка "Войти"
    private By linkLogin = By.className("Auth_link__1fOlj");

    public RecoverPasswordPage(WebDriver driver) {
        super(driver);
    }

    //Метод нажатия на ссылку "Войти"
    public LoginAccountPage clickLinkLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(linkLogin));
        driver.findElement(linkLogin).click();
        return new LoginAccountPage(driver);
    }
}
