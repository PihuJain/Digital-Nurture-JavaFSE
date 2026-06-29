day 13 - spring core cont. (DI)
june 29

carries on from day 12. mandatory was implementing DI (ex 2), did the IoC container and the
constructor+setter injection ones (ex 5, ex 7) as the optional - they all kind of fold into
the same thing so did them together

day 12 the service and repository were just sitting there as separate beans. today spring
actually wires the repository into the service so the service never news up its own dependency.
thats the whole DI point, you declare what you need and the container hands it to you

did both styles in the one bean to see the difference:
- constructor injection - libraryName goes in through the constructor, <constructor-arg> in the
  xml. good for stuff thats required and shouldnt change, so i made it final
- setter injection - the repository goes in through setRepository, <property ... ref> in the
  xml. spring calls the setter after building the object

findBook delegates straight to the injected repository, so the test passing (findBook returns
the right title) is proof the setter injection actually happened, and the library name coming
through proves the constructor one did

the IoC container bit (ex 5) is really just the ApplicationContext itself - thats the container
holding and wiring all this. nothing extra to write for it


also did ex 9 (creating a spring boot application) as an extra - its in spring-boot-library/
spent the whole of days 12-13 wiring beans by hand in xml, then ex9 is one @SpringBootApplication
annotation and boot auto-configures the lot, web server, datasource, jpa. felt almost silly
after the xml. made a Book entity + repository + a BookController with the crud endpoints, h2
in memory. MockMvc test posts a book then gets it back.

