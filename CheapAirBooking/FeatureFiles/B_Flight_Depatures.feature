
@depature
Feature: Flight Depature
  
  @depart
  Scenario: Choosing depature flight
    Given Sorting flights by price
    When Choosing lowest price flight
    Then Confiming flight timing

