day 11 - lombok + automation testing overview
june 27

optional day really. lombok practice + the automation testing stuff was just reading and
awareness so nothing to commit for that part

lombok (Employee, PayrollService)
lombok generates all the boilerplate at compile time off the annotations. @Getter @Builder
@ToString on Employee means i wrote zero getters and no builder by hand, but still get the
chained Employee.builder().name(..).build(). bit funny seeing it after writing the whole
builder out by hand for the Computer class on day 1 - lombok is that exact thing in three
annotations. @Slf4j on PayrollService hands me a log field for free, same slf4j logger as
day 10 just generated

the gotcha - lombok has to be wired up as an annotation processor in the compiler plugin,
otherwise none of the generated methods exist and the whole thing wont compile. added
annotationProcessorPaths in the pom for it. took me a min to work out why getName() was
"not found" before that

tested the generated builder + getters work and PayrollService runs fine.
