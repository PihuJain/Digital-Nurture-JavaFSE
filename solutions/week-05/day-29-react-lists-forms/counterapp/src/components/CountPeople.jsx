import { Component } from 'react'

// class component using constructor + this.state, handout wants exactly this
// pattern rather than the useState hook we used elsewhere this week
class CountPeople extends Component {
  constructor(props) {
    super(props)
    this.state = {
      entryCount: 0,
      exitCount: 0,
    }
  }

  updateEntry() {
    this.setState({ entryCount: this.state.entryCount + 1 })
  }

  updateExit() {
    this.setState({ exitCount: this.state.exitCount + 1 })
  }

  render() {
    return (
      <div>
        <p>people in mall: {this.state.entryCount - this.state.exitCount}</p>
        <p>entry count: {this.state.entryCount}</p>
        <p>exit count: {this.state.exitCount}</p>
        <button onClick={() => this.updateEntry()}>login</button>
        <button onClick={() => this.updateExit()}>exit</button>
      </div>
    )
  }
}

export default CountPeople
