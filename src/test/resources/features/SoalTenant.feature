@tenant

Feature: Tenant - Booking and Chat Kost

  @soalsatu
  Scenario: I want to check that the user can search, filter, booking, and cancel booking in our website.
    Given user navigates to mamikos homepage "https://jambu.kerupux.com"
    And user clicks on Enter Button navbar
    And user logs in as Tenant via phone number as "DC Automation"
    And user clicks search bar
    And user fills search box with keyword "Tobelo" and selects matching result
    And user selects kost rule "Akses 24 Jam"
    And user selects instant filter "Booking Langsung"
    Then user selects for kost with name "Uplift Mamirooms 01"
    When user clicks on Booking button on Kost details page
    And user clicks Booking button on Booking form
    Then user clicks chat owner kost after success booking kost
    And user sees the status chat is "delivered"
    When user sees booked kost with status waiting in history booking
    And user clicks see more button
    And user cancel the booking
    Then user sees the status turns to "Dibatalkan"