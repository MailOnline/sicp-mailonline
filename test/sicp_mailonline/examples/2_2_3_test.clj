;; 2.2.3 Sequences as Conventional Interfaces

(ns sicp-mailonline.examples.2-2-3-test
  (:require [sicp-mailonline.examples.2-2-3 :refer :all]
            [clojure.test :refer :all]))

(def ^:privcate ^:const values (list 1 2 3 4 5))

(deftest example2-2-3
  (testing "filter"
    (is (= '(1 3 5)
           (filter odd? values))))

  (testing "accumulate"
    (is (= 15
           (accumulate + 0 values)))

    (is (= 120
           (accumulate * 1 values)))

    (is (= values
           (accumulate cons '() values))))

  (testing "enumerate-interval"
    (is (= '(2 3 4 5 6 7)
           (enumerate-interval 2 7))))

  (testing "enumerate-tree"
    (is (= values
           (enumerate-tree (list 1 (list 2 (list 3 4)) 5)))))
  
  )
