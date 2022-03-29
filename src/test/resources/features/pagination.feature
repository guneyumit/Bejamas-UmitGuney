@regression @pag
Feature: Pagination

  @pag-01 @e
  Scenario: Verify the behaviour of the previous and next arrows in the first and last page
    Given User is on the home page
    When User scroll down and see the pagination
    Then Verify current page is the first
    And Previous arrow isn't displayed
    And User clicks on 6 page
    And Verify current page is the last page
    And Next arrow isn't displayed


    # This test consists of 2 different scenarios;
    # In actual case; 1. one will pass, 2. one will fail since currently displayed 4 products in each page
  @pag-02 @smoke
  Scenario Outline: User should be able to navigate to each page and see the products
    Given User is on the home page
    When User scroll down and see the pagination
    Then User should be able to go to each page and see <number> products
    Examples:
      | number |
      | 4      |
      | 6      |

    # Actually, it's so expected to have products in the last page less than other pages have >>
    # but still I have one scenario to test that as well.
    # This test is to verify the last page should also have 6 products, but will fail since currently displayed 1 item
  @pag-03
  Scenario: User should be able to navigate to each page and see products
    Given User is on the home page
    When User scroll down and see the pagination
    Then User should be able to go to each page and see 4 products including last page