(ns sicp-mailonline.paragraphs.2-3-4-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.2-3-4 :refer :all]))

(facts "huffmann trees scheme style"
       (facts "leaves"
              (fact "creating"
                    (make-leaf "A" 2) => ['leaf "A" 2])
              (fact "checking"
                    (leaf? (make-leaf 1 2)) => true)
              (fact "accessors"
                    (symbol-leaf (make-leaf 1 2)) => 1
                    (weight-leaf (make-leaf :a 2)) => 2))
       (facts "trees"
              (let [t (make-code-tree (make-leaf :a 1) (make-leaf :b 2))]
                (fact "creating from leaves"
                      t => '((leaf :a 1) (leaf :b 2) (:a :b) 3))
                (fact "creating from other trees"
                      (make-code-tree t t) =>
                      '(((leaf :a 1) (leaf :b 2) (:a :b) 3)
                        ((leaf :a 1) (leaf :b 2) (:a :b) 3)
                        (:a :b :a :b)
                        6)))))

(def sample-tree
  (make-code-tree
    (make-leaf 'A 4)
    (make-code-tree
      (make-leaf 'B 2)
      (make-code-tree (make-leaf 'D 1) (make-leaf 'C 1)))))

(facts "decoding"
       (fact "it should return the decoded message"
             (decode '(0 1 1 0 0 1 0 1 0 1 1 1 0) sample-tree) => '(A D A B B C A)))
