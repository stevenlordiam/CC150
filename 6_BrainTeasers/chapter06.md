## Chapter 06 Brain Teaser

###  
___________________

### 6.1 You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has pills of weight T.I grams. Given a scale that provides an exact measurement, how would you find the heavy bottle? You can only use the scale once.
* Take one pill from Bottle #1, two pills from Bottle #2, three pills from Bottle #3, and so on. Weigh this mix of pills. If all pills were one grameach,thescalewouldread210grams(1 + 2+...+20 = 20* 21/2 = 210). Any "overage"must come from the extra 0.1 gram pills. This formula will tell you the bottle number: (weight - 210 grams) / 0.1 grams. So, if the set of pills weighed 211.3 grams,then Bottle #13 would have the heavy pills.

### 6.2 There is an 8x8 chess board in which two diagonally opposite corners have been cut off. Youare given 31 dominos, and a single domino can cover exactly two squares. Can you use the 31 dominos to cover the entire board? Prove your answer (by providing an example or showing why it's impossible).

* As long as the two jug sizes are relatively prime (i.e., have no common prime factors), you can find a pour sequencefor any value between one and the sum of the jug sizes(3 to 8)
* Our goal is to create a system for dropping Egg1 such that the number of drops is as consistent as possible, whether Egg 1 breaks on the first drop or the last drop.
5. Solvefor Xin:X + (X-l) + (X-2) + ... + 1 = 160.X (X + 1) / 2 = 100 -> X = 14. We go to floor 14, then 27, then 39, ....This takes 14 steps in the worse case. As in many other maximizing / minimizing problems, the key in this problem is "worst case balancing."


### 6.6 There are 100 closed lockers in a hallway. A man begins by opening all 100 lockers. Next, he closes every second locker. Then, on his third pass, he toggles every third locker (closes it if it is open or opens it if it is closed). This process continues for / 00 passes, such that on each pass i, the man toggles every ith locker. After his 100th pass in the hallway, in which he toggles only locker #100,how many lockers are open?