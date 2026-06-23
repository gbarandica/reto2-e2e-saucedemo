Feature: Ordenamiento de productos

  Scenario: Ordenar productos de menor a mayor precio

    Given que el usuario se encuentra autenticado en SauceDemo
    When ordena los productos por precio de menor a mayor
    Then los productos deben mostrarse ordenados por precio ascendente