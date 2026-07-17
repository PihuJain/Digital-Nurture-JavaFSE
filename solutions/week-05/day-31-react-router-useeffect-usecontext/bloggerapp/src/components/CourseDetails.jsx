// technique 3: element variable built first, then && to decide whether a
// second bit (the enrolled badge) shows up at all
function CourseDetails({ course }) {
  let content

  if (course) {
    content = (
      <div>
        <h3>{course.name}</h3>
        <p>duration: {course.duration}</p>
      </div>
    )
  } else {
    content = <p>no course found</p>
  }

  return (
    <div>
      {content}
      {course && course.enrolled && <p>you are enrolled in this course</p>}
    </div>
  )
}

export default CourseDetails
