;; Exercise 1.2
;; Translate the following expression into prefix form
;;
;; 5 + 4 + (2 - (3 - (6 + 4/5)))
;; -----------------------------
;;        3(6 - 2)(2 - 7)

(ns sicp-mailonline.exercises.1-2-test
  (:require [clojure.test :refer :all]))

(deftest exercise1-2
  (is (= -37/150
         (/ 
           (+ 5                      ; 14 4/5  
              4 
              (- 2 
                 (- 3 
                    (+ 6 4/5))))
           (* 3                      ; -60
              (- 6 2) 
              (- 2 7))))))
