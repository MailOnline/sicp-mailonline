(ns sicp-mailonline.exercises.3-13)

(defn last-pair [x]
  (if (nil? (.cdr x))
    x
    (last-pair (.cdr x))))

(defn make-cycle [x]
  (.setcdr (last-pair x) x)
  x)
