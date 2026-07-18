import { useState } from 'react'
import ThemeContext from './ThemeContext'
import EmployeeList from './components/EmployeeList'

const employees = [
  { id: 1, name: 'sunita rao' },
  { id: 2, name: 'arjun nair' },
]

function App() {
  const [theme, setTheme] = useState('light')

  return (
    <ThemeContext.Provider value={theme}>
      <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>
        switch theme
      </button>
      <EmployeeList employees={employees} />
    </ThemeContext.Provider>
  )
}

export default App
