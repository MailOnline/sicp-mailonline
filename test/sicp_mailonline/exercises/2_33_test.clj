;
; Exercise 2.33
; 

(ns sicp-mailonline.exercises.2-33-test
  (require [sicp-mailonline.exercises.2-33 :refer :all]
           [clojure.test :refer :all]))

(deftest s-map-test
  (testing "Nils"
    (is (nil? (s-map inc nil))))

  (testing "Non-nils"
    (is (= (s-map inc '(1 2 3)) '(2 3 4)))))

(deftest s-apppend-test
  (testing "Nils"
    (is (nil? (s-append nil nil)))
    (is (= (s-append nil '(1 2 3)) '(1 2 3)))
    (is (= (s-append '( 1 2 3) nil) '(1 2 3))))

  (testing "Not nils"
    (is (= (s-append '(1 2 3) '(4 5 6)) '(1 2 3 4 5 6)))))

(deftest s-length-test
  (testing "Nils"
    (is (= (s-length nil) 0)))

  (testing "Not nil"
    (is (= (s-length '(1 2 3))))))

(run-tests)


