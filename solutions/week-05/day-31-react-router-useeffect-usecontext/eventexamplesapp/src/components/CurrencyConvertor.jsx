import { Component } from 'react'

// fixed conversion rate, handout doesnt want a live api call here just the
// event handling around a form submit
const RUPEES_TO_EURO = 0.011

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props)
    this.state = {
      rupees: '',
      euro: null,
    }
    this.handleChange = this.handleChange.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)
  }

  handleChange(event) {
    this.setState({ rupees: event.target.value })
  }

  handleSubmit(event) {
    event.preventDefault()
    const euro = Number(this.state.rupees) * RUPEES_TO_EURO
    this.setState({ euro: euro.toFixed(2) })
  }

  render() {
    return (
      <div>
        <h2>currency convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <input type="number" value={this.state.rupees} onChange={this.handleChange} placeholder="amount in rupees" />
          <button type="submit">convert</button>
        </form>
        {this.state.euro !== null && <p>{this.state.rupees} rupees is {this.state.euro} euro</p>}
      </div>
    )
  }
}

export default CurrencyConvertor
