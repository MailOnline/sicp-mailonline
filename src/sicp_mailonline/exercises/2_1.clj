(ns sicp-mailonline.exercises.2-1
  (:require [sicp-mailonline.paragraphs.2-1-1 :as common]))

(defn make-rat-negs [n d]
  (let [rat (common/make-rat (Math/abs n) (Math/abs d))]
    (if (neg? n)
      (cons (- (common/numer rat)) (rest rat))
      rat)))
