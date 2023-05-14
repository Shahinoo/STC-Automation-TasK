@smoke
Feature: Validate Subscribe feature for SA, Bahrain, and kuwait

  Background: User already on the Subscribe page
    Given User on subscribe page

  Scenario Outline: validate Packages Type, Price and Currency on subscribe page
    When User select a "<country>" from the countries list
    Then The Three types of packages are displayed
    And Discovery add-ons is included as an extra for all plans
    And The Prices for the all plans in the selected "<country>" should be as expected on the json file
    And The currency for all plans in the selected "<country>" should be as the table
      | SA-currency | BH-currency | KW-currency |
      | SAR/month   | BHD/month   | KWD/month   |
    Examples:
      | country      |
      | saudi arabia |
      | bahrain      |
      | kuwait       |

  Scenario Outline: Validate price, total price, currency and extra plans while selecting the plans
    And Start a trial for a "<plan>" for the "<country>"
    Then "<plan>" is selected
    And The selected plan price and currency should be "<planPrice>"
    When  User click on Next button
    And User select Discovery+ package from the extra packages
    Then Discovery package price for "<plan>" is "<discoveryValue>"
    And Total price should be "0.00"
    Examples:
      | country      | plan    | planPrice       | discoveryValue |
      | saudi arabia | Lite    | 15.00 SAR/month | 0.00           |
      | bahrain      | Lite    | 2.00 BHD/month  | 0.00           |
      | kuwait       | Lite    | 1.20 KWD/month  | 0.00           |
      | saudi arabia | Classic | 25.00 SAR/month | 0.00           |
      | bahrain      | Classic | 3.00 BHD/month  | 0.00           |
      | kuwait       | Classic | 2.50 KWD/month  | 0.00           |
      | saudi arabia | Premium | 60.00 SAR/month | Included       |
      | bahrain      | Premium | 6.00 BHD/month  | Included       |
      | kuwait       | Premium | 4.80 KWD/month  | Included       |