package com.saucedemo.tasks;

import com.saucedemo.ui.CartPage;
import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON),

                Enter.theValue("Guillermo").into(CheckoutPage.FIRST_NAME),
                Enter.theValue("Barandica").into(CheckoutPage.LAST_NAME),
                Enter.theValue("080001").into(CheckoutPage.ZIP_CODE),

                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    public static RealizarCheckout exitosamente() {
        return instrumented(RealizarCheckout.class);
    }
}
