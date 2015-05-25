;; Example 2.4.3 - message passing

(defn- square [x]
  (* x x))

(defn make-from-real-imag [x y]
  (letfn [(dispatch [op]
            (cond (= op 'real-part) x
                  (= op 'imag-part) y
                  (= op 'magnitude) (Math/sqrt (+ (square x)
                                                  (square y)))
                  (= op 'angle) (Math/atan2 y x)
                  :else (throw (IllegalArgumentException.
                                (format "Unknown op -- MAKE-FROM-REAL-IMAG %s" op)))))]
    dispatch))

(defn apply-generic [op arg]
  (arg op))
