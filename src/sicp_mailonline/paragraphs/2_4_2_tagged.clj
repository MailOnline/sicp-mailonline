(ns sicp-mailonline.paragraphs.2-4-2-tagged
  (:require [sicp-mailonline.paragraphs.2-4-complex :refer [sqrt square cos sin atan]]))

(defn pair? [datum]
  "Assuming vectors of 3 elements, conj-ing
  the tag at the end of the vector."
  (and
    (= 3 (count datum))
    (symbol? (last datum))))

(defn error [msg data]
  (throw (RuntimeException. (str msg " " data))))

(defn attach-tag [type-tag contents]
  "Tag is attached to the end of the vector."
  (conj contents type-tag))

(defn type-tag [[x y tag :as datum]]
  (if (pair? datum)
    (last datum)
    (error "Bad tagged datum - TYPE-TAG" datum)))

(defn contents [[x y tag :as datum]]
  (if (pair? datum)
    [x y]
    (error "Bad tagged datum - CONTENTS" datum)))

(defn rectangular? [z]
  (= (type-tag z) 'rectangular))

(defn polar? [z]
  (= (type-tag z) 'polar))

(defn make-from-real-imag-rectangular [x y]
  (attach-tag 'rectangular [x y]))

(defn make-from-mag-ang-rectangular [r a]
  (attach-tag 'rectangular [(* r (cos a)) (* r (sin a))]))

(defn make-from-real-imag-polar [x y]
  (attach-tag 'polar [(sqrt (+ (square x) (square y))) (atan y x)]))

(defn make-from-mag-ang-polar [r a]
  (attach-tag 'polar [r a]))
