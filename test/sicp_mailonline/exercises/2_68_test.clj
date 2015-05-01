(ns sicp-mailonline.exercises.2-68-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.2-3-4 :refer :all]
            [sicp-mailonline.exercises.2-68 :refer :all]))

(def sample-tree
  (make-code-tree
    (make-leaf 'A 4)
    (make-code-tree
      (make-leaf 'B 2)
      (make-code-tree (make-leaf 'D 1) (make-leaf 'C 1)))))

(facts "encoding a message in a huffman tree"
       (fact "empty message"
             (encode '() '()) => '())
       (fact "message gets back encoded based on tree"
             (encode '(A D A B B C A) sample-tree) => '(0 1 1 0 0 1 0 1 0 1 1 1 0)))
