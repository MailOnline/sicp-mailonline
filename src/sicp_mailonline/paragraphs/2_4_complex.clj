(ns sicp-mailonline.paragraphs.2-4-complex
  (:import [java.lang Math]))

(defn atan [x y] (Math/tan (/ x y)))
(defn sin [x] (Math/sin x))
(defn cos [x] (Math/cos x))
(defn sqrt [x] (Math/sqrt x))
(defn square [x] (* x x))

(defn real-part-rectangular [[x y]] x)
(defn imag-part-rectangular [[x y]] y)

(defn make-from-real-imag-rectangular [x y] [x y])
(defn make-from-mag-ang-rectangular [r a] [(* r (cos a)) (* r (sin a))])

(defn magnitude-rectangular [z] (sqrt (+ (square (real-part-rectangular z)) (square (imag-part-rectangular z)))))
(defn angle-rectangular [z] (atan (imag-part-rectangular z) (real-part-rectangular z)))

(defn magnitude-polar [[r a]] r)
(defn angle-polar [[r a]] a)
(defn real-part-polar [z] (* (magnitude-polar z) (cos (angle-polar z))))
(defn imag-part-polar [z] (* (magnitude-polar z) (sin (angle-polar z))))
(defn make-from-real-imag-polar [x y] [(sqrt (+ (square x) (square y))) (atan y x)])
(defn make-from-mag-ang-polar [r a] [r a])
