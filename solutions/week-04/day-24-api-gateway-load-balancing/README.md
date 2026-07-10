day 24 - api gateway + load balancing
july 10

both optional today, api gateway and a load balancing exercise. carried eureka-server
and account forward from day 23 instead of duplicating, loan didnt get touched today so
left it back in day 23s folder

api-gateway is a new project on its own, spring-cloud-starter-gateway which is built on
webflux, cant sit next to spring-boot-starter-web in the same app at all. the whole
point of discovery.locator.enabled=true is skipping having to hand write a route per
service, gateway just reads whatever eureka has registered and builds the routing
table itself. hitting localhost:9090/account-service/accounts/1 works with zero route
config in application.properties because of that one property

LogFilter implements GlobalFilter, runs on every request through the gateway not just
one route, just logs the uri and calls chain.filter() to pass it on, doesnt block or
change anything

the load balancing bit needed something to actually balance between, so ran two copies
of the account service, one on the default port 8081 and a second started with
--server.port=8083, both registering as ACCOUNT-SERVICE in eureka. added a servedBy
field to the Account response just for today (account-service:8081 or :8083) so you can
actually tell which instance answered instead of every response looking identical

wired in a custom RandomLoadBalancer too, following the handouts solution code -
AccountLoadBalancerConfig has the @Bean but deliberately isnt annotated
@Configuration itself, spring cloud loadbalancer builds an isolated child context per
named client and if this class were also picked up by the main apps component scan it
would double register. a second small class, GatewayLoadBalancerConfig, actually is
@Configuration and just wires the two together with
@LoadBalancerClient(name="account-service", configuration=AccountLoadBalancerConfig.class).
the name has to be lowercase to match the route since lower-case-service-id is on

ran the whole thing live, not just mvn test - eureka-server, both account instances,
then the gateway, then curled the gateway eight times in a row and printed servedBy
each time. alternated cleanly between :8081 and :8083 on every single call, checked
the gateway console too and LogFilter had logged every one of those eight requests
