package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sf-menu>li:first-child>a")
    private WebElement women;
    @FindBy(css = "[title=Blouses]")
    private WebElement blouses;

    public HomePage hoverToWomen() {
        mouseHover(women);
        return new HomePage(driver);
    }

    public CategoryPage clickOnBlouses() {
        click(blouses);
        return new CategoryPage(driver);
    }
}