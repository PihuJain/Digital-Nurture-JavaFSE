const office = {
  name: 'skyline business hub',
  rent: 55000,
  address: 'sector 62, noida',
}

// list of office objects to loop through, second item deliberately above
// 60000 so both the red and green rent styling actually shows up somewhere
const officeList = [
  { name: 'skyline business hub', rent: 55000, address: 'sector 62, noida' },
  { name: 'techpark towers', rent: 72000, address: 'whitefield, bangalore' },
  { name: 'riverside offices', rent: 48000, address: 'hinjewadi, pune' },
]

function rentColor(rent) {
  return rent < 60000 ? 'red' : 'green'
}

function OfficeSpace() {
  return (
    <div>
      <h1>office space rentals</h1>
      <img src="/office-space.svg" alt="office space" width="300" height="180" />

      <h2>{office.name}</h2>
      <p style={{ color: rentColor(office.rent) }}>rent: {office.rent}</p>
      <p>address: {office.address}</p>

      <h2>all listings</h2>
      <ul>
        {officeList.map((item) => (
          <li key={item.name}>
            {item.name} - <span style={{ color: rentColor(item.rent) }}>rs {item.rent}</span> - {item.address}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default OfficeSpace
