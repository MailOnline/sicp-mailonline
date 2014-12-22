;; Exercise 1.37

(ns sicp-mailonline.exercises.1-37-test
  (:require [sicp-mailonline.exercises.1-37 :refer :all]
            [clojure.test :refer :all]))

(defn- close-to? [a b]
  (< (Math/abs (- a b)) 0.0001))

(defn- find-k-satisfying [cont-frac pred]
  (letfn [(iter [k]
            (cond (<= k 0) (throw (IllegalArgumentException.
                                   (str "Invalid argument " k)))
                  (> k 1000) (throw (IllegalStateException. "k not found"))
                  (pred (one-over-golden-ratio cont-frac k)) k
                  :else (recur (inc k))))]
    (iter 1)))

(def ^:private ^:const expected-one-over-golden-ratio 0.6180)

(deftest exercise1.37
  (testing "approximating 1 over the golden ratio = 0.6180 via a recursive process"
    (is (= 10
           (find-k-satisfying cont-frac-r
                              (partial close-to? expected-one-over-golden-ratio)))))

  (testing "approximating 1 over the golden ratio = 0.6180 via an iterative process"
    (is (= 10
           (find-k-satisfying cont-frac-i
                              (partial close-to? expected-one-over-golden-ratio))))))
