package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final Target BACKPACK = Target.the("producto backpack")
            .locatedBy("[data-test='add-to-cart-sauce-labs-backpack']");

    public static final Target BIKE_LIGHT = Target.the("producto bike light")
            .locatedBy("[data-test='add-to-cart-sauce-labs-bike-light']");

    public static final Target CART = Target.the("carrito")
            .locatedBy("[data-test='shopping-cart-link']");
}
