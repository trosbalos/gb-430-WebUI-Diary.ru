
import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;


public class LoginTest extends BaseTest {

    @Feature("login Test")
    @Test
    void loginTest() {
        new HomePage(driver)
                .clickloginButton()
                .enterLogin(USER_LOGIN)
                .enterPassword(USER_PASSWORD)
                .clickSingIn();

        HomePage homePage = new HomePage(driver);
        WebElement avatarIcon = homePage.avatarDisplayed();
        Assertions.assertAll(
                () -> assertTrue(avatarIcon.isDisplayed())
        );

    }
}

