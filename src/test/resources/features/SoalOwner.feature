@owner

Feature: Owner - Add contract tenant

  @soaldua
  Scenario Outline: I want to add new data tenant, verify data, terminate contract
    Given user navigates to mamikos homepage "https://jambu.kerupux.com"
    And user clicks on Enter Button navbar
    When user logs in as Owner via phone number as "Owner Automation"
    And user sees owner dashboard page
    And user sees and clicks Add Tenant Menu
    And user selects option Add Tenant Contract by owner
    And user selects kost and inputs the tenant info with phone number "<phone>", room number "<room>" and name "<name>"
    And user inputs the payment info with price and "<duration>" month
    And user inputs the late charge "<penalty>" "<deadline>", and additonal charge "<type>" "<amount>" and "<type2>" "<amount2>"
    Then verify all data "<phone>", "<room>", "<name>", "<price>", "<type>", "<amount>", "<type2>", "<amount2>"
    When user sees success save data
    And user clicks link to navigate to Detail Tenant page
    And user terminates the tenant contract
    Then user sees description of stop tenant contract "Penyewa telah selesai mengakhiri kontrak sewa kos"

    Examples:
      | phone        | room             | name            | price    | duration | penalty | deadline | type   | amount | type2      | amount2 |
      | 083843666866 | Kamar 3 Lantai 1 | Test Automation | 10000000 | 1        | 100000  | 5        | Parkir | 50000  | Kebersihan | 100000  |