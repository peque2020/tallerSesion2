Feature: Login

  @Regression
  Scenario Outline: s

    Given tengo un usuario en facebook
    When llenar la caja de texto email con mi celular <numeroTelefono>
    And llenar la caja de texto password con <miPassword>
    Then <miVerificacion>

    Examples:
      | numeroTelefono | miPassword |miVerificacion |
      | 999888777      | admin      |yo deberia de ingresar a la aplicacion|
      | 111222333      | admin123   |yo deberia de ingresar a la aplicacion|
      | 444555666      | invalid    |yo no deberia de ingresar con pwd incorrecto|
      | 777888777      | invalid    |yo no deberia de ingresar con pwd incorrecto|