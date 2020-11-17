import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    Faker faker = new Faker();
     String USER_LOGIN = "mcfly123";
     String USER_PASSWORD = "9feede1fe";
     String USER_NAME = faker.pokemon().name() + faker.cat().name();
     String USER_EMAIL = faker.cat().name() + "@" + faker.cat().name() + ".ru";
     String RANDOM_TEXT = faker.friends().quote();



    @org.junit.jupiter.api.Test
    void loginTEST() {
        Diary diary = new Diary();
        diary.login(USER_LOGIN,USER_PASSWORD);

        WebElement avatar = diary.getDriver().findElement(By.cssSelector("#body > div.navbar.navbar-inverse > div > ul.nav.navbar-nav.navbar-user > li.avatar > a"));

        Assertions.assertAll(
                ()->assertTrue(avatar.isDisplayed())
        );
        diary.getDriver().close();

    }

    @org.junit.jupiter.api.Test
    void registrationTEST() {
        Diary diary = new Diary();
        diary.registration(USER_NAME,USER_EMAIL);

        WebElement avatar = diary.getDriver().findElement(By.cssSelector("#body > div.navbar.navbar-inverse > div > ul.nav.navbar-nav.navbar-user > li.avatar > a"));

        Assertions.assertAll(
                ()->assertTrue(avatar.isDisplayed())
        );
        diary.getDriver().close();
    }


    @org.junit.jupiter.api.Test
    void newPostTEST() {
        Diary diary = new Diary();
        diary.login(USER_LOGIN,USER_PASSWORD);
        diary.newPost(RANDOM_TEXT);

        WebElement postsArea = diary.getDriver().findElement(By.cssSelector("#postsArea > div.day-header"));
        diary.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        diary.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");
        diary.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assertions.assertAll(
                ()->assertTrue(postsArea.isDisplayed())
        );
        diary.getDriver().quit();
    }
    @org.junit.jupiter.api.Test
    void sendMessageTEST() {
        Diary diary = new Diary();
        diary.login(USER_LOGIN,USER_PASSWORD);
        diary.sendMessage(USER_LOGIN,RANDOM_TEXT);

       WebElement done = diary.getDriver().findElement(By.cssSelector("#page_content > div > div > div"));

       Assertions.assertAll(
               ()->assertTrue(done.isDisplayed())
       );
        diary.getDriver().quit();
    }

}