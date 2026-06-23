from playwright.sync_api import Page


class InventoryPage:

    def __init__(self, page: Page):
        self.page = page

    def obtener_precios(self):
        return self.page.locator(".inventory_item_price").all_text_contents()
    
    def ordenar_por_precio_ascendente(self):
        self.page.locator("[data-test='product-sort-container']").select_option("lohi")

    def obtener_precios_numericos(self):
        precios_texto = self.page.locator(".inventory_item_price").all_text_contents()
        return [float(precio.replace("$", "")) for precio in precios_texto]