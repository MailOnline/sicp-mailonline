;; Exercise 2.11
;; In passing, Ben also cryptically comments: "By testing the signs of the
;; end-points of the intervals, it is possible to break mul-interval into nine
;; cases, only one of which requires more than two multiplications."  Rewrite
;; this procedure using Ben's suggestion.

(ns sicp-mailonline.exercises.2-11
  (:require [sicp-mailonline.exercises.2-7 :refer [make-interval lower-bound upper-bound]]))

;; xl xu    yl yu      l                 u
;; ====================================================
;; -  -     -  -     xu*yu             xl*yl
;; -  -     -  +     xl*yu             xl*yl
;; -  -     +  +     xl*yu             xu*yl
;; -  +     -  -     xu*yl             xl*yl
;; -  +     -  +     min(xl*yu xu*yl)  min(xl*yl xu*yu)
;; -  +     +  +     xl*yu             xu*yu
;; +  +     -  -     xu*yl             xl*yu
;; +  +     -  +     xu*yl             xu*yu
;; +  +     +  +     xl*yl             xu*yu

(defn mul-interval [x y]
  (let [xl (lower-bound x)
        xu (upper-bound x)
        yl (lower-bound y)
        yu (upper-bound y)]
    (cond (and (neg? xl) (neg? xu) (neg? yl) (neg? yu)) (make-interval (* xu yu) (* xl yl))
          (and (neg? xl) (neg? xu) (neg? yl)) (make-interval (* xl yu) (* xl yl))
          (and (neg? xl) (neg? yl) (neg? yu)) (make-interval (* xu yl) (* xl yl))
          (and (neg? xl) (neg? xu)) (make-interval (* xl yu) (* xu yl))
          (and (neg? xl) (neg? yl)) (make-interval (Math/min (* xl yu) (* xu yl))
                                                   (Math/min (* xl yl) (* xu yu)))
          (and (neg? yl) (neg? yu)) (make-interval (* xu yl) (* xl yu))
          (neg? xl) (make-interval (* xl yu) (* xu yu))
          (neg? yl) (make-interval (* xu yl) (* xu yu))
          :else (make-interval (* xl yl) (* xu yu)))))
