import EmployeeCard from './EmployeeCard'

// no theme prop passed through here anymore, thats the whole substandard
// technique the qa team flagged - context handles it now instead
function EmployeeList({ employees }) {
  return (
    <div>
      {employees.map((employee) => (
        <EmployeeCard key={employee.id} employee={employee} />
      ))}
    </div>
  )
}

export default EmployeeList
