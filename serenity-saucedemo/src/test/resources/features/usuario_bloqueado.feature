Feature: Usuario bloqueado

  Como usuario del sistema
  Quiero conocer cuando mi acceso es restringido
  Para visualizar el mensaje correspondiente

  Scenario: Intentar iniciar sesion con usuario bloqueado

    Given que el usuario bloqueado ingresa a SauceDemo
    When inicia sesion con un usuario bloqueado
    Then debe visualizar un mensaje indicando que el usuario esta bloqueado