from behave import given, when, then
from playwright.sync_api import sync_playwright

from pages.login_page import LoginPage
from pages.inventory_page import InventoryPage


@given("que el usuario se encuentra autenticado en SauceDemo")
def step_impl(context):
    context.playwright = sync_playwright().start()
    context.browser = context.playwright.chromium.launch(headless=False)
    context.page = context.browser.new_page()

    login = LoginPage(context.page)
    login.abrir()
    login.iniciar_sesion("standard_user", "secret_sauce")


@when("ordena los productos por precio de menor a mayor")
def step_impl(context):
    inventory = InventoryPage(context.page)
    inventory.ordenar_por_precio_ascendente()


@then("los productos deben mostrarse ordenados por precio ascendente")
def step_impl(context):
    inventory = InventoryPage(context.page)
    precios = inventory.obtener_precios_numericos()

    assert precios == sorted(precios)

    context.browser.close()
    context.playwright.stop()