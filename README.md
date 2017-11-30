# processing
## QUESTION 1: Running time of program
Let N represent the number of words in the dictionary, and W be the length of the longest word.
<br>
N is bounded by 10k, and W is bounded by 100 for this problem.
<br>
Offline:
<br>
- read in all words from text file => O(N)
- process dictionary into hashmap
  - O(N) => iterate through all the words in the dictionary
  - O(NWlog(W)) => sort all the words to create HashMap with appropriate anagram key
  - O(Nlog(N)) => putting the list of original words into a TreeSet for the HashMap's value
- total runtime: ~ O(NlogN) because we know # of characters ias at most 100.
<br>
Online:
<br>
 - O(log(W)) => Creating the anagram key for each input <br>
 - O(1) => accessing the HashMap's TreeSet for this anagram key <br>
 - O(N) => iterating through all of the words in the TreeSet to create StringBuilder output, to print for user <br>

## QUESTION 2: Memory Complexity
Dictionary takes O(N) space, because worst case there are N distinct anagramKeys, each with a TreeSet of 1 word. 
<br> Contents of all the TreeSets will always add up to be N, total number of words.
<br>
Original array I used to process values takes O(N) space. 
<br>
Total: O(N) space.

## ADDITIONAL NOTE:
If I had more time, I realized that I could create the dictionary **as I read in the words**, so to save a little bit of time during the offline/preprocessing phase. Right now I process/create my HashMap dictionary representation only **after** I finished reading in all the words, but it's possible to construct the HashMap **as** I read in all the words, so I don't have to iterate through the array one more time after it finishes reading in the file. And also, I don't think I'd even need the array at all, since I could just directly use the read-in word through BufferedReader to modify my HashMap. I would have to think a little more though about how to finetune this method!
