package app.netlify.step_definitions;

import app.netlify.pages.HomePage;
import app.netlify.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AddToCart_stepDefs {

    HomePage homePage = new HomePage();
    List<String> expectedItems = new ArrayList<>();

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {

        homePage.navigateToUrl();
        Assert.assertTrue(homePage.featuredItem.isDisplayed());
    }

    @Then("Cart pop-up should appear from the basket icon in the header")
    public void cartPopUpShouldAppearFromTheBasketIconInTheHeader() {

        Assert.assertTrue(homePage.cartPopup.isDisplayed());
    }

    @Then("Cart pop-up should contain the {string} item")
    public void cartPopUpShouldContainTheItem(String product) {

        Assert.assertTrue(homePage.itemIsInTheCart(product));
    }


    @Then("A counter badge should appear under the basket icon saying how many items added")
    public void aCounterBadgeShouldAppearUnderTheBasketIconSayingHowManyItemsAdded() {

        Assert.assertTrue(homePage.counter.isDisplayed());

        Assert.assertTrue(homePage.CounterEqualsToNumberOfItemsInCart());
    }

    @When("User hovers over the {string} item")
    public void userHoversOverTheItem(String product) {

        homePage.hoverOver(product);
    }

    @When("User clicks on ADD TO CART button for {string} item")
    public void userClicksOnADDTOCARTButtonForItem(String product) {

        homePage.clickAddToCart(product);
    }

    @When("User adds the following items to the cart")
    public void userAddsTheFollowingItemsToTheCart(List<String> products) {
        expectedItems = products;
        for (String product : products) {
            homePage.hoverOver(product);
            homePage.clickAddToCart(product);
        }
    }

    @Then("Cart should contain newly added items")
    public void cartShouldContainNewlyAddedItems() {

        List<String> actualItems = BrowserUtils.getElementsText(homePage.listOfItemsInTheCart);
        Assert.assertEquals(expectedItems, actualItems);

    }
}
