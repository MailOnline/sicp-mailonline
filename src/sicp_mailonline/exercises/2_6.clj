(ns sicp-mailonline.exercises.2-6)

(def zero (fn [f] (fn [x] x)))

(defn add-1 [n]
  (fn [f] (fn [x] (f ((n f) x)))))

;; replacing zero in add-1 we get "one"
; (defn one []
;   (fn [f] (fn [x] (f (((fn [f] (fn [x] x)) f) x)))))

;; noticing that wrapping function in the middle
;; will be always returning (fn [x] x) for any argument f
;; ((fn [f] (fn [x] x)) f) => (fn [x] x)
; so:
; (defn one []
;   (fn [f] (fn [x] (f ((fn [x] x) x)))))

;; now ((fn [x] x) x) => x
(defn one []
  (fn [f] (fn [x] (f x))))

;; now replacing n in add-1 with our brand new one
; (defn two []
;   (fn [f] (fn [x] (f (((fn [f] (fn [x] (f x))) f) x)))))

;; similarly noticing that a wrapping (fn [f] is passing-in and invoking-on "f"
;; so I can apply the sibstitution:
; ((fn [f] (fn [x] (f x))) f) => (fn [x] (f x))
; (defn two []
;   (fn [f] (fn [x] (f ((fn [x] (f x)) x)))))

;; but then again, wrapping fn [x] can be replaced:
; ((fn [x] (f x)) x) => (f x)
; finally getting:

(defn two []
  (fn [f] (fn [x] (f (f x)))))
