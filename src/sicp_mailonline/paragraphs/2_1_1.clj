;
; Paragraph 2.1.1
;
(ns sicp-mailonline.paragraphs.2-1-1)

(defn make-rat [n d]
  (list n d))

(defn numer [x]
  (first x))

(defn denom [x]
  (first (rest x)))

(defn print-rat [x]
  (println (numer x) "/" (denom x)))

(def one-half (make-rat 1 2))

(print-rat one-half)
