;; Exercise 2.81
;; Louis Reasoner has noticed that apply-generic may try to coerce the arguments
;; to each other's type even if they already have the same type.  Therefore, he
;; reasons, we need do put procedures in the coercion table to "coerce"
;; arguments of each type to their own type.  For example, in addition to the
;; scheme-number->complex coercion shown above, he would do:
;;
;; (define (scheme-number->scheme-number n) n)
;; (define (complex->complex z) z)
;; (put-coercion 'scheme-number 'scheme-number scheme-number->scheme-number)
;; (put-coercion 'complex 'complex complex->complex)
;;
;; a.  With Louis' coercion procedure installed, what happens if apply-generic
;; is called with two arguments of type scheme-number or two arguments of type
;; complex for an operation that is not found in the table for those types?
;; For example, assume that we've defined a generic exponentiation operation:
;;
;; (define (exp x y) (apply-generic 'exp x y))
;;
;; and have put a procedure for exponentiation in the Scheme-number package but
;; not in any other package:
;;
;; ;; following added to Scheme-number package - uses primitive expt
;; (put 'exp '(scheme-number scheme-number) (lambda (x y) (tag (expt x y))))
;;
;; What happens if we call exp with two complex numbers as arguments?
;;
;; b.  Is Louis correct that something had to be done about coercion with
;; arguments of the same type, or does apply-generic work correctly as is?
;;
;; c.  Modify apply-generic so that it doesn't try coercion if the two arguments
;; have the same type.

(ns sicp-mailonline.exercises.2-81)

(declare type-tags contents)
(declare get get-coercion)

(defn apply-generic [op & args]
  (let [type-tags (map type-tags args)
        proc (get op type-tags)
        throw-no-method (fn [] (throw (IllegalArgumentException.
                                       (str "No method for these types " (list op type-tags)))))]
    (if proc
      (apply proc (map contents args))
      (if (= (count args) 2)
        (let [type1 (first type-tags)
              type2 (second type-tags)]
          (if (= type1 type2)
            (throw-no-method)
            (let [a1 (first args)
                  a2 (second args)
                  t1->t2 (get-coercion type1 type2)
                  t2->t1 (get-coercion type2 type1)]
              (cond t1->t2 (recur op (list (t1->t2 a1) a2))
                    t2->t1 (recur op (list  a1 (t2->t1 a2)))
                    :else (throw-no-method)))))
        (throw-no-method)))))

;; a.  We will enter an infinite loop.  As exp is not defined for two complex
;; numbers, the procedure will interrogate the defined coercions, and find
;; Louis' identity conversion.  As the procedure will retry the operation with
;; the result of the conversion, and the output from the conversion will be
;; identical to the input, the procedure is doomed to continuously retry the
;; operation with the same values.
;;
;; b.  Louis is incorrect - something does not need to be done.  Assuming that
;; no coercion has been defined from a type to itself, the procedure will enter
;; the :else clause of the cond and throw an exception - which is all we could
;; do with an explicit check anyway.  An explicit check for the same types would
;; however elininate the two unnecessary get-coercion lookups.
