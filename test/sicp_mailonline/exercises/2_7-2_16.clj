(ns sicp-mailonline.core-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.core :refer :all]))
; 
; Exercise 2.7 - 2.16
;


;
; Excercise 2.7
;

(deftest add-interval-test
  (testing "add-interval"
    (is (= 
      (add-interval 
        (make-interval 2 3)
        (make-interval 6 8))
      '(8 11)))))

(deftest mul-interval-test
  (testing "mul-interval"
    (is (= 
      (mul-interval 
        (make-interval 2 3)
        (make-interval 6 8))
      '(12 24)))))


;
; Excercise 2.8
;

(deftest subtract-interval-test
  (testing "subtract-interval"
    (is (= 
      (subtract-interval 
        (make-interval 6 8)
        (make-interval 2 3))
      '(3 6)))))


;
; Excercise 2.9
;

(deftest width-test
  (testing "width of addition works"
    (is (=
      (width
       (add-interval 
        (make-interval 2 3)
        (make-interval 6 8)))
      (+
        (width (make-interval 2 3))
        (width (make-interval 6 8))))))
  (testing "width of multiplication fails"
    (is
      (not= 
        (width
          (mul-interval 
            (make-interval 2 3)
            (make-interval 6 8)))
        (*
          (width (make-interval 2 3))
          (width (make-interval 6 8)))))))

;
; Exercise 2.10
;

(deftest div-test
  (testing "division denominator not spanning zero"
    (is (=
      (div-interval '(2 4) '(1 8))
      '(0.25 4.0))))
  (testing "divison denominator spanning zero"
    (is (=
      (div-interval '(2 4) '(-1 8))
      "Cannot divide by zero"))))

;
; Exercise 2.11
;

(defn float= [x y tolerance]
  (<= (Math/abs (- x y)) tolerance))

(defn interval= [a b tolerance]
    (and
      (float= (lower-bound a) (lower-bound b) tolerance)
      (float= (upper-bound a) (upper-bound b) tolerance)))

(deftest mul-interval-opt-test    
  (defn get-rand-bound []
    ; Math/random gives [0, 1)
    (let [val (Math/random)]
      (if (< val 0.3) 0
        (* (- val 0.6) 100))))

  (defn create-rand-interval []
    (let [a (get-rand-bound)
          b (get-rand-bound)]
      (make-interval (min a b) (max a b))))
   
  (testing "optimised multiply matches basic multiply"    
    (def runner (for [i (range 0 10000)] (do 
      (let [a (create-rand-interval)
            b (create-rand-interval)]
        (let [result (mul-interval-opt a b)
              expected (mul-interval a b)]
              (is 
                (interval= result expected 0.00001)
                (clojure.string/join " " (list "First " a  "Second " b))))))))

    (dorun runner)))

;
; Exercise 2.12 
;

(deftest width-test
  (testing "width of interval"
    (is (=
      (width '(2 4))
      1))))

(deftest centre-test
  (testing "centre of interval"
    (is (=
      (centre '(2 4))
      3))))

(deftest percent-test
  (testing "percentage tolerance of interval"
    (is (=
      (percent '(3 5))
      25.0))))

;
; Exercise 2.13
;


(deftest tolerance-mul-test
  (testing "show tolerances sum when intervals are multiplied"
    (is (float=
      (percent 
        (mul-interval 
          (make-centre-percent 1 1) 
          (make-centre-percent 1 2)))
      3
      0.01))))


;
; Exercise 2.14
;

(deftest different-parallel-resistor-formula-test
  (testing "R1 R2/(R1 + R2) no tolerance"
    (is (=
      (par1 '(2.0 2.0) '(2.0 2.0))
      '(1.0 1.0))))
  (testing "1/(1/R1 + 1/R2) no tolerance"
    (is (=
      (par2 '(2.0 2.0) '(2.0 2.0))
      '(1.0 1.0))))
  (testing "different formulae give differen results with tolerances"
    (is (not=
      (par1 '(1.9 2.1) '(1.9 2.1))
      (par2 '(1.9 2.1) '(1.9 2.1))))))


;
; Exercise 2.16
;
(deftest evaluate-interval-test
  (testing "Show this approach gives same value for both parallel resistor formula"
    (let [a (evaluate-interval par1-lambda '(1.9 2.1) '(1.9 2.1))
          b (evaluate-interval par1-lambda '(1.9 2.1) '(1.9 2.1))]
      
      (is (float= (lower-bound a) (lower-bound b) 0.00001))
      (is (float= (upper-bound a) (upper-bound b) 0.00001)))))
      


(run-tests)

