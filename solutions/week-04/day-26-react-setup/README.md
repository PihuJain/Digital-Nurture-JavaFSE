day 26 - react setup + core concepts
july 12

first non-java day in the whole schedule. module 9 starts here, mandatory was the one
hands-on in file 1, create myfirstreact and print a heading

handout wants create-react-app, tried it first before assuming anything and it just
doesnt work anymore. react.dev itself flags create-react-app as deprecated now and
points to other tooling, and on top of that it flat out failed to scaffold on this
machine, something about npm not starting in the right directory. not going to fight
a dead tool, used vite instead which is what react.dev actually recommends these days.
same end result, a working react dev environment, just a different (and much faster)
way of getting there

npm create vite@latest myfirstreact -- --template react scaffolds the whole thing in
about two seconds, no eslint config wizard, no "which template" back and forth like
CRA used to have

vite names the entry file App.jsx not App.js since it defaults to the jsx extension,
kept that instead of forcing it back to .js, no real difference either way just a
naming convention

stripped out most of what vite scaffolds by default though, the demo hero image, the
react/vite logos, the counter button, all the "explore vite" links, none of that was
asked for and it wouldve just been dead weight sitting in a first hello world exercise.
App.jsx is now literally just one h1 tag with the heading text the handout wanted

also set server.port to 3000 in vite.config.js since the handout has you check
localhost:3000, vite defaults to 5173 otherwise

verified with npm run build then grepped the compiled bundle for the exact heading
string to confirm it survived the build, then served the built output with npm run
preview and curled it to check both index.html and the js bundle load with a 200.
no headless browser on this machine to grab an actual screenshot without pulling in
a much heavier dependency for a one line static heading, but between the clean build,
the bundle containing the right text, and this being a component with zero dynamic
logic to go wrong, thats about as sure as it gets without one
