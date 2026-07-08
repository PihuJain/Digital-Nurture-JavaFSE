day 22 - microservices foundations
july 8

week 4 module 8 starts here. no mandatory hands-on today, schedule just says read through
the two exercise files and understand the structure, so thats what this is, notes not code

file 0 (sample microservices exercises) is centralized auth for a microservices setup,
oauth2/oidc login, a resource server validating jwts issued elsewhere, and a plain jwt
filter doing basically what i built by hand on day 21 but through spring securitys built
in oauth2 support instead of a custom BasicAuthenticationFilter subclass. the connection
clicked pretty fast, day 21s JwtAuthorizationFilter and this jwt exercises JwtTokenFilter
are doing the same job, read the bearer token, validate it, set the SecurityContext. the
difference is oauth2/oidc moves the actual login+token-issuing bit out to a separate
identity provider (google in the sample config) instead of my own /authenticate endpoint
handing out tokens itself. also noticed this file still uses WebSecurityConfigurerAdapter,
same dead class from the jwt handout yesterday, so thats consistent at least

file 1 (microservices with spring boot 3) is four separate problem statements, no solution
code this time, just requirements:
1. user service + order service talking through WebClient or OpenFeign, backed by a real
   db (mysql/postgres). this is basically two of my spring-learn style rest projects
   except they call each other instead of just answering a browser
2. product + inventory services registered with eureka for service discovery, config
   pulled centrally from a config server instead of each services own application.properties
3. an api gateway in front of customer + billing services, spring cloud gateway doing
   routing, rate limiting and caching
4. a payment service calling a slow third party api, wrapped in a circuit breaker
   (resilience4j) so one flaky dependency doesnt take the whole thing down

none of these have solution code in the pdf, theyre meant to be built from scratch later
in the module (day 23 mandatory is literally exercise 2 - account/loan microservices with
eureka, day 25 is the composite hands-on). today was just getting the shape of it before
actually standing up multiple services and wiring them together
