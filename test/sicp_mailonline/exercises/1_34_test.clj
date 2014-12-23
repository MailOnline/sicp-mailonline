;; Exercise 1.34
;; Suppose we define the procedure
;;
;;   (define (f g)
;;     (g 2))
;;
;; Then we have
;;
;;  (f square)
;; => 4
;;
;; (f (lambda (z) (* z (+ z 1))))
;; => 6
;;
;; What happens if we (perversely) ask the interpreter to evaluate the
;; combination (f f)?  Explain.

(ns sicp-mailonline.exercises.1-34-test
  (:require [clojure.test :refer :all]))

(defn- square [x]
  (* x x))

(defn- f [g]
  (g 2))

(deftest exercise1-34
  (testing "examples"
    (is (= 4
           (f square)))

    (is (= 6
           (f (fn [z] (* z (inc z)))))))

  (testing "the atom 2 is not a function"
    (is (thrown-with-msg? ClassCastException
                          #"java.lang.Long cannot be cast to clojure.lang.IFn"
                          (f f)))))

;; (f f)
;; (f 2)
;; (2 2)
;; The attempt to evaluate (2 2) fails because 2 is not a function.
;; In Clojure, the error message is 'java.lang.Long cannot be cast to clojure.lang.IFn'.
;; In MIT Scheme, the error message is 'The object 2 is not applicable'.
