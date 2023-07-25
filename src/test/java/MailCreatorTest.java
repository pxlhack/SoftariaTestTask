import org.junit.jupiter.api.Test;
import ru.pxlhack.MailCreator;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailCreatorTest {

    @Test
    public void test_create() {
        Map<String, String> todaysWebsiteState = new HashMap<>();
        Map<String, String> yesterdaysWebsiteState = new HashMap<>();

        todaysWebsiteState.put("https://www.google.com/", "google html code");
        todaysWebsiteState.put("https://github.com/", "github html code");
        todaysWebsiteState.put("https://www.youtube.com/", "youtube html code");
        todaysWebsiteState.put("https://www.postman.com/", "postman html code");

        yesterdaysWebsiteState.put("https://www.google.com/", "google html code 2");
        yesterdaysWebsiteState.put("https://github.com/", "github html code");
        yesterdaysWebsiteState.put("https://www.postman.com/", "postman html code");
        yesterdaysWebsiteState.put("https://genius.com/", "genius html code");

        String expectedMail = """
                Здравствуйте, дорогая и.о. секретаря

                За последние сутки во вверенных Вам сайтах произошли следующие изменения:

                Исчезли следующие страницы: https://www.youtube.com/
                Появились следующие новые страницы https://genius.com/
                Изменились следующие страницы https://www.google.com/""";

        MailCreator mailCreator = new MailCreator();

        assertEquals(expectedMail, mailCreator.create(todaysWebsiteState, yesterdaysWebsiteState));
    }

}
