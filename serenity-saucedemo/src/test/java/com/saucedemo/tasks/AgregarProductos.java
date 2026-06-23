package com.saucedemo.tasks;

import com.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(InventoryPage.BACKPACK),
                Click.on(InventoryPage.BIKE_LIGHT),
                Click.on(InventoryPage.CART)
        );
    }

    public static AgregarProductos alCarrito() {
        return instrumented(AgregarProductos.class);
    }
}
