;; Exercise 2.72
;; Consider the encoding procedure that you designed in exercise 2.68.  What is
;; the order of growth in the number of steps needed to encode a symbol?  Be
;; sure to include the number of steps needed to search the symbol list at each
;; node encountered.  To answer this question in general is difficult.
;; Consider the special case where the relative frequencies of the n symbols
;; are as described in exercise 2.71, and give the order of growth (as a
;; function of n) of the number of steps needed to encode the most frequent and
;; least frequent symbols in the alphabet.

;; In the worst case, as demonstrated by the least frequent symbol of example
;; 2.71, we descend n levels.  At each level, we potentially search
;; the entire set of symbols, as the implementation of encode uses an unordered
;; set.  We therefore have O(n^2) steps.

;; In the best case, as demonstrated by the most frequent symbol of example
;; 2.71, the symbol will always be at the first level, as a direct child of the
;; root.  We will however have to search the entire set, because having the
;; highest weight implies that it will be at the end.  We therefore have O(n)
;; steps.
