;; Exercise 2.55
;; Eva Lu Ator types to the interpreter the expression
;;
;; (car ''abracadabra)
;;
;; To her surprise, the interpreter prints back quote.  Explain.

(ns sicp-mailonline.exercises.2-55-test
  (:require [clojure.test :refer :all]))

(deftest exercise2-55
  (testing "(car ''abracadabra)"
    (is (= '(quote abracadabra)
           ''abracadabra))

    (is (= 'quote
           (first ''abracadabra)))

    (is (= '(abracadabra)
           (rest ''abracadabra)))))

;;; In Clojure, ' is a macro character that evaluates to the special form
;;; quote.  Thus ''abracadabra evaluates to (quote (quote abracadabra)), which
;;; results in a list comprising of the two symbols quote and abracadabra.  The
;;; first item (car) of this list is therefore the symbol quote.
