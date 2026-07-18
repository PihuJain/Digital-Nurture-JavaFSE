import { useContext } from 'react'
import ThemeContext from '../ThemeContext'

// this is the whole point of the exercise - reads theme straight off
// context instead of getting it handed down as a prop from EmployeeList
function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext)

  return (
    <div className={'card ' + theme}>
      <p>{employee.name}</p>
      <button className={'btn ' + theme}>view profile</button>
    </div>
  )
}

export default EmployeeCard
