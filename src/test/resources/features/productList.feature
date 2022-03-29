@regression
Feature: Product List

  @list-01
  Scenario: User should be able to see 6 products
    Given User is on the home page
    When User scroll down and see the product list
    Then Product list should contain 4 items


  @list-02
  Scenario Outline: User should be able to see ADD TO CART bar once hover over any product
    Given User is on the home page
    When User hovers over the "<product>" item
    Then ADD TO CART button should appear once hover over the "<product>" item

    Examples:
      | product                            |
      | Watch                              |
      | Watercolor painting                |
      | Vegetable salad on plate           |
      | Three Men Standing Near Waterfalls |


  @list-03 @smoke
  Scenario Outline: Best Seller flag should appear once hover over the products that have Best Seller flag
    Given User is on the home page
    When User scroll down and see the product list
    Then Best Seller flag should NOT be visible as default before hover over the "<Bestseller product>" item

    Examples:
      | Bestseller product                 |
      | Watch                              |
      | Watercolor painting                |
      | Three Men Standing Near Waterfalls |









