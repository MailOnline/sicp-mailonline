;
; Paragraph 3.2.2
;
(ns sicp-mailonline.paragraphs.3-2-2)

(defn square [x] (* x x))

(defn sum-of-squares [x y] (+ (square x) (square y)))

(defn f [a] (sum-of-squares (inc a) (* a 2)))
