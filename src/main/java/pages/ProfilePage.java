package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private By logoutButton = By.className("Account_button__14Yp3");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    //Метод нажатия на кнопку "Выход"
    public LoginAccountPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new LoginAccountPage(driver);
    }

    //Метод проверки видимости кнопки "Выход"
    public boolean checkVisibilityLogoutButton() {
        return driver.findElement(logoutButton).isDisplayed();
    }
}
