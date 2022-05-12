package base;

import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;

public class Pages extends TestBase {

    public HomePage homePage;

    @BeforeEach
    public void setup() {
        homePage = new HomePage(webDriver);
    }
}