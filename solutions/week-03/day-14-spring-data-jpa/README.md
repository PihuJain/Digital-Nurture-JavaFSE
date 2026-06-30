day 14 - spring data jpa + hibernate
june 30

start of week 3. both mandatory - a quick spring data jpa example, plus the jpa vs hibernate
vs spring data jpa difference (more of a concept thing so its mostly written up here)

the difference (the bit i kept getting muddled)
- JPA is just a spec, basically an interface. it defines the annotations (@Entity, @Id) and
  what an entity manager is meant to do, but theres no actual code behind it
- Hibernate is an implementation of that spec. its the ORM that does the real work, turning
  objects into rows and back and generating the sql
- Spring Data JPA sits on top of hibernate and takes away the boilerplate. you dont write a
  query or an entity manager call, you just declare a repository interface and it generates
  the implementation for you
so the stack is spring data jpa -> hibernate -> jpa spec, each layer hiding the one under it

the quick example (orm-learn)
spring boot this time, way less wiring than the plain spring of day 12/13. Country entity
mapped to a country table with @Entity/@Id/@Column. CountryRepository just extends
JpaRepository<Country, String> and thats literally it - save, findById, findAll, deleteById
all there without me writing any of them. that still feels like cheating a bit

handout wanted mysql but i went h2 in-memory so the test runs without setting up a db server.
ddl-auto=create-drop has hibernate build the table off the entity at startup and drop it after

@DataJpaTest spins up only the jpa layer against h2, saved a country and pulled it back by id.
