;; Exercise 2.78
;; The internal procedures in the scheme-number package are essentially nothing
;; more than calls to the procedures +, -, etc.  It was not possible to use the
;; primitives of the language directly because our type-tag system requires that
;; each data object have a type attached to it.  In fact, however, all Lisp
;; implementations do have a type system, which they use internally.  Primitive
;; predicates such as symbol? and number? determine whether data objects have
;; particular types.  Modify the definitions of type-tag, contents, and
;; attach-tag from section 2.4.2 so that our generic system takes advantage of
;; Scheme's internal type system.  That is to say, the system should work as
;; before except that ordinary numbers should be represented simply as Scheme
;; numbers rather than as pairs whose car is the symbol scheme-number.

(ns sicp-mailonline.exercises.2-78)

(defn attach-tag [type-tag contents]
  (if (number? contents)
    contents
    (list type-tag contents)))

(defn type-tag [datum]
  (cond (number? datum) 'scheme-number
        (coll? datum) (first datum)
        :else (throw (IllegalArgumentException.
                      (format "Bad tagged datum -- TYPE-TAG %s" datum)))))

(defn contents [datum]
  (cond (number? datum) datum
        (coll? datum) (rest datum)
        :else (throw (IllegalArgumentException.
                      (format "Bad tagged datum -- CONTENTS %s" datum)))))
