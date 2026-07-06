day 20 - spring rest advanced
july 6

all optional, two files worth of hands on. file 3 wants a static employee/department
list served over rest, file 4 wants post + validation + a global handler + update and
delete for employee. did both since together they cover everything id need for a real
crud service, just not backed by an actual database this time

employee.xml has two departments and four employees, each employee <property
name="department" ref="..."/> pointing at one of them. EmployeeDao and DepartmentDao
each open their own ClassPathXmlApplicationContext("employee.xml") in the constructor,
same pattern as CountryService from yesterday, load the xml once and reuse the list

/employees (GET) and /departments (GET) are straightforward, just return whatever the
dao read off the xml

the validation part touched Country and added a whole new Employee model with its own
constraints - id not null, name not blank 1-30 chars, salary not null and >= 0, permanent
not null. wrote permanent as Boolean not boolean on purpose, a primitive can never be
null so @NotNull on one does literally nothing, needed the wrapper type for the check
to mean anything at all. same story for id and salary being Integer/Double instead of
int/double

GlobalExceptionHandler extends ResponseEntityExceptionHandler with @ControllerAdvice,
overrides handleMethodArgumentNotValid to build a timestamp+status+errors map instead of
springs default error page. this is what makes @Valid actually produce a clean json
error response for every controller instead of just whichever one has its own try/catch

update and delete for employee both go through EmployeeNotFoundException the same way
CountryNotFoundException worked yesterday, @ResponseStatus straight on the exception
class does the 404 conversion automatically

one thing that bit me while writing the tests - the employee list lives in memory, its
not a real database that resets itself, so once a test actually deletes employee 4 that
change sticks around for whatever test runs after it. junit doesnt guarantee method order
by default so this could pass or fail depending on the day. added @DirtiesContext on the
delete test so spring throws the whole context away and rebuilds it (re-reading
employee.xml fresh) right after, fixed the flakiness for good
