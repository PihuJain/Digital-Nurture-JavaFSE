day 3 - dsa
june 19

just the one mandatory, the e-commerce search

compared linear vs binary on a product list. linear walks the array from the front checking
each, no sorting needed, but its O(n) so a massive catalog = loads of checks. binary needs it
sorted first then keeps halving, O(log n), so a million items is abt 20 comparisons not a
million. used linear for name lookups, binary for ids since the ids were easy to keep sorted

the midpoint bit got me tho. wrote (left + right) / 2 like youd naturally do, but if both are
near the int max that sum overflows & goes negative. left + (right - left) / 2 is the same
number w/out overflowing. basically never happens w/ 5 products but the exercise made a point
of it

also lost a few mins confused bc binary search on an unsorted array doesnt error, just quietly
hands back the wrong thing or null. id forgotten to sort first. classic
