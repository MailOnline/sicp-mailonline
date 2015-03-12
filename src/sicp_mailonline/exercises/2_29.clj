;; Exercise 2.29
;; A binary mobile consists of two branches, a left branch and a right branch.
;; Each branch is a rod of a certain length, from which hangs either a weight or
;; another binary mobile.  We can represent a binary mobile using compound data
;; by constructing it from two branches (for example, using list):
;;
;; (define (make-mobile left right)
;;   (list left right))
;;
;; A branch is constructed from a length (which must be a number) together with
;; a structure, which may be either a number (representing a simple weight) or
;; another mobile:
;;
;; (define (make-branch length structure)
;;   (list length structure))
;;
;; a.  Write the corresponding selectors left-branch and right-branch, which
;; return the branches of a mobile, and branch-length and branch-structure,
;; which return the components of a branch.
;;
;; b.  Using your selectors, define a procedure total-weight that returns the
;; total weight of a mobile.
;;
;; c.  A mobile is said to be balanced if the torque applied by its top-left
;; branch is equal to that applied by its top-right branch (that is, if the
;; length of the left rod multiplied by the weight hanging from that rod is
;; equal to the corresponding product for the right side) and if each of the
;; submobiles hanging off its branches is balanced.  Design a predicate that
;; tests whether a binary mobile is balanced.
;;
;; d.  Suppose we change the representation of mobiles so that the constructors
;; are
;;
;; (define (make-mobile left right)
;;   (cons left right))
;;
;; (define (make-branch length structure)
;;   (cons length structure))
;;
;; How much do you need to change your programs to convert to the new
;; representation?

(ns sicp-mailonline.exercises.2-29)

(defn make-mobile [left right]
  (list left right))

(defn make-branch [length structure]
  (list length structure))

(defn left-branch [mobile]
  (first mobile))

(defn right-branch [mobile]
  (second mobile))

(defn branch-length [branch]
  (first branch))

(defn branch-structure [branch]
  (second branch))

(defn- mobile? [structure]
  (coll? structure))

(declare total-weight)

(defn- branch-weight [branch]
  (let [structure (branch-structure branch)]
    (if (mobile? structure)
      (total-weight structure)
      structure)))

(defn total-weight [mobile]
  (+ (branch-weight (left-branch mobile))
     (branch-weight (right-branch mobile))))

(defn- torque-applied [branch]
  (* (branch-length branch)
     (branch-weight branch)))

(declare balanced?)

(defn- balanced-branch? [branch]
  (let [structure (branch-structure branch)]
    (if (mobile? structure)
      (balanced? structure)
      true)))

(defn balanced? [mobile]
  (let [left (left-branch mobile)
        right (right-branch mobile)]
    (and (= (torque-applied left)
            (torque-applied right))
         (balanced-branch? left)
         (balanced-branch? right))))

;; Using a cons-cell pair rather than a list to represent mobiles & branches
;; does not require any change to the program, as the use of accessors isolates
;; the rest of the program from this implementation detail.
