import BookDetails from './components/BookDetails'
import BlogDetails from './components/BlogDetails'
import CourseDetails from './components/CourseDetails'

const book = { title: 'atomic habits', author: 'james clear' }
const blog = null
const course = { name: 'react fundamentals', duration: '6 weeks', enrolled: true }

function App() {
  return (
    <div>
      <BookDetails book={book} />
      <BlogDetails blog={blog} />
      <CourseDetails course={course} />
    </div>
  )
}

export default App
