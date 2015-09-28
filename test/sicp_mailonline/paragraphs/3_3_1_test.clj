(ns sicp-mailonline.paragraphs.3-3-1-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.mutable :refer :all]
            [sicp-mailonline.paragraphs.3-3-1 :refer :all])
  (:import [sicp_mailonline.mutable Cons]))

(facts "mutators this way won't be mutating the original list"
       (fact "set car cdr"
             (let [x (cons (cons 'a (cons 'b nil)) (cons 'c (cons 'd nil)))
                   y (cons 'e (cons 'f nil))]
               x => '((a b) c d)
               (set-car!! x y) => '((e f) c d)
               (set-cdr!! x y) => '((a b) (e f)))))

(facts "mutators on mutable deftypes"
       (fact "set car cdr"
             (let [x (Cons. (Cons. 'a (Cons. 'b nil)) (Cons. 'c (Cons. 'd nil)))
                   y (Cons. 'e (Cons. 'f nil))]
               (.car x) => (Cons. 'a (Cons. 'b nil))
               (.cdr x) => (Cons. 'c (Cons. 'd nil))
               (.setcar x y) => (Cons. (Cons. 'e (Cons. 'f nil)) (Cons. 'c (Cons. 'd nil)))
               (.setcdr x y) => (Cons. (Cons. 'e (Cons. 'f nil)) (Cons. 'e (Cons. 'f nil))))))

(facts "other mutators operations"
       (fact "it shows the last pair"
             (.last (Cons. 'a (Cons. 'b nil))) => (Cons. 'b nil)
             (.last (Cons. (Cons. 'a (Cons. 'b nil)) (Cons. 'c (Cons. 'd nil)))) => (Cons. 'd nil)))
