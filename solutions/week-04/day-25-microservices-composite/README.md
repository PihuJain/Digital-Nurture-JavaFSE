day 25 - microservices composite
july 11

mandatory, "complete composite microservices hands-on". the source docx for this turned
out to just be everything from days 22-24 bundled into one file, theory recap plus the
exact same account/loan/eureka/gateway steps, not new material. so the real composite
work here is putting all four pieces together and proving the whole picture actually
works as one system, not four separate demos

four projects side by side: eureka-server, account, loan, api-gateway. eureka-server and
api-gateway carried straight over from day 24 untouched. account also carried over from
day 24 (still has the servedBy field from the load balancing exercise, harmless to leave
in even without a second instance running today). loan came from day 23 since it never
got touched on day 24

the point today wasnt writing new code, it was proving account-service and loan-service
both sit behind the SAME gateway at the same time. discovery.locator.enabled means the
gateway didnt need any route changes to pick up loan-service, it was already reading
straight off whatever eureka has registered

ran genuinely all four together this time instead of two or three - started eureka-
server, waited for it, started account and loan together, waited, started api-gateway
last. checked localhost:8761/eureka/apps and saw all three real services (api-gateway
counts too since it registers itself) showing status UP at once. then hit
localhost:9090/account-service/accounts/42 and localhost:9090/loan-service/loans/H999
through the gateway, both came back correct. checked the gateway console after and
LogFilter had logged both requests, proving the one global filter covers every route
through it, not just whichever service you built it while testing

killed all four processes after and double checked every port (8761, 8081, 8082, 9090)
was actually free again, not just "looked closed" - the maven wrapper process and the
actual java process it spawns are two different pids and pkill by name alone missed the
java one the first time, had to grep the real pids and kill those directly
