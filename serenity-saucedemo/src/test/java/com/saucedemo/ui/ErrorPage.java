package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ErrorPage {

    public static final Target ERROR_MESSAGE = Target.the("mensaje de usuario bloqueado")
            .locatedBy("[data-test='error']");
}
