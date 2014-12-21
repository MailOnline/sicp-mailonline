;; Exercise 1.35
;; Show that the golden ratio o (section 1.2.2) is a fixed point of the
;; transformation x |-> 1 + 1/x, and use this fact to compute o by means
;; of the fixed-point procedure.

(ns sicp-mailonline.exercises.1-35-test
  (:require [sicp-mailonline.examples.1-3-3 :refer [fixed-point]]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.00001))

(defn- golden-ratio []
  (/ (+ 1 (Math/sqrt 5)) 2))  ;; ~ 1.6180

(deftest exercise1-35
  (testing "golden ratio"
    (is (close-to? (golden-ratio)
                   (fixed-point (fn [x] (+ 1 (/ 1 x)))
                                1.0)))))

;; the golden ratio o satisfies the equation: o^2 = o + 1
;; substituting the transformation:
;;    1 + 1/o = o^2 / o
;;    1 + 1/o = o + 1 / o
;;    o + 1   = o + 1
