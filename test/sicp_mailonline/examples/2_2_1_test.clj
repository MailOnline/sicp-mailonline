;; 2.2.1 Mapping over lists

(ns sicp-mailonline.examples.2-2-1-test
  (:require [sicp-mailonline.examples.2-2-1 :refer :all]
            [clojure.test :refer :all]))

(deftest example2-2-1
  (testing "map abs"
    (is (= '(10 2.5 11.6 17)
           (map #(Math/abs %) (list -10 2.5 -11.6 17)))))

  (testing "map square"
    (is (= '(1 4 9 16)
           (map #(* % %) (list 1 2 3 4)))))

  (testing "scale-list"
    (is (= '(10 20 30 40 50)
           (scale-list (list 1 2 3 4 5) 10)))))
