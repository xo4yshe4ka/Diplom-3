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
import static org.junit.Assert.assertTrue;

public class TestProfile extends BaseTest{
    UserClient userClient;
    User user;
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
    @DisplayName("Test click button personal account go to profile page")
    public void testGoToProfilePage() {
        boolean visibilityButtonLogout = new HeaderPage(driver)
                .clickPersonalAccountButtonGoToLoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToHeaderPage()
                .clickPersonalAccountButtonGoToPersonalAccount()
                .checkVisibilityLogoutButton();
        assertTrue("Must be true", visibilityButtonLogout);
    }

    @Test
    @DisplayName("Test click button constructor from profile page")
    public void testClickButtonConstructorFromProfilePage() {
        String actualText = new MainPage(driver)
                .clickLoginAccountButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToHeaderPage()
                .clickPersonalAccountButtonGoToHeaderPage()
                .clickConstructorButton()
                .getTextPlaceOrderButton();
        assertThat("Text button must be 'Оформить заказ'", actualText, equalTo("Оформить заказ"));
    }

    @Test
    @DisplayName("Test click logo from profile page")
    public void testClickLogoFromPersonalAccount() {
        String actualText = new MainPage(driver)
                .clickLoginAccountButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToHeaderPage()
                .clickPersonalAccountButtonGoToHeaderPage()
                .clickLogoStellarBurgers()
                .getTextPlaceOrderButton();
        assertThat("Text button must be 'Оформить заказ'", actualText, equalTo("Оформить заказ"));
    }

    @Test
    @DisplayName("Test logout from profile page")
    public void testLogoutFromAccount() {
        boolean visibilityButtonLogin = new MainPage(driver)
                .clickLoginAccountButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButtonGoToHeaderPage()
                .clickPersonalAccountButtonGoToPersonalAccount()
                .clickLogoutButton()
                .checkVisibilityLoginButton();
        assertTrue("Must be true", visibilityButtonLogin);
    }
}
