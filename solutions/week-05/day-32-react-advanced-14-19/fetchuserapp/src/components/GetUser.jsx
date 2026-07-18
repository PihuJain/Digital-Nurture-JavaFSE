import { Component } from 'react'

class GetUser extends Component {
  constructor(props) {
    super(props)
    this.state = {
      user: null,
    }
  }

  componentDidMount() {
    fetch('https://randomuser.me/api/')
      .then((response) => response.json())
      .then((data) => {
        this.setState({ user: data.results[0] })
      })
  }

  render() {
    if (!this.state.user) {
      return <p>loading user...</p>
    }

    const { user } = this.state

    return (
      <div>
        <img src={user.picture.large} alt={user.name.first} />
        <p>{user.name.title} {user.name.first} {user.name.last}</p>
      </div>
    )
  }
}

export default GetUser
