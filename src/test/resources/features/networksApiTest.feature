@NetworkApi
Feature: As a biker I would like to know the exact location of city bikes around the world in a given application.

  Scenario: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    When I send  the request to networks
    Then the status code should be 200
    And response includes the following city "Frankfurt"
      | country   | DE      |
      | longitude | 8.66375 |
      | latitude  | 50.1072 |

  Scenario: As a user i want to verify that the api schema is correct
    When I send  the request to networks
    Then the status code should be 200
    And I validate the Json Schema is correct