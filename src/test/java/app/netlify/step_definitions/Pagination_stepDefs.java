package app.netlify.step_definitions;

import app.netlify.pages.ProductList;
import app.netlify.utilities.BrowserUtils;
import app.netlify.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Pagination_stepDefs {

    ProductList productList = new ProductList();

    @Then("Verify current page is the first")
    public void verifyCurrentPageIsTheFirst() {

        // Message is displayed when test fails
        Assert.assertTrue("Current page is not 1",productList.isFirstPageSelected());

        // It has assertion inside with a loop
        productList.otherPagesAreNotSelected();
    }

    @And("Previous arrow isn't displayed")
    public void previousArrowIsnTDisplayed() {

        WebElement prevArrow = productList.pageNumbers.get(0);
        Assert.assertFalse(prevArrow.getAttribute("class").contains("jpDQtp"));
    }

    @And("User clicks on {int} page")
    public void userClicksOnPage(int num) {

        productList.clickPageNumberFromPagination(num);
    }

    @And("Verify current page is the last page")
    public void verifyCurrentPageIsTheLastPage() {

        // We can set an implicitly wait but didn't need, this is just for you to see during execution
        BrowserUtils.waitFor(1);

        // Message is displayed when test fails
        Assert.assertTrue("Current page is not last one",productList.isLastPageSelected());
    }

    @And("Next arrow isn't displayed")
    public void nextArrowIsnTDisplayed() {

        WebElement nextArrow = productList.pageNumbers.get(productList.pageNumbers.size()-1);
        Assert.assertTrue(nextArrow.getAttribute("class").contains("dJyhIL"));
    }

    @When("User scroll down and see the pagination")
    public void userScrollDownAndSeeThePagination() {

        BrowserUtils.scrollToElement(productList.pageNumbers.get(2));
        BrowserUtils.waitFor(1);
    }

    @Then("User should be able to go to each page and see {int} products")
    public void userShouldBeAbleToGoToEachPageAndSeeProducts(int number) {

        productList.goToEachPageAndVerifyTheProductsWithIteration(number);
    }

    @Then("User should be able to go to each page and see {int} products including last page")
    public void userShouldBeAbleToGoToEachPageAndSeeProductsIncludingLastPage(int number) {

        productList.goToEachPageAndVerifyTheProductsIncludingLastPage(number);
    }


}
