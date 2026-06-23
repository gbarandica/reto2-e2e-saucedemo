package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.CompraExitosa;
import com.saucedemo.tasks.AbrirSauceDemo;
import com.saucedemo.tasks.AgregarProductos;
import com.saucedemo.tasks.IniciarSesion;
import com.saucedemo.tasks.RealizarCheckout;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

public class CompraExitosaSteps {

    @Managed(
    driver = "chrome",
    options = "--disable-notifications,--disable-save-password-bubble"
)
    WebDriver navegador;

    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Guillermo")
                .can(BrowseTheWeb.with(navegador));
    }

    @Given("que el usuario ingresa a SauceDemo")
    public void queElUsuarioIngresaASauceDemo() {

        OnStage.theActorInTheSpotlight()
                .wasAbleTo(
                        AbrirSauceDemo.laPagina()
                );
    }

    @When("inicia sesion con credenciales validas")
    public void iniciaSesion() {

        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        IniciarSesion.conCredenciales(
                                "standard_user",
                                "secret_sauce"
                        )
                );
    }

    @And("agrega dos productos al carrito")
    public void agregaDosProductosAlCarrito() {

        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        AgregarProductos.alCarrito()
                );
    }

    @And("realiza el checkout")
    public void realizaElCheckout() {

        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        RealizarCheckout.exitosamente()
                );
    }

    @Then("la compra debe completarse exitosamente")
    public void laCompraDebeCompletarseExitosamente() {

        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                CompraExitosa.mensaje(),
                                equalTo("Thank you for your order!")
                        )
                );
    }
}
