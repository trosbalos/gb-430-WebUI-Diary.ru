import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class Diary {


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private String LOGIN_PAGE_URL = "https://www.diary.ru/";

    public  void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
    }

    public void login(String USER_LOGIN,String USER_PASSWORD) {
        setUp();
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.cssSelector("#drop-login")).click();
        driver.findElement(By.cssSelector("#usrlog2")).sendKeys(USER_LOGIN);
        driver.findElement(By.cssSelector("#usrpass2")).sendKeys(USER_PASSWORD);
        driver.findElement(By.cssSelector("#loginform > form > button")).click();
    }

    public void registration(String USER_NAME,String USER_EMAIL)  {
        setUp();
        driver.findElement(By.cssSelector("#body > div.navbar.navbar-inverse > div > ul.nav.navbar-nav.navbar-index > li:nth-child(2) > a")).click();;
        driver.switchTo().frame(3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@name='user_login']")).sendKeys(USER_NAME);
        driver.findElement(By.xpath("//*[@id=\"usremail\"]")).sendKeys(USER_EMAIL);
        driver.findElement(By.cssSelector("#modal-register > div > div > div.modal-body > form:nth-child(2) > label > input[type=checkbox]")).click();
        driver.findElement(By.cssSelector("#modal-register > div > div > div.modal-body > form:nth-child(2) > button")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#modal-register > div > div > div.modal-body > form:nth-child(3) > a")).click();
    }

    public void newPost(String RANDOM_TEXT){

            driver.findElement(By.xpath("//li[2]/a/span")).click();
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"postTitle\"]")).sendKeys(RANDOM_TEXT);
            driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(RANDOM_TEXT);
            driver.findElement(By.id("preview")).click();
}
        public void sendMessage(String USER_NAME,String RANDOM_TEXT){
            driver.findElement(By.cssSelector("li:nth-child(6) .alt")).click();
            driver.findElement(By.linkText("Написать письмо")).click();
            driver.findElement(By.id("touser")).sendKeys(USER_NAME);
            driver.findElement(By.name("title")).sendKeys(RANDOM_TEXT);
            driver.findElement(By.id("message")).sendKeys(RANDOM_TEXT);
            driver.findElement(By.cssSelector(".btn")).click();
        }
}



