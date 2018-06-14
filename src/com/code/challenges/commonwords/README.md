Our client is partnering with the linguistics department at a local university to analyze important works of English literature and identify patterns in word usage across different eras. To ensure a cleaner output, the linguistics department has provided a list of commonly used words (e.g., "an", "the", etc.) to exclude from the analysis. In the context of this search, a word is an alphabetic sequence of characters having no whitespace or punctuation.

Write an algorithm to find the most frequently used word in the text excluding the commonly used words.

Input
----
The input to the function/method consists of two arguments

 - `literatureText`, a string representing the block of text;
 - `wordsToExclude`, a list of strings representing the commonly used words to be excluded while analyzing the word frequency.
 
Output
-----
Return a list of strings representing the most frequently used words in the text or in case of a tie, all of the most frequently used words in the text.


Note
-----
Words that have a different case are counted as different words.
The order of words does not matter in the output list.
There is no punctuation in the text and the only white space is the space character.
All words in the `wordsToExclude` list are unique.


Example
-----
    Input: 
        literatureText = “jack and jill went to the market to buy bread and cheese cheese is jack favorite food”
        wordsToExclude = ["and", "he", "the", "to", "is"]

    Output: ["jack", "cheese"]

Explanation: The words “jack”, “and”, "to" and "cheese” have the maximum frequency in the given text but the words “and” and “to” should be excluded as these are common words that you are not interested to include.

So the output is ["jack", "cheese"] as the order of words do not matter.


