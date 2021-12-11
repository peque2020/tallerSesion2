Feature: Test

  @Regression
  Scenario: test scenario

    Given que yo tengo una lista de usuarios
      | jose |
      | juan |
      | pedro|
    When yo defino password en comun con el valor "Password123"
    And yo utilizo los campos de:
      |user   | pwd      |
      |jbgroup| 123      |
    And yo utilizo los valores:
      |user | jose          |
      |pwd  | 123           |
      |email| test@test.com |
      |fecha| 12/12/12      |