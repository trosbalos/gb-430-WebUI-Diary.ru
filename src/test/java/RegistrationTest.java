import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class RegistrationTest extends BaseTest {
    @Feature("registration Test")
    @Test
    void registrationTest() {
        new HomePage(driver)
                .registrationButtonClick()
                .enterUserName(RANDOM_USER_NAME)
                .enterUserMail(RANDOM_USER_EMAIL)
                .clickRegistrationCheckBox()
                .clickRegistrationButtonFinal()
                .clickRegistrationAddPhoneLater();

        HomePage homePage = new HomePage(driver);
        WebElement avatar = homePage.avatarDisplayed();

        Assertions.assertAll(
                () -> assertTrue(avatar.isDisplayed())
        );

    }

}

