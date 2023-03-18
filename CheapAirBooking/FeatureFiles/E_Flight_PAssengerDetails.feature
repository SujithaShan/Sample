@PassengerDetails
Feature: Filling Passenger Details

@passengerdetails
  Scenario: Filling Passenger Details
   
    When Passenger Details
    |firstname|Suji|Ganesh|name1|name2|name3|name4|name5|name6|
    |lastname|shan|amir|name1|name2|name3|name4|name5|name6|
    |gender|Female|Male|Female|Male|Female|Male|Female|Male|
    |DOB|January|May|January|May|January|May|January|May|
    |Day|29|27|29|27|29|27|29|27|
    |year|1993|1990|1993|1990|1993|1990|1993|1990|
    
    Then Enter Card Details
    
    |4263982640269299|
    |02|
    |2023|
    |837|
    |Sujitha N S|
    |IN|
    |sarjapura|
    |Banglore|
    |Banglore|
    |9876543210|
    |ssujitha@gmail.com|
    |suji12345|
    |suji12345|
    
    
    
   