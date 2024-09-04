package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    //Кнопка "Войти а аккаунт"
    private By loginAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    //Кнопка "Оформить заказ"
    private By placeOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");
    //Кнопка "Булки"
    private By bunButton = By.xpath(".//span[text() = 'Булки']/parent::*");
    //Кнопка "Соусы"
    private By saucesButton = By.xpath(".//span[text() = 'Соусы']/parent::*");
    //Кнопка "Начинки"
    private By fillingsButton = By.xpath(".//span[text() = 'Начинки']/parent::*");
    //Кнопка "Булки" активна
    private By activeBunButton = By.xpath(".//span[text() = 'Булки']/parent::*" +
            "[contains(@class, 'tab_tab_type_current__2BEPc')]");
    //Кнопка "Соусы" активна
    private By activeSaucesButton = By.xpath(".//span[text() = 'Соусы']/parent::*" +
            "[contains(@class, 'tab_tab_type_current__2BEPc')]");
    //Кнопка "Начинки" активна
    private By activeFillingsButton = By.xpath(".//span[text() = 'Начинки']/parent::*" +
            "[contains(@class, 'tab_tab_type_current__2BEPc')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //метод нажатия на кнопку "Войти в аккаунт"
    public LoginAccountPage clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
        return new LoginAccountPage(driver);
    }

    //Метод получения текста кнопки "Оформить заказ"
    public String getTextPlaceOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));
        return driver.findElement(placeOrderButton).getText();
    }

    //Метод нажатия на кнопку "Булки"
    public MainPage clickBunButton() {
        driver.findElement(bunButton).click();
        return new MainPage(driver);
    }

    //Метод проверки активности кнопки "Булки"
    public boolean isActiveBunButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(activeBunButton));
        return driver.findElement(activeBunButton).isDisplayed();
    }

    //Метод нажатия на кнопку "Соусы"
    public MainPage clickSaucesButton() {
        driver.findElement(saucesButton).click();
        return new MainPage(driver);
    }

    //Метод проверки активности кнопки "Соусы"
    public boolean isActiveSaucesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(activeSaucesButton));
        return driver.findElement(activeSaucesButton).isDisplayed();
    }

    //Метод нажатия на кнопку "Начинки"
    public MainPage clickFillingsButton() {
        driver.findElement(fillingsButton).click();
        return new MainPage(driver);
    }

    //Метод проверки активности кнопки "Начинки"
    public boolean isActiveFillingsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(activeFillingsButton));
        return driver.findElement(activeFillingsButton).isDisplayed();
    }
}
