import { Component } from 'react'

// class component so `this` inside the handlers is actually the point of
// the exercise - handout specifically calls out "use this keyword"
class CounterEvents extends Component {
  constructor(props) {
    super(props)
    this.state = {
      count: 0,
      message: '',
    }
    this.increment = this.increment.bind(this)
    this.decrement = this.decrement.bind(this)
  }

  increment() {
    // increment invokes two things at once like the handout wants -
    // bump the counter and say hello in the same click
    this.setState({ count: this.state.count + 1 })
    this.sayHello()
  }

  decrement() {
    this.setState({ count: this.state.count - 1 })
  }

  sayHello() {
    this.setState({ message: 'hello, counter went up' })
  }

  sayWelcome(name) {
    this.setState({ message: 'welcome ' + name })
  }

  handlePress(event) {
    // synthetic event, react wraps the native click event in its own
    // SyntheticEvent object, this is that object right here
    event.preventDefault()
    this.setState({ message: 'i was clicked' })
  }

  render() {
    return (
      <div>
        <h2>counter: {this.state.count}</h2>
        <button onClick={this.increment}>increment</button>
        <button onClick={this.decrement}>decrement</button>
        <button onClick={() => this.sayWelcome('welcome')}>say welcome</button>
        <button onClick={(e) => this.handlePress(e)}>onpress</button>
        <p>{this.state.message}</p>
      </div>
    )
  }
}

export default CounterEvents
