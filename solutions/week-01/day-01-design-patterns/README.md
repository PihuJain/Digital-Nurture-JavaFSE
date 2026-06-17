day 1 - design patterns
june 17

two mandatory (singleton, factory method) + builder as the optional

singleton (singleton-pattern-example)
the logger one. whole app shares one Logger so the output isnt scattered across loads of
instances. private constructor does the actual work, once new Logger() is locked the only
way in is getInstance()
got it going w/out synchronized first and it seemed fine, then remembered the exercise
mentions threads. two can hit the null check at teh same time and both make their own
Logger. synchronized on the method stops that, one gets in at a time

factory method (factory-method-pattern-example)
docs, word pdf excel. point is Main never says new WordDocument() anywhere, it just holds a
DocumentFactory & asks for a Document. new type later -> new factory class, nothing in Main
moves. went w/ an interface for Document not abstract class since the 3 types share no code,
only the method names they all have to have

builder (builder-pattern-example, optional)
Computer w/ a load of optional parts. doing that w/ constructors is horrible, you end up
counting which of 7 args is which. builder lets you set just what you want & chain it.
the thing that got me - every setter has to return this or the chaining doesnt compile.
forgot it on the first one & sat there confused a bit

so all 3 are about making objects but for diff reasons. singleton = how many, factory =
which type, builder = how its put together
