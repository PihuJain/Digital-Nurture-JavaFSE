import { Component } from 'react'

// class component with lifecycle hooks, this is what file 4 actually wants
// (componentDidMount + componentDidCatch), even though the day label in the
// schedule says "events + conditional rendering" - noted in the readme too
class Posts extends Component {
  constructor(props) {
    super(props)
    this.state = {
      posts: [],
      hasError: false,
    }
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        this.setState({ posts: data })
      })
  }

  componentDidMount() {
    this.loadPosts()
  }

  componentDidCatch(error) {
    this.setState({ hasError: true })
    alert('something went wrong loading posts: ' + error.message)
  }

  render() {
    if (this.state.hasError) {
      return <p>could not load posts right now</p>
    }

    return (
      <div>
        {this.state.posts.slice(0, 10).map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    )
  }
}

export default Posts
