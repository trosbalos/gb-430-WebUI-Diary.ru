import com.github.javafaker.Faker;

public class Configuration {
    Faker faker = new Faker();
    public String BASE_URL = "https://www.diary.ru/";
    public String USER_LOGIN = "mcfly123";
    public String USER_PASSWORD = "9feede1fe";
    public String RANDOM_USER_NAME = faker.pokemon().name() + faker.cat().name();
    public String RANDOM_USER_EMAIL = faker.cat().name() + "@" + faker.cat().name() + ".ru";
    public String RANDOM_TEXT = faker.friends().quote();


}
