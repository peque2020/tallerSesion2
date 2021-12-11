Feature: Login Facebook

  @SmokeTest
  Scenario: Como usuario en facebook
            Quiero autenticarme con mi numero de celular
            Y mi password
            Para ingresar y utilizar facbook

    Given tengo un usuario en facebook
    When llenar la caja de texto email con mi celular 12345678
    And llenar la caja de texto password con p@ssw0rd
    Then yo deberia de ingresar a la aplicacion
