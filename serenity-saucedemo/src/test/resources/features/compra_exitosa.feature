Feature: Compra de productos en SauceDemo

  Como usuario comprador
  Quiero adquirir productos
  Para completar exitosamente una compra

  Scenario: Comprar productos exitosamente

    Given que el usuario ingresa a SauceDemo
    When inicia sesion con credenciales validas
    And agrega dos productos al carrito
    And realiza el checkout
    Then la compra debe completarse exitosamente