Feature: Login Facebook

  Background:
    Given tengo un usuario en facebook


  Scenario: Como usuario en facebook
  Quiero autheticarme con mi numero de celular
  Y mi password
  Para ingresar y utilizar facebook


    When llenar la caja de texto email con mi celular 234234234
    And llenar la caja de texto password con p@ssw0rd
    Then yo deberia de ingresar a la aplicacion

  Scenario: Como usuario en facebook
  Quiero autheticarme con mi numero de celular
  Y mi password
  Para ingresar y utilizar facebook

    When llenar la caja de texto email con mi celular 234234234
    Then yo no deberia de ingresar con pwd incorrecto


  Scenario: Como usuario en facebook
  Quiero autheticarme con mi numero de celular
  Y mi password
  Para ingresar y utilizar facebook

    And llenar la caja de texto password con p@ssw0rd
    Then yo no deberia de ingresar con pwd incorrecto