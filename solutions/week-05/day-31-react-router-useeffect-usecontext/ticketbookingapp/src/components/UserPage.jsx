function UserPage({ onLogout }) {
  return (
    <div>
      <h2>book your ticket</h2>
      <p>welcome back, you can book a flight now</p>
      <button>book flight AI 202</button>
      <button onClick={onLogout}>logout</button>
    </div>
  )
}

export default UserPage
