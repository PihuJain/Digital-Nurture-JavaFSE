import { Component } from 'react'

class ComplaintRegister extends Component {
  constructor(props) {
    super(props)
    this.state = {
      employeeName: '',
      complaint: '',
    }
    this.handleSubmit = this.handleSubmit.bind(this)
  }

  handleSubmit(event) {
    event.preventDefault()
    // reference number just needs to be unique enough for a demo, not a
    // real ticketing system backing it
    const refNumber = 'REF' + Math.floor(Math.random() * 900000 + 100000)
    alert('complaint registered for ' + this.state.employeeName + ', reference number: ' + refNumber)
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <input
          type="text"
          placeholder="employee name"
          value={this.state.employeeName}
          onChange={(e) => this.setState({ employeeName: e.target.value })}
        />
        <textarea
          placeholder="describe the complaint"
          value={this.state.complaint}
          onChange={(e) => this.setState({ complaint: e.target.value })}
        />
        <button type="submit">submit complaint</button>
      </form>
    )
  }
}

export default ComplaintRegister
