;; Exercise 2.5
;; Show that we can represent pairs of nonnegative integers using only numbers
;; and arithmetic operations if we represent the pair a and b as the integer
;; that is the product 2^a3^b.  Give the corresponding definitions of the
;; procedures cons, car, and cdr.

(ns sicp-mailonline.exercises.2-5)

(def ^:private ^:const a-base 2)
(def ^:private ^:const b-base 3)

(defn- count-repeated-noremainder-division [value divisor]
  (letfn [(iter [n count]
            (if (zero? (rem n divisor))
              (recur (/ n divisor) (inc count))
              count))]
    (iter value 0)))

(defn cons [a b]
  (* (Math/pow a-base a)
     (Math/pow b-base b)))

(defn car [pair]
  (count-repeated-noremainder-division pair a-base))

(defn cdr [pair]
  (count-repeated-noremainder-division pair b-base))
