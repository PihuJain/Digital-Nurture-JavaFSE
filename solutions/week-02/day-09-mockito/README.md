day 9 - mockito
june 25

mocking + stubbing and verifying interactions were the mandatory ones, argument matching and
void methods as the optional

the setup is a MyService that depends on an ExternalApi. point of mockito is you dont want
your unit test actually calling the real api (network, db, whatever), so you hand the service
a fake one and tell it how to behave

mocking + stubbing - mock(ExternalApi.class) gives you a fake, then when(api.getData())
.thenReturn("mock data") stubs it so it returns what you want. then you assert the service
passed that through

verifying - verify(api).getData() checks the service actually called the api. didnt stub
anything for that one, just confirming the interaction happened

argument matching - verify(api).saveData(eq("report.txt")) checks it was called with that
exact arg. eq for the exact value, anyString() if you dont care which string

void methods - this tripped me up for a sec. you cant write when(api.saveData(..)).thenReturn
because void returns nothing. the syntax flips to doNothing().when(api).saveData(..) or
doThrow(...).when(api)... took me a min to remember which way round it goes

