day 23 - spring cloud + eureka
july 9

mandatory today, creating microservices for account and loan, three separate maven
projects sitting side by side: eureka-server, account, loan

account and loan are both dead simple, one controller each, no database, just a
hardcoded response. /accounts/{number} always answers with the same dummy savings
account, /loans/{number} the same dummy car loan, number just gets echoed back from
the path variable. handout is explicit these have no backend connectivity yet, the
point of today is proving service discovery works not building real data access

eureka-server is the interesting one. @EnableEurekaServer and thats basically it for
code, all the actual behaviour comes from application.properties -
eureka.client.register-with-eureka=false and eureka.client.fetch-registry=false, both
have to be off or the server tries to register itself as its own client and the
startup log fills with retry errors. without those two lines this doesnt even count
as a discovery server, its just another eureka client pointed at nothing

account and loan each pull in spring-cloud-starter-netflix-eureka-client and thats
enough, no @EnableDiscoveryClient needed, spring boot autoconfigures registration the
moment it sees the dependency on the classpath. spring.application.name is the bit
that actually matters, thats the name that shows up in the eureka dashboard and the
name anything else would look this service up by later

handout pins spring-cloud-version to 2020.0.4 which is a boot 2.x release train, this
repo is on boot 3.2.5 so that version just doesnt resolve right, eureka server never
starts. moved to 2023.0.1 instead, thats the train that actually lines up with boot
3.2. same story as day 21s jjwt version, the handout material predates the stack this
repo already committed to

ports: eureka on 8761 (its usual default), account on 8081, loan on 8082. handout has
account start on the spring default 8080 then loan collides with it and has to move to
8081 - since all three run together here gave loan its own port straight away instead
of hitting that collision on purpose

ran all three together for real to check this actually works, not just mvn test.
started eureka-server, waited for it to come up, then account and loan, then hit
localhost:8761/eureka/apps directly - both ACCOUNT-SERVICE and LOAN-SERVICE showed up
status UP. curled /accounts and /loans directly too, dummy data came back exactly as
expected on both
