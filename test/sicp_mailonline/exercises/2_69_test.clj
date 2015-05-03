;; Exercise 2.69

(ns sicp-mailonline.exercises.2-69-test
  (:require [sicp-mailonline.exercises.2-69 :refer :all]
            [sicp-mailonline.examples.2-3-4 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const sample-pairs '((A 8) (B 3) (C 1) (D 1) (E 1) (F 1) (G 1) (H 1)))

(deftest exercise2-69
  (testing "can generate Huffman tree"
    (let [tree (generate-huffman-tree sample-pairs)]
      (is (= '(A H G F E D C B)
             (symbols tree)))
      (is (= 17
             (weight tree)))

      (is (= '(A)
             (symbols (left-branch tree))))
      (is (= 8
             (weight (left-branch tree))))
        
      (is (= '(H G F E D C B)
             (symbols (right-branch tree))))
      (is (= 9
             (weight (right-branch tree)))))))

;; ((A 8) (B 3) (C 1) (D 1) (E 1) (F 1) (G 1) (H 1))
;; sort                     -> ((H 1) (G 1) (F 1) (E 1) (D 1) (C 1) (B 3) (A 8))
;; merge (H 1) + (G 1)      -> ((F 1) (E 1) (D 1) (C 1) (HG 2) (B 3) (A 8))
;; merge (F 1) + (E 1)      -> ((D 1) (C 1) (HG 2) (FE 2) (B 3) (A 8))
;; merge (D 1) + (C 1)      -> ((HG 2) (FE 2) (DC 2) (B 3) (A 8))
;; merge (HG 2) + (FE 2)    -> ((DC 2) (B 3) (HGFE 4) (A 8))
;; merge (DC 2) + (B 3)     -> ((HGFE 4) (DCB 5) (A 8))
;; merge (HGFE 4) + (DCB 5) -> ((A 8) (HGFEDCB 9))
