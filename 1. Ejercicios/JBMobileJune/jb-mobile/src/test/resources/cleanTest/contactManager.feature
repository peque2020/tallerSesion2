Feature: CreateContact


  Scenario: As user, i want create contact so that save in the sim

    Given I have the contact manager app
    And I click on "ok" button in update dialog if exist
    When I click on "addContact" button list contact
    And I set "AAARemove" in "nameContact" textbox
    And I set "jb@jb.com" in "emailContact" textbox
    And I set "44444444" in "phoneContact" textbox
    And I click on "save" button
    Then the contact "AAARemove" should be created