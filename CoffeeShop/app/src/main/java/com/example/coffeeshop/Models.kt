package com.example.coffeeshop

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val description: String,
    val price: Double,
    val imageRes: Int
)

data class CartItem(
    val product: Product,
    var quantity: Int,
    val size: String
) {
    val lineTotal: Double get() = product.price * quantity
}

object ProductRepository {
    val products = listOf(
        Product(1, "Espresso", "Hot", "Rich and bold single shot.", 120.0, R.drawable.ic_coffee),
        Product(2, "Cappuccino", "Hot", "Espresso with steamed milk foam.", 180.0, R.drawable.ic_coffee),
        Product(3, "Latte", "Hot", "Smooth espresso with steamed milk.", 190.0, R.drawable.ic_coffee),
        Product(4, "Mocha", "Hot", "Espresso, chocolate and milk.", 210.0, R.drawable.ic_coffee),
        Product(5, "Iced Coffee", "Cold", "Chilled brew served over ice.", 160.0, R.drawable.ic_coffee),
        Product(6, "Cold Brew", "Cold", "Slow-steeped for 12 hours.", 200.0, R.drawable.ic_coffee),
        Product(7, "Frappe", "Cold", "Blended iced coffee with cream.", 230.0, R.drawable.ic_coffee)
    )

    fun getById(id: Int): Product = products.first { it.id == id }
}

object Cart {
    val items = mutableListOf<CartItem>()

    fun add(product: Product, quantity: Int, size: String) {
        val existing = items.find { it.product.id == product.id && it.size == size }
        if (existing != null) existing.quantity += quantity
        else items.add(CartItem(product, quantity, size))
    }

    fun remove(item: CartItem) { items.remove(item) }

    fun total(): Double = items.sumOf { it.lineTotal }
}
