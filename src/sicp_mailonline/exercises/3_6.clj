;; Exercise 3.6
;; It is useful to be able to reset a random-number generator to produce a
;; sequence starting from a given value.  Design a new rand procedure that is
;; called with an argument that is either the symbol generate or the symbol
;; reset and behaves as follows: (rand 'generate) produces a new random number;
;; ((rand 'reset) <new-value>)) resets the internal state variable to the
;; designated <new-value>.  Thus, by resetting the state, one can generate
;; repeatable sequences.  These are very handy to have when testing and
;; debugging programs that use random numbers.

(ns sicp-mailonline.exercises.3-6)

;; from Knuth http://www.eng.auburn.edu/csse/classes/comp8700/lessons/Random_Numbers.pdf
(defn- rand-update [x]
  (mod (* x 16807)
       2147483645))

(def rand
  (let [x (atom (System/currentTimeMillis))]
    (fn [cmd]
      (cond (= cmd :generate) (swap! x rand-update)
            (= cmd :reset) (fn [new-value] (reset! x new-value))
            :else (throw (IllegalArgumentException.
                          (str "Unknown request -- RAND " cmd)))))))
