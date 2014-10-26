(ns sicp-mailonline.paragraphs.1-1-2-test
  (:require [clojure.test :refer :all]))

(defmacro define [sym val] `(def ~sym ~val))

(deftest naming
  (testing "def"
    (do
      (define size 2)
      (is (= (* 5 size) 10)))
    (do
      (define pi 3.14159)
      (define radius 10)
      (is (= (* pi (* radius radius)) 314.159))
      (define circumference (* 2 pi radius))
      (is (= circumference 62.8318)))))
