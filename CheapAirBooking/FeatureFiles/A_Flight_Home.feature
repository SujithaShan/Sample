@Home
Feature: CheapAir HomePage
 
   @TravelDetails
  Scenario: Travel details
    Given Choosing trip 
    When Choosing Places and Dates
    And Enter list of passengers
    Then validate the Information

  