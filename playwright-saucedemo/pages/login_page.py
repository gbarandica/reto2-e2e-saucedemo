from playwright.sync_api import Page


class LoginPage:

    def __init__(self, page: Page):
        self.page = page

    def abrir(self):
        self.page.goto("https://www.saucedemo.com/")

    def iniciar_sesion(self, usuario, password):
        self.page.locator("#user-name").fill(usuario)
        self.page.locator("#password").fill(password)
        self.page.locator("#login-button").click()