(ns sicp-mailonline.mutable
  (:require [clojure.zip :as z]))

(definterface MutableList
  (setcar [newcar])
  (car [])
  (setcdr [newcdr])
  (cdr [])
  (last []))

(deftype Cons [^:unsynchronized-mutable car
               ^:unsynchronized-mutable cdr]
  MutableList
  (setcar [this newcar] (do (set! car newcar) this))
  (car [this] car)
  (setcdr [this newcdr] (do (set! cdr newcdr) this))
  (cdr [this] cdr)
  (last [this]
    (if (nil? (.cdr this))
      this
      (.last (.cdr this))))
  Object
  (equals [this other] (and (= car (.car other)) (= cdr (.cdr other))))
  (hashCode [this] (.hashCode car))
  (toString [this] (str "[" car " . " cdr "]")))

(defmacro ->cons [& [body]]
  (println body))

(defn dfs-post-order-traversal [zipper]
  "Experimenting with transforming list into conses.
   (dfs-post-order-traversal (z/seq-zip '((a b) (c d))))"
  (loop [loc zipper, a '()]
    (cond
      (z/end? loc)
      (do (println "### the end")
          (conj a (z/node loc)))
      (z/branch? loc)
      (do (println "### is a branch, recurring. z/node" (z/node loc) "z/path" (z/path loc))
          (recur (z/next loc) (cons a 'Cons. a)))
      :else
      (recur
        (z/next loc)
        (do (println "### not a branch. z/node" (z/node loc) "z/path" (z/path loc))
            (into
              (conj a (z/node loc))
              (reverse
                (drop
                  ((fnil count [nil]) (z/path (z/next loc)))
                  (z/path loc)))))))))

; Examples:
; (Cons. nil nil)
; (def x (Cons. (Cons. 'a (Cons. 'b nil)) (Cons. 'c (Cons. 'd nil))))
; (def y (Cons. 'e (Cons. 'f nil))
; (.car x)
; ;;=> (Cons. 'a (Cons. 'b nil))
; (.cdr x)
; ;;=> (Cons. 'c (Cons. 'd nil))
; (.setcar x y)
; (.setcdr x y)

