package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAccountPage extends BasePage {
    //Поле ввода "Email"
    private By inputFieldEmail = By.xpath("//input[@name='name']");
    //Поле ввода "Пароль"
    private By inputFieldPassword = By.name("Пароль");
    //Кнопка "Войти"
    private By loginButton = By.xpath("//*[contains(@class, 'button_button__33qZ0') and contains(text(), 'Войти')]");
    //Ссылка "Зарегистрироваться"
    private By linkRegistration = By.xpath("//a[(@class='Auth_link__1fOlj' and text()='Зарегистрироваться')]");
    //Ссылка "Восстановить пароль"
    private By linkRecoverPassword = By.xpath(".//*[contains(@href, '/forgot-password')]");

    public LoginAccountPage(WebDriver driver) {
        super(driver);
    }

    //Метод нажатия на ссылку "Зарегистрироваться"
    public RegistrationFormPage clickLinkRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(linkRegistration));
        driver.findElement(linkRegistration).click();
        return new RegistrationFormPage(driver);
    }

    //Метод получения текста кнопки "Войти"
    public String getTextLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).getText();
    }

    //Метод ввода email в поле "Email"
    public LoginAccountPage setEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputFieldEmail));
        driver.findElement(inputFieldEmail).clear();
        driver.findElement(inputFieldEmail).sendKeys(email);
        return this;
    }

    //Метод ввода пароля в поле "Пароль"
    public LoginAccountPage setPassword(String password) {
        driver.findElement(inputFieldPassword).clear();
        driver.findElement(inputFieldPassword).sendKeys(password);
        return this;
    }

    //Метод нажатия на кнопку "Войти"
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Методы для перехода на разные страницы после клика на кнопку "Войти":

    //Переход на страницу входа
    public MainPage clickLoginButtonGoToMainPage() {
        clickLoginButton();
        return new MainPage(driver);
    }

    //Переход на страницу входа
    public HeaderPage clickLoginButtonGoToHeaderPage() {
        clickLoginButton();
        return new HeaderPage(driver);
    }

    //Метод нажатия на ссылку "Восстановить пароль"
    public RecoverPasswordPage clickLinkRecoverPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(linkRecoverPassword));
        driver.findElement(linkRecoverPassword).click();
        return new RecoverPasswordPage(driver);
    }

    //Метод проверки видимости кнопки "Войти"
    public boolean checkVisibilityLoginButton() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
