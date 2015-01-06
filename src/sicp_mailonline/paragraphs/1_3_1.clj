(ns sicp-mailonline.paragraphs.1-3-1)

(defn cube [x] (* x x x))

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(defn sum-integers [a b]
  (sum identity a inc b))

(defn sum-cubes [a b]
  (sum cube a inc b))

(defn pi-sum [a b]
  (let [pi-term #(/ 1.0 (* % (+ % 2)))
        pi-next #(+ % 4)]
    (sum pi-term a pi-next b)))

(defn integral [f a b dx]
  (letfn [(add-dx [x] (+ x dx))]
    (* (sum f (+ a (/ dx 2.0)) add-dx b) dx)))
