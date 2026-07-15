import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import Home from './components/Home'
import TrainersList from './components/TrainersList'
import TrainerDetail from './components/TrainerDetail'
import trainersData from './TrainersMock'

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">home</Link> | <Link to="/trainers">trainers</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList trainers={trainersData} />} />
        <Route path="/trainers/:id" element={<TrainerDetail />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
