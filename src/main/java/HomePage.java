import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    //Блок входа на сайт
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

    public HomePage clickloginButton() {
        loginButton.click();
        return this;
    }

    public HomePage enterLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public HomePage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public HomePage clickSingIn() {
        singinButton.click();
        return new HomePage(driver);
    }

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

    public HomePage registrationButtonClick() {
        registrationButton.click();
        return this;
    }

    public HomePage enterUserName(String name) {
        driver.switchTo().frame(3);
        userName.sendKeys(name);
        return this;
    }

    public HomePage enterUserMail(String email) {
        userEmail.sendKeys(email);
        return this;
    }

    public HomePage clickRegistrationCheckBox() {
        registrationCheckBox.click();
        return this;
    }

    public HomePage clickRegistrationButtonFinal() {
        registrationButtonFinal.click();
        return this;
    }

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

    public HomePage clickNewPostButton() {
        newPostButton.click();
        return this;
    }

    public HomePage enterPostTitle(String random_text) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        postTitle.sendKeys(random_text);
        return this;
    }

    public HomePage enterPostText(String random_text) {
        postText.sendKeys(random_text);
        return this;
    }

    public HomePage clickPreviewButton() {
        previewButton.click();
        return this;
    }

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

    public HomePage clickUserMainEmailButton() {
        userMainEmailButton.click();
        return this;
    }

    public HomePage clickWriteEmailButton() {
        writeEmailButton.click();
        return this;
    }

    public HomePage enterToUserName(String username) {
        toUserName.sendKeys(username);
        return this;
    }

    public HomePage enterEmailTitle(String title_text) {
        emailTitle.sendKeys(title_text);
        return this;
    }

    public HomePage enterEmailText(String email_text) {
        emailText.sendKeys(email_text);
        return this;
    }

    public HomePage clickSendEmailMessageButton() {
        sendEmailMessageButton.click();
        return this;
    }

    public WebElement messageCreatedDisplayed() {
        return messageCreated;
    }


}
