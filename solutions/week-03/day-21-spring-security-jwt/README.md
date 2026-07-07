day 21 - spring security + jwt
july 7

week 4 starts here, and this was a bigger one - mandatory was the whole jwt flow, secure
endpoints, in memory users, authenticate controller, decode header, generate token,
validate token on every request

first problem before writing a single line of jwt code: the handout has SecurityConfig
extend WebSecurityConfigurerAdapter with two overridden configure() methods. that class
doesnt exist anymore, spring security 6 dropped it entirely a while back. spent a bit
figuring out the replacement is just a handful of @Bean methods - PasswordEncoder,
UserDetailsService, AuthenticationManager, and a SecurityFilterChain that does what the
old configure(HttpSecurity) override used to do

admin and user are both in memory still, pwd for both, roles ADMIN and USER, exactly
like the handout said - real credentials come later once spring data jpa is wired into
this properly

second problem: jjwt. handout is on 0.9.0, Jwts.parser().setSigningKey("secretkey") -
none of that compiles against anything past jjwt 0.10 or so, the whole builder api
changed and split into jjwt-api/jjwt-impl/jjwt-jackson (impl and jackson only needed
at runtime, not compile time). used 0.11.5 since it still has setSubject/setExpiration
style methods, 0.12 renames those again to subject()/expiration()

also "secretkey" as the signing key literally throws WeakKeyException on jjwt 0.11 -
hs256 wants at least 256 bits and that string is nowhere close. padded it out to a
real 32+ char string instead

pulled the key + generate/parse logic into one JwtUtil class rather than pasting the
same secret into both AuthenticationController and the filter - if those two ever drifted
out of sync thered be no way to explain why some tokens just stopped validating

AuthenticationController.authenticate() reads the Authorization header off the request
directly via @RequestHeader, decodes it (its just Basic dXNlcjpwd2Q= under the hood),
pulls the username out before the colon, then JwtUtil.generateToken() signs a token with
a 20 minute expiry same as the handout

JwtAuthorizationFilter extends BasicAuthenticationFilter same as the handout wanted -
this one matters because SecurityFilterChain.addFilter() only accepts subclasses of
springs own known filter types for chain ordering, cant just addFilter() any random
Filter. checks for the Bearer prefix, and if the token parses clean sets the
SecurityContext authentication so downstream authorization checks pass

final SecurityFilterChain: /authenticate open to both roles, everything else needs to
be authenticated one way or another (basic or bearer), filter slotted in with addFilter

this also meant every existing mockmvc test from days 18-20 broke the moment security
went in, since .anyRequest().authenticated() locks down /country, /countries, /employees,
all of it. added httpBasic("user", "pwd") to each of those calls rather than rewrite the
tests from scratch, they were still testing the right thing, just needed credentials now.
new JwtAuthenticationTest covers the actual round trip - call /authenticate for a real
token, then use that same token as a bearer against /countries and /employees, plus the
401 cases for no creds, wrong password and a garbage token

tried the whole flow for real too outside the tests, curl -u user:pwd .../authenticate
for a token, then that token as a bearer against /countries, got the country list back.
garbage token and no token both came back 401 like they should
