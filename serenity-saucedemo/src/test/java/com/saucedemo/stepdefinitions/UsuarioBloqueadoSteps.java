package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.MensajeUsuarioBloqueado;
import com.saucedemo.tasks.AbrirSauceDemo;
import com.saucedemo.tasks.IniciarSesion;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class UsuarioBloqueadoSteps {

    @Managed(driver = "chrome")
    WebDriver navegador;

    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Guillermo")
                .can(BrowseTheWeb.with(navegador));
    }

    @Given("que el usuario bloqueado ingresa a SauceDemo")
    public void queElUsuarioBloqueadoIngresaASauceDemo() {

        OnStage.theActorInTheSpotlight()
                .wasAbleTo(
                        AbrirSauceDemo.laPagina()
                );
    }

    @When("inicia sesion con un usuario bloqueado")
    public void iniciaSesionConUnUsuarioBloqueado() {

        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        IniciarSesion.conCredenciales(
                                "locked_out_user",
                                "secret_sauce"
                        )
                );
    }

    @Then("debe visualizar un mensaje indicando que el usuario esta bloqueado")
    public void debeVisualizarUnMensajeIndicandoQueElUsuarioEstaBloqueado() {

        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                MensajeUsuarioBloqueado.visible(),
                                equalTo("Epic sadface: Sorry, this user has been locked out.")
                        )
                );
    }
}