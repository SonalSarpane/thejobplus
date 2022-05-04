Feature: HomePage features
  Background: User is on Home Page
    When I opened the browser and enterend the URL
    And  I click on Shop Menu
    Then click on Home menu button

    @sanity
    Scenario: HomePage with three sliders only
      Then verify whether the Home page has 3 Sliders only

    @smoke
    Scenario: HomePage with five sliders only
      Then verify whether the everything works fine