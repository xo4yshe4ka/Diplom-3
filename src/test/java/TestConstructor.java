import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class TestConstructor extends BaseTest{

    @Test
    @DisplayName("Test go to chapter bun")
    public void testClickBunButton() {
        boolean actualActiveButton = new MainPage(driver)
                .clickFillingsButton()
                .clickBunButton()
                .isActiveBunButton();
        assertTrue("must be true", actualActiveButton);
    }

    @Test
    @DisplayName("Test go to chapter sauces")
    public void testClickSaucesButton() {
        boolean actualActiveButton = new MainPage(driver)
                .clickSaucesButton()
                .isActiveSaucesButton();
        assertTrue("must be true", actualActiveButton);
    }

    @Test
    @DisplayName("Test go to chapter fillings")
    public void testClickFillingsButton() {
        boolean actualActiveButton = new MainPage(driver)
                .clickFillingsButton()
                .isActiveFillingsButton();
        assertTrue("must be true", actualActiveButton);
    }
}
