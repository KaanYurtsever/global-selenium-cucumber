Feature: Global features

  Background:
    Given User opens the browser and goes to the home page

  @requestacallback
  Scenario: Request a call back on contact page unsuccessfully
    When User goes to the "contact" page
    Then User fills expected fields to request a call back
    | First Name | Last Name | Organisation | City   | Postcode | Phone        | Email                    | Enquiry |
    | Kaan       | Yurtsever | Global       | London | W1K      | 905555555555 | kaanyurtsever@global.com | Hello   |
    And User "should not" see successfull message

  @gotoradio
  Scenario: Go to radio page
    When User goes to the "global player" page
    And User opens 2 global radio
    When User is tab 1
    Then User should see global radio is open

