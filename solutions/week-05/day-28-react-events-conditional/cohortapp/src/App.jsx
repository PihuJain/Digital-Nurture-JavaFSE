import CohortDetails from './components/CohortDetails'

const cohorts = [
  { name: 'java fse batch 12', status: 'ongoing', trainer: 'sunita rao' },
  { name: 'python fse batch 9', status: 'completed', trainer: 'arjun nair' },
]

function App() {
  return (
    <div>
      {cohorts.map((cohort) => (
        <CohortDetails key={cohort.name} cohort={cohort} />
      ))}
    </div>
  )
}

export default App
