Feature: Interaction with JDI homepage

  @TestTag @TestTag1
  Scenario: Different Elements Page test

    Given I open JDI Github site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    And I select checkboxes "Water" and "Wind"
    And I select radio "Selen"
    And I select "Yellow" in dropdown
    Then Log field should contain following values
    |Item   |Status   |
    |Colors |Yellow   |
    |metal  |Selen    |
    |Wind   |true     |
    |Water  |true     |

  #    comment
  @TestTag
  Scenario: User Table Page test (Exercise 2)

    Given I open JDI Github site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    Then "User Table" page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
#    And User table should contain following values:
#      | Number | User             | Description                      |
#      | 1      | Roman            | Wolverine                        |
#      | 2      | Sergey Ivan arg0 | Spider Man                       |
#      | 3      | Vladzimir        | Punisher                         |
#      | 4      | Helen Bennett    | Captain America some description |
#      | 5      | Yoshi Tannamuri  | Cyclope some description         |
#      | 6      | Giovanni Rovelli | Hulksome description             |
#    And droplist should contain values in column Type for user Roman
#      | Dropdown Values |
#      | Admin           |
#      | User            |
#      | Manager         |


#  Scenario: User table Page Vip function test (Exercise 3)
#
#    Given I open JDI Github site
#    And I login as user "Roman Iovlev"
#    And I click on "Service" button in Header
#    And I click on "User Table" button in Service dropdown
#    When I select 'vip' checkbox for "Sergey Ivan"
#    Then 1 log row has "Vip: condition changed to true" text in log section
