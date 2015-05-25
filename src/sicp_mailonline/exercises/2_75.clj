;; Exercise 2.75
;; Implement the constructor make-from-mag-ang in message-passsing style.  This
;; procedure should be analogous to the make-from-real-imag procedure given
;; above.

(ns sicp-mailonline.exercises.2-75)

(defn make-from-mag-ang [r a]
  (letfn [(dispatch [op]
            (cond (= op 'magnitude) r
                  (= op 'angle) a
                  (= op 'real-part) (* r (Math/cos a))
                  (= op 'imag-part) (* r (Math/sin a))
                  :else (throw (IllegalArgumentException.
                                (format "Unknown op -- MAKE-FROM-MAG-ANG %s"
                                        op)))))]
    (dispatch)))
