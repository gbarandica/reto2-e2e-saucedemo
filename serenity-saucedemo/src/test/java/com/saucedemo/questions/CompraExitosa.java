package com.saucedemo.questions;

import com.saucedemo.ui.CheckoutCompletePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CompraExitosa implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutCompletePage.SUCCESS_MESSAGE)
                .answeredBy(actor);
    }

    public static CompraExitosa mensaje() {
        return new CompraExitosa();
    }
}
