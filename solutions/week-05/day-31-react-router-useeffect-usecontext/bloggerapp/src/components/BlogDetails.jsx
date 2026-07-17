// technique 2: ternary right inside the jsx
function BlogDetails({ blog }) {
  return (
    <div>
      {blog ? (
        <>
          <h3>{blog.title}</h3>
          <p>{blog.summary}</p>
        </>
      ) : (
        <p>no blog post found</p>
      )}
    </div>
  )
}

export default BlogDetails
