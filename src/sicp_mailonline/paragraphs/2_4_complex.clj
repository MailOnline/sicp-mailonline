(ns sicp-mailonline.paragraphs.2-4-complex
  (:import [java.lang Math]))

(defn atan [x y] (Math/tan (/ x y)))
(defn sin [x] (Math/sin x))
(defn cos [x] (Math/cos x))
(defn sqrt [x] (Math/sqrt x))
(defn square [x] (* x x))

(defn real-part [[x y]] x)
(defn imag-part [[x y]] y)

(defn make-from-real-imag [x y] [x y])
(defn make-from-mag-ang [r a] [(* r (cos a)) (* r (sin a))])

(defn magnitude [z] (sqrt (+ (square (real-part z)) (square (imag-part z)))))
(defn angle [z] (atan (imag-part z) (real-part z)))

(defn magnitude2 [[r a]] r)
(defn angle2 [[r a]] a)
(defn real-part2 [z] (* (magnitude2 z) (cos (angle2 z))))
(defn imag-part2 [z] (* (magnitude2 z) (sin (angle2 z))))
(defn make-from-real-imag2 [x y] [(sqrt (+ (square x) (square y))) (atan y x)])
(defn make-from-mag-ang2 [r a] [r a])
