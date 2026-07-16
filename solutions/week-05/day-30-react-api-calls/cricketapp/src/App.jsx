import ListOfPlayers from './components/ListOfPlayers'
import IndianPlayers from './components/IndianPlayers'

// handout wants a plain flag variable deciding which component shows, just
// a simple if-else rather than a ternary since thats literally what it asks for
const flag = true

function App() {
  if (flag) {
    return <ListOfPlayers />
  } else {
    return <IndianPlayers />
  }
}

export default App
