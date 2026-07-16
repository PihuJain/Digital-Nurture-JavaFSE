const squad = ['rohit', 'virat', 'rahul', 'pant', 'jadeja', 'bumrah', 'shami', 'axar', 'gill', 'iyer', 'kuldeep']

const t20Players = ['rohit', 'virat', 'pant']
const ranjiTrophyPlayers = ['sarfaraz', 'yash', 'mukesh']

// odd/even split via array destructuring, picking every other name straight
// out of the squad array instead of looping with an index
const [even0, odd0, even1, odd1, even2, odd2, even3, odd3, even4, odd4, even5] = squad
const evenTeam = [even0, even1, even2, even3, even4, even5]
const oddTeam = [odd0, odd1, odd2, odd3, odd4]

// merge feature - spread both squads into one combined array
const allIndiaPlayers = [...t20Players, ...ranjiTrophyPlayers]

function IndianPlayers() {
  return (
    <div>
      <h2>even team</h2>
      <p>{evenTeam.join(', ')}</p>

      <h2>odd team</h2>
      <p>{oddTeam.join(', ')}</p>

      <h2>t20 + ranji trophy combined squad</h2>
      <p>{allIndiaPlayers.join(', ')}</p>
    </div>
  )
}

export default IndianPlayers
