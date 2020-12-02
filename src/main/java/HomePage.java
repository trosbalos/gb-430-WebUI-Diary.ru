import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    //Блок входа на сайт
    @Step(value = "login Home Page")
    public HomePage loginHomePage() {
        new HomePage(driver)
                .clickloginButton()
                .enterLogin(USER_LOGIN)
                .enterPassword(USER_PASSWORD)
                .clickSingIn();
        return this;
    }

    @FindBy(css = "#drop-login")
    private WebElement loginButton;
    @FindBy(css = "#usrlog2")
    private WebElement inputLogin;
    @FindBy(css = "#usrpass2")
    private WebElement inputPassword;
    @FindBy(css = "#loginform > form > button")
    private WebElement singinButton;
    @FindBy(css = "#body > div.navbar.navbar-inverse > div > ul.nav.navbar-nav.navbar-user > li.avatar > a")
    private WebElement avatar;

    @Step(value = "clicklogin Button")
    public HomePage clickloginButton() {
        loginButton.click();
        return this;
    }
    @Step(value = "enter Login")
    public HomePage enterLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }
    @Step(value = "enter Password")
    public HomePage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step(value = "click SingIn")
    public HomePage clickSingIn() {
        singinButton.click();
        return new HomePage(driver);
    }
    @Step(value = "avatar Displayed")
    public WebElement avatarDisplayed() {

        return avatar;
    }

    //Блок  Регистрация
    @FindBy(css = "#body > div.navbar.navbar-inverse > div > ul.nav.navbar-nav.navbar-index > li:nth-child(2) > a")
    private WebElement registrationButton;
    @FindBy(xpath = "//*[@name='user_login']")
    private WebElement userName;
    @FindBy(xpath = "//*[@id=\"usremail\"]")
    private WebElement userEmail;
    @FindBy(css = "#modal-register > div > div > div.modal-body > form:nth-child(2) > label > input[type=checkbox]")
    private WebElement registrationCheckBox;
    @FindBy(css = "#modal-register > div > div > div.modal-body > form:nth-child(2) > button")
    private WebElement registrationButtonFinal;
    @FindBy(css = "#modal-register > div > div > div.modal-body > form:nth-child(3) > a")
    private WebElement registrationAddPhoneLater;

    @Step(value = "registration Button Click")
    public HomePage registrationButtonClick() {
        registrationButton.click();
        return this;
    }
    @Step(value = "enterUserName = {name}")
    public HomePage enterUserName(String name) {
        driver.switchTo().frame(3);
        userName.sendKeys(name);
        return this;
    }
    @Step(value = "enter UserMail")
    public HomePage enterUserMail(String email) {
        userEmail.sendKeys(email);
        return this;
    }
    @Step(value = "click Registration Check Box")
    public HomePage clickRegistrationCheckBox() {
        registrationCheckBox.click();
        return this;
    }
    @Step(value = "click Registration Button Final")
    public HomePage clickRegistrationButtonFinal() {
        registrationButtonFinal.click();
        return this;
    }
    @Step(value = "click Registration AddPhoneLater")
    public HomePage clickRegistrationAddPhoneLater() {
        registrationAddPhoneLater.click();
        return this;
    }


    //Блок нового поста
    @FindBy(xpath = "//li[2]/a/span")
    private WebElement newPostButton;
    @FindBy(xpath = "//*[@id=\"postTitle\"]")
    private WebElement postTitle;
    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement postText;
    @FindBy(id = "preview")
    private WebElement previewButton;
    @FindBy(css = "#postsArea > div.day-header")
    private WebElement postsArea;

    @Step(value = "click NewPost Button")
    public HomePage clickNewPostButton() {
        newPostButton.click();
        return this;
    }
    @Step(value = "enterPostTitle = {random_text}")
    public HomePage enterPostTitle(String random_text) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        postTitle.sendKeys(random_text);
        return this;
    }
    @Step(value = "enter PostText = {random_text}")
    public HomePage enterPostText(String random_text) {
        postText.sendKeys(random_text);
        return this;
    }
    @Step(value = "click PreviewButton")
    public HomePage clickPreviewButton() {
        previewButton.click();
        return this;
    }
    @Step(value = "postsArea Displayed")
    public WebElement postsAreaDisplayed() {

        return postsArea;
    }

    //Блок сервиса сообщений
    @FindBy(css = "li:nth-child(6) .alt")
    private WebElement userMainEmailButton;
    @FindBy(linkText = "Написать письмо")
    private WebElement writeEmailButton;
    @FindBy(id = "touser")
    private WebElement toUserName;
    @FindBy(name = "title")
    private WebElement emailTitle;
    @FindBy(id = "message")
    private WebElement emailText;
    @FindBy(css = ".btn")
    private WebElement sendEmailMessageButton;
    @FindBy(css = "#page_content > div > div > div")
    private WebElement messageCreated;
    @Step(value = "click UserMainEmail Button")
    public HomePage clickUserMainEmailButton() {
        userMainEmailButton.click();
        return this;
    }
    @Step(value = "click WriteEmail Button")
    public HomePage clickWriteEmailButton() {
        writeEmailButton.click();
        return this;
    }
    @Step(value = "enter ToUser Name")
    public HomePage enterToUserName(String username) {
        toUserName.sendKeys(username);
        return this;
    }
    @Step(value = "enter Email Title")
    public HomePage enterEmailTitle(String title_text) {
        emailTitle.sendKeys(title_text);
        return this;
    }
    @Step(value = "enter Email Text")
    public HomePage enterEmailText(String email_text) {
        emailText.sendKeys(email_text);
        return this;
    }
    @Step(value = "click SendEmail Message Button")
    public HomePage clickSendEmailMessageButton() {
        sendEmailMessageButton.click();
        return this;
    }
    @Step(value = "message CreatedDisplayed = {messageCreated}")
    public WebElement messageCreatedDisplayed() {
        return messageCreated;
    }


}
