import Trainer from './trainer'

// mock data, handout wants this as its own file so the components stay dumb
const trainersData = [
  new Trainer(1, 'sunita rao', 'sunita.rao@cognizant.com', '9876543210', 'java fse', ['spring boot', 'hibernate', 'react']),
  new Trainer(2, 'arjun nair', 'arjun.nair@cognizant.com', '9876500011', 'python fse', ['django', 'flask', 'react']),
  new Trainer(3, 'megha iyer', 'megha.iyer@cognizant.com', '9876511122', 'devops', ['docker', 'kubernetes', 'jenkins']),
]

export default trainersData
