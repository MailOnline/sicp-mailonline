;; 2.2.1 Mapping over lists

(ns sicp-mailonline.examples.2-2-1-test
  (:require [sicp-mailonline.examples.2-2-1 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const squares (list 1 4 9 16 25))
(def ^:private ^:const odds (list 1 3 5 7))

(deftest example2-2-1
  (testing "map abs"
    (is (= '(10 2.5 11.6 17)
           (map #(Math/abs %) (list -10 2.5 -11.6 17)))))

  (testing "map square"
    (is (= squares
           (map #(* % %) (list 1 2 3 4 5)))))

  (testing "scale-list"
    (is (= '(10 20 30 40 50)
           (scale-list (list 1 2 3 4 5) 10))))

  (testing "list-ref"
    (is (= 16
           (list-ref squares 3))))
  
  (testing "length"
    (is (= 4
           (length odds)))

    (is (= 0
           (length '()))))

  (testing "append"
    (is (= '(1 4 9 16 25 1 3 5 7))
        (append squares odds))

    (is (= '(1 3 5 7 1 4 9 16 25))
        (append odds squares))))
