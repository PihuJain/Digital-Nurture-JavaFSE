day 18 - spring rest basics
july 4

start of module 7, new project this time (spring-learn, separate from orm-learn).
mandatory was HO1 (create the maven web project) and HO4 (load country from spring xml),
did the rest of the optionals too since they all build on the same country.xml file

the mandatory bit is basically day 12/13 again but with spring-web on the classpath
instead of spring-context, no rest controllers yet though, thats tomorrow

Country here is a plain pojo, not the jpa entity from orm-learn, this one gets built
straight off property tags in country.xml
    <bean id="country" class="com.cognizant.springlearn.model.Country">
        <property name="code" value="IN" />
        <property name="name" value="India" />
    </bean>
put debug logs in the constructor and every getter/setter like the handout wanted, so
you can watch exactly when spring is building vs reusing the object

did the singleton vs prototype demo (HO5) by putting both scopes in the same xml file
instead of two separate files - "country" is default scope, "countryPrototype" has
scope="prototype" added. got the same country bean twice from each and compared with ==.
singleton: true, same reference both times. prototype: false, brand new object each
call. constructor log line count in the console confirms it too, one line for singleton
even after two getBean calls, two lines for prototype

date-format.xml (HO2) is the smaller one - one SimpleDateFormat bean with the dd/MM/yyyy
pattern so it only needs defining once instead of every class doing `new
SimpleDateFormat(...)` separately

HO6 (list of countries) needed four separate country beans plus an ArrayList bean that
just <ref>s each one. spring builds the list and injects it as one unit, iterating it in
displayCountries() gave back all four in the order they were listed
