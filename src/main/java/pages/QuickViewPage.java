package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class QuickViewPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(QuickViewPage.class);

    public QuickViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#thumbs_list a")
    private List<WebElement> smallImages;

    @FindBy(id = "bigpic")
    private WebElement mainImage;

    @FindBy(className = "fancybox-iframe")
    private WebElement iframe;

    public void compareImages() {
        switchToIframe(iframe);
        logger.info(">>>>Switched to iFrame");
        waitToBeVisible(mainImage);
        for (WebElement element : smallImages) {
            mouseHover(element);
            String elementAttribute = element.getAttribute("href");
            logger.info("element attribute: " + elementAttribute);
            String mainImageAttribute = mainImage.getAttribute("src").replace("large", "thickbox");
            logger.info("Main image attribute after replace: " + mainImageAttribute);
            assertThat("Wrong image", elementAttribute.equals(mainImageAttribute));
        }
    }
}