;; Exercise 2.1
;; Define a better version of make-rat that handles both positive and negative
;; arguments.  Make-rat should normalize the sign so that if the rational number
;; is positive, both the numerator and denominator are positive, and if the
;; rational number number is negative, only the numerator is negative.

(ns sicp-mailonline.exercises.2-1)

(defn- gcd [a b]
  (if (zero? b)
    a
    (recur b (rem a b))))

(defn- reduce-terms [n d]
  (let [g (gcd (Math/abs n) (Math/abs d))]
    (vector (/ n g) (/ d g))))

(defn make-rat [n d]
  (cond (and (neg? n) (neg? d)) (reduce-terms (Math/abs n) (Math/abs d))
        (or (neg? n) (neg? d)) (reduce-terms (- (Math/abs n)) (Math/abs d))
        :else (reduce-terms n d)))
