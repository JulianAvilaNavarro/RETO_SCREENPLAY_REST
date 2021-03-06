Feature: Actualizar un recurso y borrar datos
  como un usuario registrado del sistema quiero actualizar un recurso del sistema y luego borrar un registro
  con el fin de saber de verificar los servicios del sistema


  Scenario: Actualizar un recurso
    Given el usuario esta en la pagina de busqueda y desea actualizar la informacion de una persona
    When el usuario actualiza el recurso que desea y obtiene una respuesta
    Then el usuario podra ver la confirmacion de la actualizacion


  Scenario: Borrar un registro
    Given el usuario esta en la pagina y desea borrar un registro
    When el usuario escribe la instruccion de borrar el registro
    Then el usuario obtiene una la respuesta de borrado
