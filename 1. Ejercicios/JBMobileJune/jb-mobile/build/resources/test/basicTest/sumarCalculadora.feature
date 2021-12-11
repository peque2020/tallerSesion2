Feature: Calculadora

  @Calculadora
  Scenario: Como usuario de la calculadora
  Quiero sumar dos digitos
  Para verificar la funcionalidad de la suma.


    Given tengo abierta la calculadora
    When presiono el boton 9
    And presiono el boton "suma"
    And presiono el boton 5
    And presiono el boton "igual"
    Then el resultado deberia ser 14