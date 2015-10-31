;; Exercise 3.30

(ns sicp-mailonline.exercises.3-30-test
  (:require [sicp-mailonline.exercises.3-30 :refer :all]
            [sicp-mailonline.examples.3-3-4.wire :as wire]
            [sicp-mailonline.examples.3-3-4.simulation :as sim]
            [clojure.test :refer :all]))

(deftest exercise3-30
  ;; when a is set - delay is 8 (and-gate-delay + or-gate-delay)
  (testing "single bit addition when a is set"
    (let [agenda (sim/make-agenda)
          a (vector (wire/make-wire))
          b (vector (wire/make-wire))
          s (vector (wire/make-wire))
          c (wire/make-wire)
          adder (ripple-carry-adder agenda a b s c)]
      (sim/probe 'a agenda (first a))
      (sim/probe 's agenda (first s))
            
      ;; a = 1
      (wire/set-signal! (first a) 1)
      (sim/propagate agenda)

      ;; s = 1 c=0
      (is (= 1 (wire/get-signal (first s))))
      (is (= 0 (wire/get-signal c)))))

  ;; when b is set - delay is 16 = 2*(and-gate-delay + or-gate-delay)
  (testing "single bit addition when b is set"
    (let [agenda (sim/make-agenda)
          a (vector (wire/make-wire))
          b (vector (wire/make-wire))
          s (vector (wire/make-wire))
          c (wire/make-wire)
          adder (ripple-carry-adder agenda a b s c)]
      (sim/probe 'b agenda (first b))
      (sim/probe 's agenda (first s))
            
      ;; b = 1
      (wire/set-signal! (first b) 1)
      (sim/propagate agenda)

      ;; s = 1 c=0
      (is (= 1 (wire/get-signal (first s))))
      (is (= 0 (wire/get-signal c)))))

  (testing "multi-bit addition with no carry"
    (let [agenda (sim/make-agenda)
          a (vector (wire/make-wire) (wire/make-wire))
          b (vector (wire/make-wire) (wire/make-wire))
          s (vector (wire/make-wire) (wire/make-wire))
          c (wire/make-wire)
          adder (ripple-carry-adder agenda a b s c)]
      (sim/probe 'a2 agenda (second a))
      (sim/probe 'b1 agenda (first b))
      (sim/probe 's1 agenda (first s))
      (sim/probe 's2 agenda (second s))
      (sim/probe 'c agenda c)      
      
      ;; a = 01
      (wire/set-signal! (second a) 1)
      ;; b = 10
      (wire/set-signal! (first b) 1)
      (sim/propagate agenda)

      ;; s = 11 c=0
      (is (= 1 (wire/get-signal (first s))))
      (is (= 1 (wire/get-signal (second s))))
      (is (= 0 (wire/get-signal c)))))
  
  (testing "multi-bit addition with carry"
    (let [agenda (sim/make-agenda)
          a (vector (wire/make-wire) (wire/make-wire))
          b (vector (wire/make-wire) (wire/make-wire))
          s (vector (wire/make-wire) (wire/make-wire))
          c (wire/make-wire)
          adder (ripple-carry-adder agenda a b s c)]
      (sim/probe 'a1 agenda (first a))
      (sim/probe 'b1 agenda (first b))
      (sim/probe 'b2 agenda (second b))
      (sim/probe 's1 agenda (first s))
      (sim/probe 's2 agenda (second s))
      (sim/probe 'c agenda c)
      
      ;; a = 10
      (wire/set-signal! (first a) 1)
      ;; b = 11
      (wire/set-signal! (first b) 1)
      (wire/set-signal! (second b) 1)
      (sim/propagate agenda)
      
      ;; s = 01 c=1
      (is (= 0 (wire/get-signal (first s))))
      (is (= 1 (wire/get-signal (second s))))
      (is (= 1 (wire/get-signal c))))))
