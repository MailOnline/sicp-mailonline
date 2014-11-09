;; Exercise 1.10
;; The following procedure computes a mathematical function called Ackermann's
;; function.

(ns sicp-mailonline.exercises.1-10-test
  (:require [clojure.test :refer :all]))

(defn- A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (dec x)
                 (A x (dec y)))))

;; What are the values of the following expressions?
;; (A 1 10)
;; (A 0 (A 1 9))
;; (A 0 (A 0 (A 1 8)))
;; (A 0 (A 0 (A 0 (A 1 7))))
;; (A 0 (A 0 (A 0 (A 0 (A 1 6)))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 5))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 4)))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 3))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 2)))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 1))))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2)))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 8)))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 16))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 32)))))
;; (A 0 (A 0 (A 0 (A 0 64))))
;; (A 0 (A 0 (A 0 128)))
;; (A 0 (A 0 256))
;; (A 0 512)
;; => 1024

;; (A 2 4)
;; (A 1 (A 2 3))
;; (A 1 (A 1 (A 2 2)))
;; (A 1 (A 1 (A 1 (A 2 1))))
;; (A 1 (A 1 (A 1 2)))
;; (A 1 (A 1 (A 0 (A 1 1))))
;; (A 1 (A 1 (A 0 2)))
;; (A 1 (A 1 4))
;; (A 1 (A 0 (A 1 3)))
;; (A 1 (A 0 (A 0 (A 1 2))))
;; (A 1 (A 0 (A 0 (A 0 (A 1 1)))))
;; (A 1 (A 0 (A 0 (A 0 2))))
;; (A 1 (A 0 (A 0 4)))
;; (A 1 (A 0 8))
;; (A 1 16)
;; (A 0 (A 1 15))
;; (A 0 (A 0 (A 1 14)))
;; (A 0 (A 0 (A 0 (A 1 13))))
;; (A 0 (A 0 (A 0 (A 0 (A 1 12)))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 11))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 10)))))))
;; substituting (= 1024 (A 1 10)) from above ...
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 1024))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 2048)))))
;; (A 0 (A 0 (A 0 (A 0 4096))))
;; (A 0 (A 0 (A 0 8192)))
;; (A 0 (A 0 16384))
;; (A 0 32768)
;; => 65536

;; (A 3 3)
;; (A 2 (A 3 2))
;; (A 2 (A 2 (A 3 1)))
;; (A 2 (A 2 2))
;; (A 2 (A 1 (A 2 1)))
;; (A 2 (A 1 2))
;; (A 2 (A 0 (A 1 1)))
;; (A 2 (A 0 2))
;; (A 2 4)
;; substituting (= 65536 (A 2 4)) from above ...
;; => 65536


;; Consider the following procedures, where A is the procedure defined above:
(defn- f [n]
  (A 0 n))

(defn- g [n]
  (A 1 n))

(defn- h [n]
  (A 2 n))

(defn- k [n]
  (* 5 n n))

;; Consider concise mathematical definitions for the functions computed by the
;; procedures f,g, and h for positive integer values of n.
;; For example, (k n) computes 5n^2.
;;
;; => (f n) = 2n
;; => (g n) = 2^n
;; => (h n) = 2^2^ ... for n number of 2's


(deftest exercise1-10
  (testing "Ackermann's function"
    (is (= 1024
           (A 1 10)))
    (is (= 65536
           (A 2 4)))
    (is (= 65536
           (A 3 3))))

  (testing "(f n) = 2n"
    (are [n x] (= x
                  (f n))
         1 2
         2 4
         3 6
         4 8))

  (testing "(g n) = 2^n"
    (are [n x] (= x
                  (g n))
         1 2
         2 4
         3 8
         4 16))

  (testing "(h n) = 2^2^ ... for n number of 2's"
    (are [n x] (= x
                  (h n))
         1 2
         2 4
         3 16
         4 65536)))
