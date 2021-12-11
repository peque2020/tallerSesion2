Feature: ContactManager

  @ContactManager
  Scenario: Como usuario
            Quiero almacenar mis contactos
            Para guardarlos en el telefono

    Given que tengo la aplicacion ContactManager
    And hago click en boton OK si existe el update dialog
    When hago click en el boton "addContact"
    And seteo las cajas de texto con:
      | nameContact  | AAARemoveCucumber  |
      | numberContact| 777788889          |
      | emailContact | remove@remove.com  |
    And hago click en el boton "save"
    Then el contacto "AAARemoveCucumber" deberia ser creado