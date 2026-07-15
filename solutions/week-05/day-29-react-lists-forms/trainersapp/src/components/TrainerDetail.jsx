import { useParams } from 'react-router-dom'
import trainersData from '../TrainersMock'

function TrainerDetail() {
  const { id } = useParams()
  const trainer = trainersData.find((t) => t.trainerId === Number(id))

  if (!trainer) {
    return <p>trainer not found</p>
  }

  return (
    <div>
      <h2>{trainer.name}</h2>
      <p>email: {trainer.email}</p>
      <p>phone: {trainer.phone}</p>
      <p>technology: {trainer.technology}</p>
      <p>skills: {trainer.skills.join(', ')}</p>
    </div>
  )
}

export default TrainerDetail
