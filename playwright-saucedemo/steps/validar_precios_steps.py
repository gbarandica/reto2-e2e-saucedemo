from behave import given, when, then
from playwright.sync_api import sync_playwright

from pages.login_page import LoginPage
from pages.inventory_page import InventoryPage


@given("que el usuario ingresa al login de SauceDemo")
def step_impl(context):

    context.playwright = sync_playwright().start()

    context.browser = context.playwright.chromium.launch(
        headless=False
    )

    context.page = context.browser.new_page()

    login = LoginPage(context.page)

    login.abrir()


@when("inicia sesión con usuario valido")
def step_impl(context):

    login = LoginPage(context.page)

    login.iniciar_sesion(
        "standard_user",
        "secret_sauce"
    )


@then("todos los productos deben mostrar un precio")
def step_impl(context):

    inventory = InventoryPage(context.page)

    precios = inventory.obtener_precios()

    assert len(precios) > 0

    for precio in precios:
        assert "$" in precio

    context.browser.close()
    context.playwright.stop()