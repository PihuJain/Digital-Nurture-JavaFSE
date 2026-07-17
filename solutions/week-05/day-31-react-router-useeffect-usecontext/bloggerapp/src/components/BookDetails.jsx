// technique 1: plain if-else, returning early instead of one big ternary
function BookDetails({ book }) {
  if (!book) {
    return <p>no book selected</p>
  }

  return (
    <div>
      <h3>{book.title}</h3>
      <p>by {book.author}</p>
    </div>
  )
}

export default BookDetails
