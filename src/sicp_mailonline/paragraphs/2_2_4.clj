(ns sicp-mailonline.paragraphs.2-2-4
  (:require [sicp-mailonline.hpl :refer :all]))

(defn show [painter]
  (show-picture painter 400 400))


(show rogers)

(show wave 400 400)

(show wave2 400 400)

(show wave4 400 400)



; Alternative method for defining wave4 painter



(with-redefs [wave4 (flipped-pairs wave)]
  (show wave4))

(show (right-split wave 4))

(show (right-split rogers 4))


(show (corner-split wave 4))

(show (corner-split rogers 4))

(show (square-limit wave 4))

(show (square-limit rogers 4))


(with-redefs [flipped-pairs (fn [painter]
                               (let [combine4 (square-of-four
                                                identity
                                                flip-vert
                                                identity
                                                flip-vert)]
                                 (combine4 painter))
                               ) ]
  (show (flipped-pairs wave)))


(with-redefs [square-limit (fn [painter n]
                             (let [combine4 (square-of-four
                                              flip-horiz
                                              identity
                                              rotate180
                                              flip-vert)]
                               (combine4 (corner-split painter n)))
                             ) ]

(show (square-limit wave 4)))


(show (shrink-to-upper-right wave))

(show (squash-inwards wave))

