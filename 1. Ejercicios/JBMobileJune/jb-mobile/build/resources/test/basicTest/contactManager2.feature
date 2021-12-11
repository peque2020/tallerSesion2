Feature: ContactManager2
  @ContactManager
  Scenario: Como usuario
  Quiero almacenar mis contactos
  Para guardarlos en el telefono

    Given que tengo la aplicacion ContactManager
    And hago click en boton OK si existe el update dialog
    When hago click en el boton "addContact"
    And seteo la caja de texto "nameContact" con "AAARemoveCucumber"
    And seteo la caja de texto "numberContact" con "777788889"
    And seteo la caja de texto "emailContact" con "remove@remove.com"
    And hago click en el boton "save"
    Then el contacto "AAARemoveCucumber" deberia ser creado
