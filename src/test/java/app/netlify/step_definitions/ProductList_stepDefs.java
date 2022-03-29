package app.netlify.step_definitions;

import app.netlify.pages.ProductList;
import app.netlify.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductList_stepDefs {

    ProductList productList = new ProductList();

    @When("User scroll down and see the product list")
    public void userScrollDownAndSeeTheProductList() {

        BrowserUtils.scrollToElement(productList.titleOfProductList);
        BrowserUtils.waitFor(2);

        Assert.assertTrue(productList.titleOfProductList.isDisplayed());
    }

    @Then("Product list should contain {int} items")
    public void productListShouldContainItems(int numberOfItems) {

        productList.verifyNumberOfItemsEqualToItemsInList(numberOfItems);
    }

    @Then("ADD TO CART button should appear once hover over the {string} item")
    public void addTOCARTButtonShouldAppearOnceHoverOverTheItem(String product) {

        Assert.assertTrue(productList.specificAddToCartButton(product).isDisplayed());
    }

    @When("Best Seller flag should NOT be visible as default before hover over the {string} item")
    public void bestSellerFlagShouldNOTBeVisibleAsDefaultBeforeHoverOverTheItem(String product) {

        Assert.assertTrue(productList.specificBestsellerFlag(product).isDisplayed());
    }
}
