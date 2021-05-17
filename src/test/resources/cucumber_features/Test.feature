Feature: Open Jdi homepage and check frames

  Scenario: Open Jdi Page and switch between frames
    Given I open JDI homepage
    And I login as user Roman with password Jdi1234
    When I switch to iframe frame
    And I switch back to main page
    Then Button "..." should be in iframe
