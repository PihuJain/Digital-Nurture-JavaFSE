day 12 - spring core + maven
june 28

both mandatory today - set up the LibraryManagement maven project with spring core (ex 4) and
get a basic spring app wired up (ex 1)

first spring one. the whole idea is spring manages your objects (beans) for you instead of you
newing everything up yourself. you describe the beans in applicationContext.xml and just ask
the container for them when you need one

made BookRepository (com.library.repository) and BookService (com.library.service), each
declared as a bean in the xml. the main class loads it all with ClassPathXmlApplicationContext
and then context.getBean(BookService.class) hands you back the instance spring built

theyre two separate beans for now, not wired into each other yet - thats day 13, the DI part.
so right now the service doesnt actually use the repository, this is just proving the container
spins up and both beans come out

ex 4 was basically just the pom - spring-context, which drags in core/beans/aop/expression
with it. side note the exercise pdf says java 1.8 but spring 6 wont run below 17 so used 17

test loads the context and checks both beans are there.
