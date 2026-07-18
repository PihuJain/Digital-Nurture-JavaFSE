import { createContext } from 'react'

// default value is 'light', anything not wrapped in a provider still gets
// this instead of undefined
const ThemeContext = createContext('light')

export default ThemeContext
