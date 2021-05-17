@midtrans

Feature: Midtrans payment flow

  Scenario Outline: I want to check <status> payment flow for purchasing Pillow using Credit Card as payment method.
    Given user navigates to homepage "https://demo.midtrans.com"
    When user clicks BUY NOW button
    Then user validates Customer Details
    And user validates total price similar on order summary
    And user validates shipping details on order summary
    When user clicks CONTINUE button
    And user selects Credits or Debit Card payment method
    And user inputs card number "<card_number>", "<expiry_date>", and "<cvv>"
    Then user validates total amount and "<promo>" selected is matching
    And user validates amount and inputs "<password>"
    When user clicks OK button
    Then user sees total amount with "<status>" message

    Examples:
      | status     | card_number         | expiry_date | cvv | password | promo                            |
      | successful | 4811 1111 1111 1114 | 12/24       | 123 | 112233   | Promo 10 Rupiah                  |
      | failed     | 4911 1111 1111 1113 | 02/22       | 123 | 112233   | Potongan 10% - Demo Promo Engine |
