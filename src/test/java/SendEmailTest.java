import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class SendEmailTest extends BaseTest {
    @Test
    void sendEmailTest() {
        new HomePage(driver)
                .loginHomePage()
                .clickUserMainEmailButton()
                .clickWriteEmailButton()
                .clickWriteEmailButton()
                .enterToUserName(USER_LOGIN)
                .enterEmailTitle(RANDOM_TEXT)
                .enterEmailText(RANDOM_TEXT)
                .clickSendEmailMessageButton();
        HomePage homePage = new HomePage(driver);
        WebElement messageCreated = homePage.messageCreatedDisplayed();

        Assertions.assertAll(
                () -> assertTrue(messageCreated.isDisplayed())
        );
    }
}
