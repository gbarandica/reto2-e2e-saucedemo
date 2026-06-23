Feature: Validación de precios

  Scenario: Verificar que los productos tengan precio visible

    Given que el usuario ingresa al login de SauceDemo
    When inicia sesión con usuario valido
    Then todos los productos deben mostrar un precio