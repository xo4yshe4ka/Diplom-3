import client.User;
import client.UserClient;
import client.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HeaderPage;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestLoginUser extends BaseTest {
    private UserClient userClient;
    private User user;
    private String accessToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = UserGenerator.getUser();
        accessToken = userClient.createUser(user).extract().path("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }

    @Test
    @DisplayName("Test login by click button login account from main page")
    public void testLoginByClickButtonLoginAccount() {
        String actualText = new MainPage(driver)
                .clickLoginAccountButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToMainPage()
                .getTextPlaceOrderButton();
        assertThat("Text button must be 'Оформить заказ'", actualText, equalTo("Оформить заказ"));
    }

    @Test
    @DisplayName("Test login by click button personal account from main page")
    public void testLoginByClickButtonPersonalAccount() {
        String actualText = new HeaderPage(driver)
                .clickPersonalAccountButtonGoToLoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToMainPage()
                .getTextPlaceOrderButton();
        assertThat("Text button must be 'Оформить заказ'", actualText, equalTo("Оформить заказ"));
    }

    @Test
    @DisplayName("Test login by click button login from registration page")
    public void testLoginByClickButtonEnterFromRegistrationPage() {
        String actualText = new MainPage(driver)
                .clickLoginAccountButton()
                .clickLinkRegistration()
                .clickLoginButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToMainPage()
                .getTextPlaceOrderButton();
        assertThat("Text button must be 'Оформить заказ'", actualText, equalTo("Оформить заказ"));
    }

    @Test
    @DisplayName("Test login by click button login from recover page")
    public void testLoginByClickButtonLoginFromRecoverPasswordPage() {
        String actualText = new MainPage(driver)
                .clickLoginAccountButton()
                .clickLinkRecoverPassword()
                .clickLinkLogin()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToMainPage()
                .getTextPlaceOrderButton();
        assertThat("Text button must be 'Оформить заказ'", actualText, equalTo("Оформить заказ"));
    }
}
