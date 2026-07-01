day 15 - spring data jpa cont.
july 1

all optional today, carries on straight from day 14's orm-learn project. copied it over
and added the actual crud service instead of just poking at the repository directly

CountryService now has findCountryByCode, addCountry, updateCountry, deleteCountry. the
find one throws a CountryNotFoundException if findById comes back empty - had to remind
myself Optional isnt the country, you check isPresent() first then get() actually pulls
it out. felt roundabout the first time, makes sense now

the bit i actually spent time on was the derived query. readme for the module mentioned
"query methods" so wanted to try one properly instead of always going through findById.
ended up with findByNameContainingIgnoreCaseOrderByNameAsc on the repository - just a
method signature, no body, spring data reads the name and builds the sql itself. tested
searching "ind" and getting india + indonesia back sorted, that part still feels like magic
even after writing the singleton and factory stuff by hand earlier weeks

update just reuses save() since jpa figures out insert vs update from whether the id
already exists in the table, didnt need a separate path for that. wrote tests for all
four service methods plus the derived query, kept them in a new CountryServiceTest
next to the repository one from day 14
