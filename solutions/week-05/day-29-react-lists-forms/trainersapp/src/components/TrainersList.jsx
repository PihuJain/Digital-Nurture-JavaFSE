import { Link } from 'react-router-dom'

// this is the "lists with .map() + keys" part of today, even though it lives
// inside a router exercise rather than the standalone lists file the day label expects
function TrainersList({ trainers }) {
  return (
    <ul>
      {trainers.map((trainer) => (
        <li key={trainer.trainerId}>
          <Link to={'/trainers/' + trainer.trainerId}>{trainer.name}</Link>
        </li>
      ))}
    </ul>
  )
}

export default TrainersList
