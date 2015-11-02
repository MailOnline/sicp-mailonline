;; Exercise 3.37

(ns sicp-mailonline.exercises.3-37-test
  (:require [sicp-mailonline.exercises.3-37 :refer :all]
            [sicp-mailonline.examples.3-3-5.constraints :as con]
            [clojure.test :refer :all]))

(deftest exercise3-37
  (let [c (con/make-connector)
        f (celsius-fahrenheit-converter c)]
    (testing "c->f"
      (con/set-value! c 25 'user)
      (is (= 77 (con/get-value f))))

    (con/forget-value! c 'user)

    (testing "f->c"
      (con/set-value! f 212 'user)
      (is (= 100 (con/get-value c))))))
