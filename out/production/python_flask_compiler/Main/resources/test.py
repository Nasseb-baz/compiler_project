from flask import Flask,render_template,redirect,url_for,request

app = Flask(__name__)

products = []

@app.route("/")
def list_products():
<INDENT>
    return render_template("product_template.html", section="list", products=products)
<DEDENT>

@app.route("/add", methods=["GET", "POST"])
def add_product():
<INDENT>
    if request.method == "POST":
<INDENT>
        name = request.form.get("name")
        price = request.form.get("price")
        description = request.form.get("description")
        image = request.form.get("image")
        product = {
        "id": len(products) + 1,
        "name": name,
        "price": price,
        "description": description,
        "image": image
        }
        products.append(product)
        return redirect(url_for("list_products"))
        <DEDENT>
    return render_template("product_template.html", section="add")
<DEDENT>

@app.route("/product/<int:product_id>")
def view_product(product_id):
<INDENT>
    for product in products:
    <INDENT>
        if(product["id"] == product_id):
        <INDENT>
            return render_template("product_template.html", section="view", product=product)
        <DEDENT>
    return "Product not found"
    <DEDENT>
<DEDENT>

if __name__ == "__main__":
<INDENT>
    app.run(debug=True)
<DEDENT>
