Feature: Actualizar y Obtener informacion en la pagina jsonplaceholder
  Como usuario registrado del sistema
  quiero actualizar y ver mi informacion
  para poder corroborarla

  Scenario: Actualizar informacion
    Given el usuario se encuentra en la pagina y desea actualizar su informacion
    When el usuario utiliza la funcion put
    Then el usuario vera que su informacion fue actualizada

  Scenario: Obtener informacion
    Given el usuario esta en la pagina y desea ver su informacion
    When el usuario utiliza la funcion get
    Then el usuario vera que su informacion