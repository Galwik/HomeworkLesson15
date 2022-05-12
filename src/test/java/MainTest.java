import base.Pages;
import org.junit.jupiter.api.Test;

public class MainTest extends Pages {

    @Test
    public void shouldCompareImagesInQuickView() {
        homePage.hoverToWomen().clickOnBlouses()
                .hoverToPicture().clickOnQuickView()
                .compareImages();
    }

}