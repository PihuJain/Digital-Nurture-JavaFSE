day 16 - spring data jpa advanced
july 2

optional day, three things: o/r mapping, hql, native query. handout goes further with
employee/department/skill and a many to many on top but that felt like a lot for one
optional day so kept it to employee and department only, many to one and one to many

Employee -> Department is @ManyToOne with a department_id join column. by default jpa
makes ManyToOne eager, so pulling an employee back out also gets you the department in
the same query, didnt have to configure anything extra for that
Department -> Employee is the other side, @OneToMany(mappedBy = "department") - the
mappedBy just says "the foreign key lives on the other entity, im not the owner here"

almost shot myself in the foot with toString on both classes printing the other one.
department.toString calling employee.toString calling department.toString... caught it
before running, left a comment on Employee explaining why department is left out of it

hql and native query both live as @Query methods on EmployeeRepository
- getAllPermanentEmployees uses hql: "select e from Employee e where e.permanent = true" -
  reads like sql but e is the java class not the table, and .permanent is the field
- getAllEmployeesNative is nativeQuery=true with actual "select * from employee" -
  straight sql, no hql translation involved

test file has one for each: department comes back with the employee, hql query only
returns the permanent one out of two, native query pulls back everyone regardless of
their permanent flag
