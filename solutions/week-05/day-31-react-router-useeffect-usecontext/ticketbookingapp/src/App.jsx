import { useState } from 'react'
import GuestPage from './components/GuestPage'
import UserPage from './components/UserPage'

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false)

  return isLoggedIn ? (
    <UserPage onLogout={() => setIsLoggedIn(false)} />
  ) : (
    <GuestPage onLogin={() => setIsLoggedIn(true)} />
  )
}

export default App
