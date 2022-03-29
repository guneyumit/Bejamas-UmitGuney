package app.netlify.pages;

import app.netlify.utilities.BrowserUtils;
import app.netlify.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductList extends HomePage{

    @FindBy(xpath = "//a[.='Photography']")
    public WebElement titleOfProductList;

    @FindBy(css = ".hRXIFn>li")
    public List<WebElement> pageNumbers;


    public WebElement specificAddToCartButton(String product) {

        String xpathOfAddToCartSpecialToProduct = "//p[@class='ProductCardstyle__Name-sc-5v39a6-4 cFYRKu'][text()='" + product + "']/../..//button[text()='Add to Cart']";
        WebElement specificAddToCart = Driver.get().findElement(By.xpath(xpathOfAddToCartSpecialToProduct));

        return specificAddToCart;
    }

    public WebElement specificBestsellerFlag(String product) {

        String xpathOfBestSellerFlagSpecialToProduct = "//p[.='" + product + "']/../../div//p[@class='ProductCardstyle__BestSellerBadge-sc-5v39a6-6 eHAhyp']";
        WebElement specificBestsellerFlag = Driver.get().findElement(By.xpath(xpathOfBestSellerFlagSpecialToProduct));

        return specificBestsellerFlag;
    }

    public void verifyNumberOfItemsEqualToItemsInList(int numberOfItems) {
        Assert.assertEquals(numberOfItems, itemsInTheProductList.size());
    }

    public boolean isFirstPageSelected() {

        return isSelected(pageNumbers.get(1));
    }

    // This checks if page numbers between 1-6 is clicked or not
    public void otherPagesAreNotSelected() {

        for (int i = 2; i < pageNumbers.size()-1; i++) {
            boolean otherPagesAreNotSelected = (boolean) ((JavascriptExecutor)Driver.get()).executeScript("return window.getComputedStyle(arguments[0]).color == 'rgb(155, 155, 155)'", pageNumbers.get(i));
            Assert.assertTrue("Current page is not 1",otherPagesAreNotSelected);
        }
    }

    // This is to navigate you to any page number from pagination
    public void clickPageNumberFromPagination(int num) {

        Driver.get().findElement(By.xpath("//li[.='" + num + "']")).click();
    }

    public boolean isLastPageSelected() {
        return isSelected(pageNumbers.get(pageNumbers.size()-2));
    }

    // This method is to check if the page number in the pagination is already clicked
    public boolean isSelected(WebElement element){

        boolean isSelected = (boolean) ((JavascriptExecutor) Driver.get()).executeScript("return window.getComputedStyle(arguments[0]).color == 'rgb(0, 0, 0)'", element);

        return isSelected;
    }


    public void goToEachPageAndVerifyTheProductsWithIteration(int number) {

        for (int i = 1; i <= pageNumbers.size()-3; i++) {

            WebElement page = Driver.get().findElement(By.xpath("//li[text()='" + i + "']"));
            page.click();
            int actualItemNumber = itemsInTheProductList.size();
            Assert.assertEquals(number,actualItemNumber);
            BrowserUtils.waitFor(1);
        }
    }

    public void goToEachPageAndVerifyTheProductsIncludingLastPage(int number) {

        for (int i = 1; i <= pageNumbers.size()-2; i++) {
            WebElement page = Driver.get().findElement(By.xpath("//li[text()='" + i + "']"));
            page.click();
            int actualItemNumber = itemsInTheProductList.size();
            Assert.assertEquals(number,actualItemNumber);
            BrowserUtils.waitFor(1);
        }
    }
}
