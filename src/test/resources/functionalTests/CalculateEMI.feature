Feature: As a user, I should be able to calculate EMI using the EMI Calculator site
  
  @HomeLoan
  Scenario Outline: Calculate Home Loan EMI
    Given I open EMI Calculator website
    When I enter "<Home Loan Amount>" "<Interest Rate>" "<Loan Tenure>" in search textbox
    Then I should get result as "<Loan EMI>" "<Total Interest Payable>" "<Total Payment(Principal + Interest)>"

    Examples: 
      | Home Loan Amount | Interest Rate | Loan Tenure | Loan EMI | Total Interest Payable | Total Payment(Principal + Interest) |
      |        20,00,000 |            10 |           5 |   42,494 |               5,49,645 |                           25,49,645 |
      |        30,00,000 |           9.5 |           6 |   54,824 |               9,47,333 |                           39,47,333 |
       
  @PersonaLoan
  Scenario Outline: Calculate Personal Loan EMI
    Given I open EMI Calculator website
    When I Click on Personal Loan
    And I enter "<Personal Loan Amount>" "<Interest Rate>" "<Loan Tenure>" in search textbox
    Then I should get result as "<Loan EMI>" "<Total Interest Payable>" "<Total Payment(Principal + Interest)>"

    Examples: 
      | Personal Loan Amount | Interest Rate | Loan Tenure | Loan EMI | Total Interest Payable | Total Payment(Principal + Interest) |
      |             5,00,000 |            11 |           3 |   16,369 |                 89,297 |                            5,89,297 |
      |             6,00,000 |            10 |           4 |   15,218 |               1,30,442 |                            7,30,442 |
      
  @CarLoan
  Scenario Outline: Calculate Car Loan EMI
    Given I open EMI Calculator website
    When I Click on Car Loan
    And I enter "<Car Loan Amount>" "<Interest Rate>" "<Loan Tenure>" in search textbox
    Then I should get result as "<Loan EMI>" "<Total Interest Payable>" "<Total Payment(Principal + Interest)>"

    Examples: 
      | Car Loan Amount | Interest Rate | Loan Tenure | Loan EMI | Total Interest Payable | Total Payment(Principal + Interest) |
      |        8,00,000 |             8 |           7 |   12,469 |               2,47,394 |                           10,47,394 |
      |        7,00,000 |             9 |           6 |   12,618 |               2,08,487 |                            9,08,487 |
      
