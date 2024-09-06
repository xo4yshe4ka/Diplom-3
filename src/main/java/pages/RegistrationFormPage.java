package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationFormPage extends BasePage {
    //Поле ввода "Имя"
    private By inputFieldName = By.xpath("(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]");
    //Поле ввода "Email"
    private By inputFieldEmail = By.xpath("(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]");
    //Поле ввода "Пароль"
    private By inputFieldPassword = By.name("Пароль");
    //Кнопка зарегистрироваться
    private By registrationButton = By.xpath("//*[contains(@class, 'button_button__33qZ0') " +
            "and contains(text(), 'Зарегистрироваться')]");
    //Кнопка Войти
    private By loginButton = By.className("Auth_link__1fOlj");
    //Сообщение об ошибке "Некорректный пароль"
    private By errorMessagePassword = By.xpath("//*[contains(@class, 'input__error') " +
            "and contains(text(), 'Некорректный пароль')]");

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    //Метод ввода имени в поле ввода "Имя"
    public RegistrationFormPage setInputFieldName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputFieldName));
        driver.findElement(inputFieldName).clear();
        driver.findElement(inputFieldName).sendKeys(name);
        return this;
    }

    //Метод ввода email в поле ввода "Email"
    public RegistrationFormPage setInputFieldEmail(String email) {
        driver.findElement(inputFieldEmail).clear();
        driver.findElement(inputFieldEmail).sendKeys(email);
        return this;
    }

    //Метод ввода пароля в поле ввода "Пароль"
    public RegistrationFormPage setInputFieldPassword(String password) {
        driver.findElement(inputFieldPassword).clear();
        driver.findElement(inputFieldPassword).sendKeys(password);
        return this;
    }

    //Метод нажатия на кнопку "Зарегистрироваться"
    public void clickRegistrationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationButton));
        driver.findElement(registrationButton).click();
    }

    //Методы для перехода на разные страницы после клика на кнопку "Зарегистрироваться":

    //Переход на страницу входа
    public LoginAccountPage clickRegistrationButtonGoToLoginPage() {
        clickRegistrationButton();
        return new LoginAccountPage(driver);
    }

    //Метод нажатия на кнопку "Зарегистрироваться"
    public RegistrationFormPage clickRegistrationButtonWithoutTransition() {
        clickRegistrationButton();
        return this;
    }

    //Метод получения текста ошибки поля "Пароль"
    public String getErrorMessagePassword() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessagePassword));
        return driver.findElement(errorMessagePassword).getText();
    }

    //Метод нажатия на кнопку "Войти"
    public LoginAccountPage clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new LoginAccountPage(driver);
    }
}
