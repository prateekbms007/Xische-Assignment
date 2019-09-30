Feature: Ticket booking functionality for DDLJ movie

  Scenario: Booking DDLJ movie
    Given Launch BookMyShow application
    And Select Prod Environment
    When Tap On Search Icon
    And Enter movie title in the Search box
    And Select searched movie
    And Tap on Book Tickets Button
    And Select Date
    And Select Show time
    And Accept Term & Conditions
    And Select seat count
    And Tap on Select Seats Button
    And Select seats
    And Tap on Pay Button
    And Select Net Banking
    And Select HDFC Bank
    Then Validate User is on HDFC Netbanking page
