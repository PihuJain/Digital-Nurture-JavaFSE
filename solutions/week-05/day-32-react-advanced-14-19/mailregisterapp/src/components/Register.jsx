import { Component } from 'react'

class Register extends Component {
  constructor(props) {
    super(props)
    this.state = {
      name: '',
      email: '',
      password: '',
      errors: {},
    }
    this.handleChange = this.handleChange.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value })
  }

  validate() {
    const errors = {}

    if (this.state.name.length < 5) {
      errors.name = 'name should have at least 5 characters'
    }
    // not doing a full rfc email regex here, just the two things the
    // handout actually asks for - an @ and a dot somewhere after it
    if (!this.state.email.includes('@') || !this.state.email.includes('.')) {
      errors.email = 'email should have @ and .'
    }
    if (this.state.password.length < 8) {
      errors.password = 'password should have at least 8 characters'
    }

    return errors
  }

  handleSubmit(event) {
    event.preventDefault()
    const errors = this.validate()
    this.setState({ errors })
  }

  render() {
    const { errors } = this.state

    return (
      <form onSubmit={this.handleSubmit}>
        <input name="name" placeholder="name" value={this.state.name} onChange={this.handleChange} />
        {errors.name && <p>{errors.name}</p>}

        <input name="email" placeholder="email" value={this.state.email} onChange={this.handleChange} />
        {errors.email && <p>{errors.email}</p>}

        <input name="password" type="password" placeholder="password" value={this.state.password} onChange={this.handleChange} />
        {errors.password && <p>{errors.password}</p>}

        <button type="submit">register</button>
      </form>
    )
  }
}

export default Register
