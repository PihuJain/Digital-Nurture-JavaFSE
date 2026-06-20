day 4 - dsa cont.
june 20

mandatory was financial forecasting, did the sorting one as the optional too

forecasting (financial-forecasting)
works out what an investment is worth after n years at a fixed growth rate. did it recursively,
each call grows the amount one year then calls itself w/ years-1, stops at 0. basically
compound interest split one step per call. O(n) time & O(n) space (every year is another stack
frame). fine for normal year counts, a loop wouldve done it in O(1) space if n got silly

sorting (sorting-customer-orders, optional)
sort orders by price so the pricey ones get done first. did bubble & quick. bubble just keeps
swapping neighbours till a clean pass, dead easy, O(n^2), slow. quick picks a pivot & throws
smaller one side bigger the other then recurses, O(n log n) avg

the partition step in quick took me ages honestly. kept losing track of what i & j were each
doing. turns out i is the edge of the smaller-than-pivot chunk & j just scans. drew it on
paper, then it clicked. nearly forgot teh final swap that drops the pivot in too

quick wins for anything real, the gap between n log n & n^2 shows up fast once theres more
than a handful
