;; Exercise 2.68
;; The encode procedure takes as arguments a message and a tree and produces the
;; list of bits that give the encoded message.
;;
;; (define (encode message tree)
;;   (if (null? message)
;;     '()
;;     (append (encode-symbol (car message) tree)
;;             (encode (cdr message) tree))))
;;
;; Encode-symbol is a procedure, which you must write, that returns the list of
;; bits that encodes a given symbol according to a given tree.  You should
;; design encode-symbol so that in signals an error if the symbol is not in the
;; tree at all.  Test your procedure by encoding the result you obtained in
;; exercise 2.67 with the sample tree and seeing whether it is the same as the
;; original sample message.

(ns sicp-mailonline.exercises.2-68
  (:require [sicp-mailonline.examples.2-3-4 :refer :all]
            [sicp-mailonline.examples.2-3-3.unordered :refer [element-of-set?]]))

(defn- encode-symbol [symbol tree]
  (cond (not (element-of-set? symbol
                              (symbols tree))) (throw (IllegalArgumentException.
                                                       (str "bad symbol -- ENCODE-SYMBOL " symbol)))
        (leaf? tree) '()
        (element-of-set? symbol
                         (symbols (left-branch tree))) (cons 0 (encode-symbol symbol
                                                                              (left-branch tree)))
        :else (cons 1 (encode-symbol symbol
                                     (right-branch tree)))))

(defn encode [message tree]
  (if (empty? message)
    '()
    (concat (encode-symbol (first message) tree)
            (encode (rest message) tree))))
