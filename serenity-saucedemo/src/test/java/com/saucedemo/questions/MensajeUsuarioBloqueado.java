package com.saucedemo.questions;

import com.saucedemo.ui.ErrorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeUsuarioBloqueado implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ErrorPage.ERROR_MESSAGE)
                .answeredBy(actor);
    }

    public static MensajeUsuarioBloqueado visible() {
        return new MensajeUsuarioBloqueado();
    }
}
