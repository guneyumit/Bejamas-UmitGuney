package app.netlify.pages;

import app.netlify.utilities.BrowserUtils;
import app.netlify.utilities.ConfigurationReader;
import app.netlify.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//p[.='Photo of the day']")
    public WebElement featuredItem;

    @FindBy(css = ".Navbarstyle__CartWrapper-sc-1b7zefh-1.kcaWdL")
    public WebElement cartPopup;

    @FindBy(css = ".Navbarstyle__ShoppingCartButton-sc-1b7zefh-2.jBrNBB>span")
    public WebElement counter;

    @FindBy(css = ".title")
    public List<WebElement> listOfItemsInTheCart;

    @FindBy(css = ".style__Column-sc-4ctdae-1.jlvejm")
    public List<WebElement> itemsInTheProductList;

    public void navigateToUrl() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
    }

    public boolean itemIsInTheCart(String product) {

        String xpathOfItemInTheCart = "//p[@class='title'][.='" + product + "']";
        WebElement itemInTheCart = Driver.get().findElement(By.xpath(xpathOfItemInTheCart));

        return itemInTheCart.isDisplayed();
    }

    public boolean CounterEqualsToNumberOfItemsInCart() {

        int expectedNumberInCounter = listOfItemsInTheCart.size();
        int actualNumberInCart = Integer.parseInt(counter.getText());

        return expectedNumberInCounter == actualNumberInCart;
    }

    public void hoverOver(String product) {

        String xpathOfProduct = "//p[@class='ProductCardstyle__Name-sc-5v39a6-4 cFYRKu'][text()='" + product + "']/../../div";
        WebElement item = Driver.get().findElement(By.xpath(xpathOfProduct));

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(item).perform();
        BrowserUtils.waitFor(2);
    }

    public void clickAddToCart(String product) {

        String xpathOfAddToCartSpecialToProduct = "//p[@class='ProductCardstyle__Name-sc-5v39a6-4 cFYRKu'][text()='" + product + "']/../..//button[text()='Add to Cart']";
        WebElement specificAddToCart = Driver.get().findElement(By.xpath(xpathOfAddToCartSpecialToProduct));

        specificAddToCart.click();
        BrowserUtils.waitFor(2);
    }
}
