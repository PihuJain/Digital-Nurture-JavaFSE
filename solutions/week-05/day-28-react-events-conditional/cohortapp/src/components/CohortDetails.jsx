import styles from './CohortDetails.module.css'

// handout wanted us to download and style an existing cohort dashboard app,
// no attachment was actually given here so built a small standalone version
// of it just to have something real to apply the css module styling to
function CohortDetails({ cohort }) {
  const statusColor = cohort.status === 'ongoing' ? 'green' : 'blue'

  return (
    <div className={styles.box}>
      <h3 style={{ color: statusColor }}>{cohort.name}</h3>
      <dl>
        <dt>status</dt>
        <dd>{cohort.status}</dd>
        <dt>trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  )
}

export default CohortDetails
