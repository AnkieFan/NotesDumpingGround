import datetime
from flask import Flask, request, make_response, render_template
from controler import cancel_single_order, find_single_order, get_pizzas_detail, find_single_pizza, save_new_order,get_allpizzas_detail

app = Flask(__name__)


@app.route("/")
def home():
    return render_template("welcome.html")


@app.route("/pizza", methods=["GET"])
def show_all_pizza():
    return make_response(get_allpizzas_detail(), "200: Success")


@app.route("/pizza/<pizza_id>", methods=["GET"])
def show_single_pizza(pizza_id: int):
    temp = find_single_pizza(int(pizza_id))
    if temp != None:
        return make_response(
            {"pizza_id": temp.id, "name": temp.name, "vegetarian": temp.vegetarian, "price": temp.price,
             "toppings": str(temp.toppings)}, 200)
    else:
        return make_response({"message": "Pizza not found"}, "404: Pizza ID not found in server database")


@app.route("/order/<order_id>", methods=["GET"])
def show_single_order(order_id):
    id = None
    try:
        id = int(order_id)
    except:
        return make_response({"message": "Invalid ID supplied"}, "400: Invalid ID supplied")

    order = find_single_order(id)
    if order != None:

        order_info = {"order_id": order.order_id, "customer_id": order.customer_id, "status": order.status,
                      "ordered_at": order.order_at,
                      "note": order.note, "takeaway": order.takeaway, "payment_type": order.payment_type,
                      "delivery_address": str(order.delivery_address)}
        pizza_info = get_pizzas_detail(order.pizzas)

        return make_response(str(order_info) + "\n" + str(pizza_info), "200: Success")
    else:
        return make_response({"message": "Order ID not found"}, "404: Order_ID not found")


@app.route("/order", methods=["POST"])
def process_order():
    pizzas = request.form["pizzas"]
    takeaway = request.form["takeaway"]
    payment_type = request.form["payment_type"]
    customer_id = request.form["customer_id"]
    note = request.form["note"]
    street = request.form["street"]
    city = request.form["city"]
    country = request.form["country"]
    zipcode = request.form["zipcode"]

    try:
        pizzasList = []
        for i in range(0, len(pizzas)):
            if (pizzas[i] != ','):
                pizzasList.append(int(pizzas[i]))

        if takeaway.startswith('y'):
            takeaway = True
        else:
            takeaway = False

        delivery_address = {
            "steet": street,
            "city": city,
            "country": country,
            "zipcode": zipcode
        }
        order = save_new_order(pizzasList, note, takeaway, payment_type, int(customer_id), delivery_address)
        order_info = {"order_id": order.order_id, "customer_id": order.customer_id, "status": order.status,
                      "ordered_at": order.order_at,
                      "note": order.note, "takeaway": order.takeaway, "payment_type": order.payment_type,
                      "delivery_address": str(order.delivery_address)}

        date = order.inner_time + datetime.timedelta(minutes=30)
        final_message = {
            "order": order_info,
            "ordered at": order.inner_time.strftime(("%Y-%m-%d %H:%M:%S")),
            "delivery time": date.strftime(("%Y-%m-%d %H:%M:%S"))
        }
        return make_response(str(final_message), "200: Success")
    except:
        return make_response({"message": "The format of the object is not valid"}, "400: Invalid body")


@app.route("/order", methods=["GET"])
def create_order_template():
    return render_template("create_order.html")


@app.route("/order/cancel/<order_id>")
def cancel_order(order_id: int):
    id = int(order_id)
    order = find_single_order(id)
    if order == None:
        return make_response({"message": "Order not found"}, "404: Order ID not found in server database")
    elif order.status.lower().startswith("c") or order.status.lower().startswith("d"):
        return make_response({"message": "Unable to cancel an already canceled or delivered order"},
                             "422: Cancellation failed because it has already been cancelled or delivered.")
    elif (datetime.datetime.now() - order.inner_time).seconds > 60:
        return make_response({"message": "Unable to cancel your order after 5 minutes have elapsed."},
                             "412: Cancellation cannot be performed because 5 minutes has elapsed from order time")
    else:
        cancel_single_order(id)
        order_info = {"order_id": order.order_id, "customer_id": order.customer_id, "status": order.status,
                      "ordered_at": order.order_at,
                      "note": order.note, "takeaway": order.takeaway, "payment_type": order.payment_type,
                      "delivery_address": str(order.delivery_address)}
        return make_response(order_info, "200:Success")


@app.route("/order/deliverytime/<order_id>", methods=["GET"])
def delivery_process(order_id: int):
    id = int(order_id)
    order = find_single_order(id)
    if order == None:
        return make_response({"message": "Order not found"}, "404: Order ID not found in server database")
    else:
        order_info = {"order_id": order.order_id, "customer_id": order.customer_id, "status": order.status,
                      "ordered_at": order.order_at,
                      "note": order.note, "takeaway": order.takeaway, "payment_type": order.payment_type,
                      "delivery_address": str(order.delivery_address)}
        final_message = {
            "delivery_time": order.inner_time + datetime.timedelta(minutes=30),
            "order": order_info
        }
        return make_response(final_message, "200: Success")


if __name__ == "__main__":
    app.run(debug=True)
