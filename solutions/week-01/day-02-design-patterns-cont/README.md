day 2 - design patterns cont.
june 18

3 optional ones today, all from the same patterns doc. adapter observer strategy

adapter
two payment gateways, paypal calls it makePayment & stripe calls it executeCharge, our code
shouldnt have to care which. so PaymentProcessor interface w/ processPayment & a little
adapter per gateway that just forwards to whatever that gateway named it. thats genuinely all
it does. kept expecting more but no, just a translation layer

observer
stock price feed. StockMarket holds a list of observers & when the price moves it loops &
calls update on each. no clue if its a mobile app or a web app, doesnt care. registered two,
deregistered one halfway, third update only printed for the one still in the list so i knew
remove actually worked

strategy
checkout, pick a payment method & be able to switch mid run. PaymentContext holds whatevers
active, setStrategy swaps it. looks a lot like adapter on paper but the intent is diff ->
adapter makes smth fit, strategy picks between things that already fit

mostly today was about where these sit. adapter structural, observer & strategy behavioural.
the category kinda tells you what the pattern is for before you even read it
