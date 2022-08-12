import datetime
from time import sleep

current_order_id = 2

class Pizza:
    def __init__(self, id: int, name: str, vegetarian: bool, price: float, toppings: list):
        self.id = id
        self.name = name
        self.vegetarian = vegetarian
        self.price = price
        self.toppings = toppings

    def __repr__(self):
        return f" \n {self.id}, {self.name}, {self.vegetarian}, {self.price}, {self.toppings}"


class Order:
    def __init__(self, order_id: int, customer_id: int, status: str, order_at: datetime.datetime, note: str, takeaway: bool,
                 payment_type: str, delivery_address: dict, pizzas: list):
        self.order_id = order_id
        self.customer_id = customer_id
        self.status = status
        self.order_at = order_at.strftime(("%Y-%m-%d %H:%M:%S"))
        self.note = note
        self.takeaway = takeaway
        self.payment_type = payment_type
        self.delivery_address = delivery_address
        self.pizzas = pizzas
        self.inner_time = order_at

    def __repr__(self):
        return f"{self.pizzas}, {self.delivery_address}, {self.order_at}"


ALLPIZZA = [
    Pizza(0, "margarita", True, 12.50, ["Mozzarella", "Tomatoes", "Basil"]),
    Pizza(1, "meatlovers", False, 15.75, ["Beef", "Chicken", "Bacon", "Bell Peper"]),
    Pizza(2, "4cheese", True, 10.50, ["Mozzarella", "Tomatoes"]),
]

ALLORDER = [
    Order(1, 123456, "In Progress", datetime.datetime.now(), "no peper please", False,
               "cash",
               {"street": "something", "city": "something", "country": "something", "zipcode": "something"},
               [1, 1, 0, 2]),
    Order(2, 623456, "Delivered", datetime.datetime.now(), "something", True,
               "cash",
               {"street": "something", "city": "something", "country": "something", "zipcode": "something"},
               [1,1,1,1])
]


print(datetime.datetime.now().strftime(("%Y-%m-%d %H:%M:%S")))