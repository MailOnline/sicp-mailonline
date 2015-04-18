;; Example 2.3.2: Symbolic Differentiation

(ns sicp-mailonline.examples.2-3-2)

(defn variable? [e]
  (symbol? e))

(defn same-variable? [v1 v2]
  (and (variable? v1)
       (variable? v2)
       (= v1 v2)))

(defn sum? [e]
  (and (coll? e)
       (= (first e) '+)))

(defn addend [e]             ; first term
  (second e)) 

(defn augend [e]             ; second term
  (last e))                                   

(defn =number? [exp num]
  (and (number? exp)
       (= exp num)))

(defn make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list '+ a1 a2)))

(defn product? [e]
  (and (coll? e)
       (= (first e) '*)))

(defn multiplier [e]         ; first term
  (second e))

(defn multiplicand [e]       ; second term
  (last e))

(defn make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))

;;; Differentiation reduction rules:
;;; dc/dx = 0 for c a constant or a variable different from x
;;; dx/dx = 1
;;; d(u+v)/dx = du/dx + dv/dx
;;; d(uv)/dx = u(dv/dx) + v(du/dx)
(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum (make-product (multiplier exp)
                                               (deriv (multiplicand exp) var))
                                 (make-product (deriv (multiplier exp) var)
                                               (multiplicand exp)))
        :else (throw (IllegalArgumentException.
                      (format "unknown expression type [%s] -- DERIV" exp)))))
