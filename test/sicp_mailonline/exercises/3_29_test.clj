;; Exercise 3.29

(ns sicp-mailonline.exercises.3-29-test
  (:require [sicp-mailonline.exercises.3-29 :refer :all]
            [sicp-mailonline.examples.3-3-4.wire :as wire]
            [sicp-mailonline.examples.3-3-4.simulation :as sim]
            [clojure.test :refer :all]))

(deftest exercise3-29
  (testing "or-gate"
    (let [agenda (sim/make-agenda)
          i1 (wire/make-wire)
          i2 (wire/make-wire)
          output (wire/make-wire)
          gate (or-gate agenda i1 i2 output)]
      (is (= 0 (wire/get-signal output)))

      (wire/set-signal! i1 1)
      (sim/propagate agenda)
      (is (= 1 (wire/get-signal output)))

      (wire/set-signal! i2 1)
      (sim/propagate agenda)
      (is (= 1 (wire/get-signal output)))

      (wire/set-signal! i1 0)
      (sim/propagate agenda)
      (is (= 1 (wire/get-signal output)))

      (wire/set-signal! i2 0)
      (sim/propagate agenda)
      (is (= 0 (wire/get-signal output))))))
