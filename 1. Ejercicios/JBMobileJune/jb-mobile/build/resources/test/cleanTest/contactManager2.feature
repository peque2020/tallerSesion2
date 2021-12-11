Feature: CreateContact

  @JBGROUP
  Scenario: As user, i want create contact so that save in the sim

    Given have the contact manager app
    And click on "ok" button in update dialog if exist
    When click on "addContact" button list contact
    And set "AAARemove" in "nameContact" textbox
    And set "jb@jb.com" in "emailContact" textbox
    And set "44444444" in "phoneContact" textbox
    And click on "save" button
    Then contact "AAARemove" should be created