package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutCompletePage {

    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de compra exitosa")
            .locatedBy("[data-test='complete-header']");
}
