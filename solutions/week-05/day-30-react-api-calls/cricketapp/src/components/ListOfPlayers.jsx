const players = [
  { name: 'rohit', score: 45 },
  { name: 'virat', score: 82 },
  { name: 'rahul', score: 30 },
  { name: 'pant', score: 55 },
  { name: 'jadeja', score: 91 },
  { name: 'bumrah', score: 12 },
  { name: 'shami', score: 8 },
  { name: 'axar', score: 63 },
  { name: 'gill', score: 74 },
  { name: 'iyer', score: 40 },
  { name: 'kuldeep', score: 20 },
]

// filter below 70 uses an arrow function same as the handout wants, map()
// handles the actual list rendering below it
function ListOfPlayers() {
  const lowScorers = players.filter((player) => player.score < 70)

  return (
    <div>
      <h2>all players</h2>
      <ul>
        {players.map((player) => (
          <li key={player.name}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h3>players scoring below 70</h3>
      <ul>
        {lowScorers.map((player) => (
          <li key={player.name}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default ListOfPlayers
