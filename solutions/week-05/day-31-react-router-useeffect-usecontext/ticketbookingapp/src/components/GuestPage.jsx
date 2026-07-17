function GuestPage({ onLogin }) {
  const flights = [
    { flightNo: 'AI 202', from: 'delhi', to: 'mumbai' },
    { flightNo: '6E 411', from: 'bangalore', to: 'pune' },
  ]

  return (
    <div>
      <h2>available flights</h2>
      <ul>
        {flights.map((f) => (
          <li key={f.flightNo}>
            {f.flightNo}: {f.from} to {f.to}
          </li>
        ))}
      </ul>
      <p>login to book a ticket</p>
      <button onClick={onLogin}>login</button>
    </div>
  )
}

export default GuestPage
