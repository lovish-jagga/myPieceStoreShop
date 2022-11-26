class Product {
  constructor(title, image, desc, price) {
    this.title = title;
    this.imageUrl = image;
    this.description = desc;
    this.price = price;
  }
}

class ElementAttribute {
  constructor(attrName, attrValue) {
    this.name = attrName;
    this.value = attrValue;
  }
}

class Component {
  constructor(renderHookId) {
    this.hookId = renderHookId;
  }

  createRootElement(tag, cssClasses, attributes) {
    const rootElement = document.createElement(tag);
    if (cssClasses) {
      rootElement.className = cssClasses;
    }
    if (attributes && attributes.length > 0) {
      for (const attr of attributes) {
        rootElement.setAttribute(attr.name, attr.value);
      }
    }
    document.getElementById(this.hookId).append(rootElement);
    return rootElement;
  }
}

class ShoppingCart extends Component {
  items =[ ];
  set cartItems(value) {
    this.items = value;
    this.totalOutput.innerHTML = `<h2>Total: \$${this.totalAmount.toFixed(2)}</h2>`;
  }

  get totalAmount() {
    const sum = this.items.reduce(
      (prevValue, curItem) => prevValue + curItem.price,
      0
    );
    return sum;
  }

  constructor(renderHookId) {
    super(renderHookId);
  }
     orderedItems()
   {
	if(this.totalAmount == 0)
	{
		return;
	}
		    const price = this.createRootElement('div', 'lineUp backdrop visible');
	   // div.id='price__modal';
    price.innerHTML=`
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="login-heading">PayMent Window</h5>
            </div>
            <div class="modal-body">
            <h1>Price : \$${this.totalAmount.toFixed(2)}</h1>
            <button onclick="location.href='./ThanksForShopping.jsp'"> Pay The Bill </button>
            </div>
    </div>
	</div>
    `;
    }


  addProduct(product) {
    const updatedItems = [...this.items];
    updatedItems.push(product);
    this.cartItems = updatedItems;
  }

  render() {
    const cartEl = this.createRootElement('section', 'cart');
    cartEl.innerHTML = `<h2>Total: \$${0}</h2><button>Order Now!</button>`;
    this.totalOutput = cartEl.querySelector('h2');
    const button=cartEl.querySelector('button');
    button.addEventListener('click',this.orderedItems.bind(this))
    this.totalOutput = cartEl.querySelector('h2');

  }
}

class ProductItem {
  constructor(product) {
    this.product = product;
  }

  addToCart() {
    App.addProductToCart(this.product);
  }

  render() {
    const prodEl = document.createElement('li');
    prodEl.className = 'product-item lineUp';
    prodEl.innerHTML = `
        <div>
          <img src="${this.product.imageUrl}" alt="${this.product.title}" >
          <div class="product-item__content">
            <h2>${this.product.title}</h2>
            <h3>\$${this.product.price}</h3>
            <p>${this.product.description}</p>
            <button>Add to Cart</button>
          </div>
        </div>
      `;
    const addCartButton = prodEl.querySelector('button');
    addCartButton.addEventListener('click', this.addToCart.bind(this));
    return prodEl;
  }
}

class ProductList {
  products = [
    new Product(
      'Slim fit shirt',
      './Image/men__product1.jpg',
      'A trending pink shirt!',
      19.99
    ),
    new Product(
      'Pocket Shirt',
      './Image/men__product4.jpg',
      'Slim Stripped Pocket Shirt',
      69.99
    ),
    new Product(
      'Carduoroy shirt',
      './Image/men__product5.jpg',
      'Fit micro carduoroy Shirt',
      39.99
),
    new Product(
      'Water Resistant shirt',
      './Image/men__product8.jpg',
      'Water Resistant Backpack Shirt',
      29.99
)
  ];

  constructor() {}

  render() {
    const prodList = document.createElement('ul');
    prodList.className = 'product-list';
    for (const prod of this.products) {
      const productItem = new ProductItem(prod);
      const prodEl = productItem.render();
      prodList.append(prodEl);
    }
    return prodList;
  }
}

class Shop {
  render() {
    const renderHook = document.getElementById('app');

    this.cart = new ShoppingCart('app');
    this.cart.render();
    const productList = new ProductList();
    const prodListEl = productList.render();

    renderHook.append(prodListEl);
  }
}

class App {
  static cart;

  static init() {
    const shop = new Shop();
    shop.render();
    this.cart = shop.cart;
  }

  static addProductToCart(product) {
    this.cart.addProduct(product);
  }
}

App.init();
