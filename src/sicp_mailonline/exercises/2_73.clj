;; Exercise 2.73
;; Section 2.3.2 described a program that performs symbolic differentiation:
;;
;; (define (deriv exp var)
;;   (cond ((number? exp) 0)
;;         ((variable? exp) (if (same-variable? exp var) 1 0))
;;         ((sum? exp) (make-sum (deriv (addend exp) var)
;;                               (deriv (augend exp) var)))
;;         ((product? exp) (make-product (multiplier exp)
;;                                       (deriv (multiplicand exp) var))
;;                         (make-product (deriv (multiplier exp) var)
;;                                       (multiplicand exp)))
;;         ;; more rules can be added here
;;         (else (error "unknown expression type -- DERIV" exp))))
;;
;; We can regard this program as performing dispatch on the type of the
;; expression to be differentiated.  In this situation the "type tag" of the
;; datum is the algebraic operator symbol (such as +) and the operation being
;; performed is deriv.  We can transform this program into data-directed style
;; by rewriting the basic derivative procedure as
;;
;; (define (deriv exp var)
;;   (cond ((number? exp) 0)
;;         ((variable? exp) (if (same-variable? exp var) 1 0))
;;         (else ((get 'deriv (operator exp)) (operands exp) var))))
;;
;; (define (operator exp)
;;   (car exp))
;;
;; (define (operands exp)
;;   (cdr exp))
;;
;; a.  Explain what was done above.  Why can't we assimilate the predicates
;; number? and same-variable? into the data-directed dispatch?
;; b.  Write the procedures for derivatives of sums and products, and the
;; auxillary code required to install them in the table used by the program
;; above.
;; c.  Choose any additional differentiation rule that you like, such as the one
;; for exponents (exercise 2.56), and install it in this data-directed system.
;; d.  In this simple algebraic manipulator the type of an expression is the
;; algebraic operator that binds it together.  Suppose, however, we indexed the
;; procedures in the opposite way, so that the dispatch line in deriv looked
;; like
;;
;; ((get (operator exp) 'deriv) (operands exp) var)
;;
;; What corresponding changes to the derivatives system are required?


;; a.)  The in-line rules that relate to the differentiation of specific
;; algebraic operations have been replaced with a generic operation that looks
;; up the rule to perform by dispatching on the algebraic operation's symbol.
;; This rule is then applied to the expression's operands and the
;; differentiation variable.
;;
;; We cannot assimilate the number? and same-variable? predicates into the
;; data-directed dispatch because matching expressions will not have an
;; algebraic operator symbol - which is acting here as the dispatch "type tag".

;; d.)  The only change to the derivatives system would be to change the order
;; of the arguments to put in install-deriv! in order to be consistent with its
;; new definition.

(ns sicp-mailonline.exercises.2-73
  (:require [sicp-mailonline.examples.2-3-2 :refer [variable? same-variable?
                                                    make-sum make-product]]
            [sicp-mailonline.exercises.2-56 :refer [make-exponentiation]]))

(declare get)

;; deriv
(defn- operator [exp]
  (first exp))

(defn- operands [exp]
  (rest exp))

(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        :else ((get 'deriv (operator exp)) (operands exp) var)))

;; differentiation rules
(defn- addend [operands]
  (first operands))

(defn- augend [operands]
  (second operands))

(defn- deriv-sum [operands var]
  (make-sum (deriv (addend operands) var)
            (deriv (augend operands) var)))

(defn- multiplier [operands]
  (first operands))

(defn- multiplicand [operands]
  (second operands))

(defn- deriv-product [operands var]
  (make-sum (make-product (multiplier operands)
                          (deriv (multiplicand operands) var))
            (make-product (deriv (multiplier operands) var)
                          (multiplicand operands))))

(defn- base [operands]
  (first operands))

(defn- exponent [operands]
  (second operands))

(defn- deriv-exponent [operands var]
  (make-product (make-product (exponent operands)
                              (make-exponentiation (base operands)
                                                   (make-sum (exponent operands)
                                                             -1)))
                (deriv (base operands) var)))

;; data-directed configuration
(def ^:private op-table (atom {}))

(defn- put [op type item]
  (swap! op-table assoc-in [op type] item))

(defn- get [op type]
  (get-in @op-table [op type]))

(defn install-deriv! []
  (put 'deriv '+ deriv-sum)
  (put 'deriv '* deriv-product)
  (put 'deriv '** deriv-exponent))
