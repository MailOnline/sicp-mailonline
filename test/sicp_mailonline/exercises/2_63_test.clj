;; Exercise 2.63
;; Each of the following two procedures converts a binary tree to a list.
;;
;; (define (tree->list-1 tree)
;;   (if (null? tree)
;;     '()
;;     (append (tree->list-1 (left-branch tree))
;;             (cons (entry tree)
;;                   (tree->list-1 (right-branch tree))))))
;;
;; (define (tree->list-2 tree)
;;   (define (copy-to-list tree result-list)
;;     (if (null? tree)
;;       result-list
;;       (copy-to-list (left-branch tree)
;;                     (cons (entry tree)
;;                           (copy-to-list (right-branch tree)
;;                                         result-list)))))
;;   (copy-to-list tree '()))
;;
;; a.  Do the two procedures produce the same result for every tree?
;;     If not, how do the results differ?
;;     What lists do the two procedures produce for the trees in figure 2.16?
;;
;; b.  Do the two procedures have the same order of growth in the number of
;;     steps required to convert a balanced tree with n elements to a list?
;;     If not, which one grows more slowly?

(ns sicp-mailonline.exercises.2-63-test
  (:require [sicp-mailonline.examples.2-3-3.tree :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const fig-2-16-left-tree (make-tree 7
                                                     (make-tree 3
                                                                (make-tree 1 '() '())
                                                                (make-tree 5 '() '()))
                                                     (make-tree 9
                                                                '()
                                                                (make-tree 11 '() '()))))

(def ^:private ^:const fig-2-16-middle-tree (make-tree 3
                                                       (make-tree 1 '() '())
                                                       (make-tree 7
                                                                  (make-tree 5 '() '())
                                                                  (make-tree 9
                                                                             '()
                                                                             (make-tree 11 '() '())))))

(def ^:private ^:const fig-2-16-right-tree (make-tree 5
                                                      (make-tree 3
                                                                 (make-tree 1 '() '())
                                                                 '())
                                                      (make-tree 9
                                                                 (make-tree 7 '() '())
                                                                 (make-tree 11 '() '()))))

(def ^:private ^:const result (list 1 3 5 7 9 11))

(defn- tree->list1 [tree]
  (if (empty? tree)
    '()
    (concat (tree->list1 (left-branch tree))
            (cons (entry tree)
                  (tree->list1 (right-branch tree))))))

(defn- tree->list2 [tree]
  (letfn [(copy-to-list [tree result-list]
            (if (empty? tree)
              result-list
              (recur (left-branch tree)
                     (cons (entry tree)
                           (copy-to-list (right-branch tree)
                                         result-list)))))]
    (copy-to-list tree '())))

(deftest exercise2-63
  (testing "tree->list1"
    (is (= result
           (tree->list1 fig-2-16-left-tree)))

    (is (= result
           (tree->list1 fig-2-16-middle-tree)))

    (is (= result
           (tree->list1 fig-2-16-right-tree))))

  (testing "tree->list2"
    (is (= result
           (tree->list2 fig-2-16-left-tree)))

    (is (= result
           (tree->list2 fig-2-16-middle-tree)))

    (is (= result
           (tree->list2 fig-2-16-right-tree)))))

;; a)
;; The two procedures produce the same result - an in-order traversal.
;; For the trees of fig 2-16, the result is always (1 3 5 7 9 11).

;; b)
;; In the first procedure, although each node is visited once only, the use of
;; append to concatenate lists on each iteration results in O(n log n)
;; complexity in the number of steps.
;; The second procedure has O(n) complexity.
