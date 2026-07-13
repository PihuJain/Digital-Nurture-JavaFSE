import Home from './components/Home'
import About from './components/About'
import Contact from './components/Contact'

// handout just wants all three called one after another, no routing yet
function App() {
  return (
    <div>
      <Home />
      <About />
      <Contact />
    </div>
  )
}

export default App
