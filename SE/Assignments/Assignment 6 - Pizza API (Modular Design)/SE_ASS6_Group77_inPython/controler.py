from datetime import datetime
from model import ALLORDER, Order, Pizza, ALLPIZZA, ALLORDER, current_order_id


def get_allpizzas_detail():
    pizza_list = []
    for pizza in ALLPIZZA:
        single_pizza = {
            "pizza_id": pizza.id,
            "name": pizza.name,
            "vegetarian": pizza.vegetarian,
            "price": pizza.price
        }
        pizza_list.append(single_pizza)
    return "{" + str(pizza_list) + "}"

def get_pizzas_detail(list):
    pizza_list = []
    for j in range(0,len(list)):
        for i in range(0,len(ALLPIZZA)):
            if(list[j] == ALLPIZZA[i].id):
                single_pizza = {
                    "pizza_id": ALLPIZZA[i].id,
                    "name": ALLPIZZA[i].name,
                    "vegetarian": ALLPIZZA[i].vegetarian,
                    "price": ALLPIZZA[i].price
                }
                pizza_list.append(single_pizza)
    return "{" + str(pizza_list) + "}"


def find_single_pizza(id) -> Pizza:
    for pizza in ALLPIZZA:
        if pizza.id == id:
            return pizza
    return None


def find_single_order(id) -> Order:
    for order in ALLORDER:
        if order.order_id == id:
            return order
    return None


def cancel_single_order(id) -> Order:
    for order in ALLORDER:
        if order.order_id == id:
            order.order_id = 0
            order.status = "cancelled"
    return None


def save_new_order(piazza: list, note: str, takeaway: bool, payment_type: str, customer_id: int,
                   delivery_address: dict):
    global current_order_id
    current_order_id += 1

    order = Order(current_order_id, customer_id, "In progress", datetime.now(), note, takeaway, payment_type,
                  delivery_address, piazza)
    ALLORDER.append(order)
    return order


print(find_single_order(1))
