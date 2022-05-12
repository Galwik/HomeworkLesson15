package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import listener.WebListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static Logger log = LoggerFactory.getLogger(TestBase.class);
    public WebDriver webDriver;
    public EventFiringWebDriver driver;
    private WebListener webListener;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        log.info(">>>DRIVER INITIATED PROPERLY");
    }

    @BeforeEach
    void beforeEach() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        driver = new EventFiringWebDriver(webDriver);
        webListener = new WebListener();
        driver.register(webListener);
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    void afterEach() {
        webDriver.quit();
        log.info(">>>DRIVER CLOSED PROPERLY");
    }
}