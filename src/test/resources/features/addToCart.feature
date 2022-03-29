@regression @cart
Feature: Add to Cart

  @cart-01 @smoke
  Scenario Outline: User should be able to add 1 item to the cart
    Given User is on the home page
    When User hovers over the "<product>" item
    When User clicks on ADD TO CART button for "<product>" item
    Then Cart pop-up should appear from the basket icon in the header
    Then Cart pop-up should contain the "<product>" item
    Then A counter badge should appear under the basket icon saying how many items added

    Examples:
      | product                            |
      | Watch                              |
      | Watercolor painting                |
      | Vegetable salad on plate           |
      | Three Men Standing Near Waterfalls |

  @cart-02 @smoke
  Scenario: User should be able to add many items to the cart
    Given User is on the home page
    When User adds the following items to the cart
      | Watercolor painting                |
      | Watch                              |
      | Vegetable salad on plate           |
      | Three Men Standing Near Waterfalls |
    Then Cart pop-up should appear from the basket icon in the header
    Then Cart should contain newly added items


  #Scenario: User should be able to see the cart by clicking basket icon






  #Scenario: User should be able to clear the cart by clicking close button


