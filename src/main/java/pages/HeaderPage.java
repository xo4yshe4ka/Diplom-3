package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    //Кнопка "Личный кабинет"
    private By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//*[contains(text(), 'Конструктор')]");
    //Логотип "Stellar burgers"
    private By logoStellarBurgers = By.className("AppHeader_header__logo__2D0X2");private By modal = By.xpath(".//*[@class = 'Modal_modal_overlay__x2ZCr']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    // Метод нажатия на кнопку "Личный кабинет"
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    //Методы для перехода на разные страницы после клика на кнопку "Личный кабинет":

    //Переход в личный кабинет
    public ProfilePage clickPersonalAccountButtonGoToPersonalAccount() {
        clickPersonalAccountButton();
        return new ProfilePage(driver);
    }

    //Переход на страницу входа
    public LoginAccountPage clickPersonalAccountButtonGoToLoginPage() {
        clickPersonalAccountButton();
        return new LoginAccountPage(driver);
    }

    //Переход на HeaderPage
    public HeaderPage clickPersonalAccountButtonGoToHeaderPage() {
        clickPersonalAccountButton();
        return new HeaderPage(driver);
    }

    //Метод нажатия на кнопку "Конструктор"
    public MainPage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new MainPage(driver);
    }

    //Метод нажатия на логотип "Stellar burgers"
    public MainPage clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
        return new MainPage(driver);
    }
}
