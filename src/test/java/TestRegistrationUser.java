import client.User;
import client.UserClient;
import client.UserCredentials;
import client.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import pages.MainPage;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestRegistrationUser extends BaseTest {
    private UserClient userClient;
    private User user;
    private String accessToken;


    @Test
    @DisplayName("Test registration new user")
    public void testRegistrationNewUser() {
        userClient = new UserClient();
        user = UserGenerator.getUser();
        String actualText = new MainPage(driver)
                .clickLoginAccountButton()
                .clickLinkRegistration()
                .setInputFieldName(user.getName())
                .setInputFieldEmail(user.getEmail())
                .setInputFieldPassword(user.getPassword())
                .clickRegistrationButtonGoToLoginPage()
                .getTextLoginButton();
        assertThat("Text on button must be 'Войти'", actualText, equalTo("Войти"));
        System.out.println(actualText);
        accessToken = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Test registration new user with incorrect password")
    public void testRegistrationNewUserWithIncorrectPassword() {
        String actualErrorMessage = new MainPage(driver)
                .clickLoginAccountButton()
                .clickLinkRegistration()
                .setInputFieldPassword("12345")
                .clickRegistrationButtonWithoutTransition()
                .getErrorMessagePassword();
        assertThat("Text on button must be 'Некорректный пароль'",
                actualErrorMessage, equalTo("Некорректный пароль"));
    }
}
