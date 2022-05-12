package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(CategoryPage.class);

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product_img_link img")
    private WebElement productImage;

    @FindBy(css = "a.quick-view")
    private WebElement quickViewButton;

    @FindBy(css = ".quick-view-mobile")
    private WebElement quickViewMobileButton;

    public CategoryPage hoverToPicture() {
        mouseHover(productImage);
        return new CategoryPage(driver);
    }

    public QuickViewPage clickOnQuickView() {
        if (quickViewButton.isDisplayed()) {
            logger.info("Clicking on NORMAL QUICK VIEW BUTTON");
            click(quickViewButton);
        } else if (quickViewMobileButton.isDisplayed()) {
            logger.info("Clicking on MOBILE QUICK VIEW BUTTON");
            click(quickViewMobileButton);
        }
        return new QuickViewPage(driver);
    }
}