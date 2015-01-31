;; Exercise 2.9

(ns sicp-mailonline.exercises.2-9-test
  (:require [sicp-mailonline.exercises.2-9 :refer :all]
            [sicp-mailonline.exercises.2-8 :refer :all]
            [sicp-mailonline.exercises.2-7 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const an-interval-of-width-2 (make-interval 2 6))
(def ^:private ^:const an-interval-of-width-3 (make-interval 3 9))
(def ^:private ^:const another-interval-of-width-2 (make-interval 20 24))
(def ^:private ^:const another-interval-of-width-3 (make-interval 30 36))
(def ^:private ^:const scale 4)

(deftest exercise2-9
  (testing "width"
    (are [x] (= 2 (width x))
         an-interval-of-width-2
         another-interval-of-width-2)

    (are [x] (= 3 (width x))
         an-interval-of-width-3
         another-interval-of-width-3))
  
  (testing "width of the sum is a function of the widths of the argument intervals"
    (let [sum-a (add-interval an-interval-of-width-2 an-interval-of-width-3)
          sum-b (add-interval an-interval-of-width-2 another-interval-of-width-3)
          sum-c (add-interval another-interval-of-width-2 an-interval-of-width-3)
          sum-d (add-interval another-interval-of-width-2 another-interval-of-width-3)]
      (is (= (width sum-a)
             (width sum-b)
             (width sum-c)
             (width sum-d)
             (+ (width an-interval-of-width-2) (width an-interval-of-width-3))))))

  (testing "width of the difference is a function of the widths of the argument intervals"
    (let [diff-a (sub-interval an-interval-of-width-2 an-interval-of-width-3)
          diff-b (sub-interval an-interval-of-width-2 another-interval-of-width-3)
          diff-c (sub-interval another-interval-of-width-2 an-interval-of-width-3)
          diff-d (sub-interval another-interval-of-width-2 another-interval-of-width-3)]
      (is (= (width diff-a)
             (width diff-b)
             (width diff-c)
             (width diff-d)
             (+ (width an-interval-of-width-2) (width an-interval-of-width-3))))))

  (testing "width of the multiple is not a function of the widths of the argument intervals"
    (let [prod-a (mul-interval an-interval-of-width-2 an-interval-of-width-3)
          prod-b (mul-interval an-interval-of-width-2 another-interval-of-width-3)
          prod-c (mul-interval another-interval-of-width-2 an-interval-of-width-3)
          prod-d (mul-interval another-interval-of-width-2 another-interval-of-width-3)]
      (is (not= (width prod-a)
                (width prod-b)
                (width prod-c)
                (width prod-d)))))

  (testing "width of the ratio is not a function of the widths of the argument intervals"
    (with-precision scale
      (let [ratio-a (div-interval an-interval-of-width-2 an-interval-of-width-3)
            ratio-b (div-interval an-interval-of-width-2 another-interval-of-width-3)
            ratio-c (div-interval another-interval-of-width-2 an-interval-of-width-3)
            ratio-d (div-interval another-interval-of-width-2 another-interval-of-width-3)]
        (is (not= (width ratio-a)
                  (width ratio-b)
                  (width ratio-c)
                  (width ratio-d)))))))
