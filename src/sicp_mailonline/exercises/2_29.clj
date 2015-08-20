;
; Exercise 2.29
;

(ns sicp-mailonline.exercises.2-29)


;
; Constructors and selectors
;

(defn make-mobile [left right]
  [left right])

(defn make-branch [length structure]
  [length structure])

(defn left-branch [mobile]
  (first mobile))

(defn right-branch [mobile]
  (second mobile))

(defn branch-length [branch]
  (first branch))

(defn branch-structure [branch]
  (second branch))


;
; Operations
;

(declare total-weight)

(defn- total-weight-branch [b]
  (let [structure (branch-structure b)]      
        (if (coll? structure) (total-weight structure) structure)))

(defn total-weight [m]
  (+ (total-weight-branch (left-branch m))
     (total-weight-branch (right-branch m))))

(defn is-balanced? [m]
  (letfn [(is-balanced-branch? [b]
            (let [structure (branch-structure b)]
                  (or (not (coll? structure)) (is-balanced? structure))))
    
          (torque [b] 
            (* (branch-length b) (total-weight-branch b)))]

          (let [left-branch (left-branch m)
                right-branch (right-branch m)]
                (and
                  (is-balanced-branch? left-branch)
                  (is-balanced-branch? right-branch)
                  (= (torque left-branch) (torque right-branch))))))
;
; Changing from a (cons a  b) (in Clojure [a b]) to (list a b) (in CLojure (list a b))
; does not require any other code changes.
; Uncomment lines below to see 
; 

; (defn make-mobile [left right]
;   (list left right))

; (defn make-branch [length structure]
;   (list length structure))






