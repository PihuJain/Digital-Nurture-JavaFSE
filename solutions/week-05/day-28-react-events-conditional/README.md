day 28 - "events + conditional rendering" (files dont actually match this)
july 14

so this one doesnt line up with its own label. schedule says today is event
handlers and conditional rendering, files 4 and 5. opened both docx and
neither is that at all - file 4 is lifecycle hooks (componentDidMount,
componentDidCatch) and file 5 is css module / inline styling. not the first
time a docx and its schedule label disagree, day 25 had the same thing with
bundled material. built what the files actually ask for instead of forcing
fake content to match "events + conditional rendering"

blogapp (file 4): Post.js is just a plain data class, id/title/body, nothing
react about it. Posts.jsx is the actual component, class based, constructor
sets up posts: [] in state, loadPosts() fetches from
jsonplaceholder.typicode.com/posts and setStates the result, componentDidMount
calls loadPosts so it fires once on mount, componentDidCatch catches render
errors and alerts. sliced the fetched list down to 10 posts for the render,
jsonplaceholder returns 100 and nobody needs to scroll through all of them
for a demo

cohortapp (file 5): handout says download and style an existing cohort
dashboard app but no attachment came with it, so built a small stand in
version just to have something real to hang the css module styling on.
CohortDetails.module.css has the box class exactly as specced - 300px wide,
inline-block, 10px margin all around, 10px top/bottom and 20px left/right
padding, 1px black border, 10px radius - plus the dt tag selector at
font-weight 500. h3 goes green for status "ongoing" and blue for anything
else via inline style since thats simpler than a second css class for two
colors

verified: both build clean with npm run build. blogapp also got its preview
server curled to confirm index.html serves, and separately confirmed
jsonplaceholder.typicode.com/posts itself returns 200 so the fetch call has
something real to hit. cohortapp - grepped the built css for the hashed box
classname to make sure the css module actually scoped and didnt just get
dropped by the build
