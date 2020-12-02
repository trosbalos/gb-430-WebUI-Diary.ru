import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;


public class NewPostTest extends BaseTest {
    @Feature("newPost Test")
    @Test
    void newPostTest() {
        new HomePage(driver)
                .loginHomePage()
                .clickNewPostButton()
                .enterPostTitle(RANDOM_TEXT)
                .enterPostText(RANDOM_TEXT)
                .clickPreviewButton();

        HomePage homePage = new HomePage(driver);
        WebElement postsArea = homePage.postsAreaDisplayed();
        Assertions.assertAll(
                () -> assertTrue(postsArea.isDisplayed())
        );

    }
}
