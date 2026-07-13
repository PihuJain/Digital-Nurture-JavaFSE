import '../stylesheets/mystyle.css'

// function component this time, day 27 file 3 wants function not class
// handout wasnt super clear on what "goal" means here, going with it as
// number of subjects the total was scored across, so average = total / goal
function CalculateScore(props) {
  const average = props.total / props.goal

  return (
    <div className="score-card">
      <h2>{props.name}</h2>
      <p>{props.school}</p>
      <p>total marks: {props.total}</p>
      <p>subjects: {props.goal}</p>
      <p className="average">average score: {average.toFixed(2)}</p>
    </div>
  )
}

export default CalculateScore
