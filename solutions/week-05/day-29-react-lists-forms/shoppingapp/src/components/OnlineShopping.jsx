import { Component } from 'react'
import Cart from './Cart'

// class component, handout wants OnlineShopping as a class holding an array
// of 5 Cart items and looping through them to render - this is the one file
// out of today's three that actually matches "lists" from the day label
class OnlineShopping extends Component {
  constructor(props) {
    super(props)
    this.items = [
      new Cart('notebook', 60),
      new Cart('pen set', 45),
      new Cart('backpack', 899),
      new Cart('water bottle', 250),
      new Cart('calculator', 620),
    ]
  }

  render() {
    return (
      <div>
        <h2>online shopping cart</h2>
        <ul>
          {this.items.map((item, index) => (
            // using index as key here since Cart only has itemName/price, no id.
            // not ideal but items dont reorder in this demo so its fine
            <li key={index}>
              {item.itemName} - rs {item.price}
            </li>
          ))}
        </ul>
      </div>
    )
  }
}

export default OnlineShopping
