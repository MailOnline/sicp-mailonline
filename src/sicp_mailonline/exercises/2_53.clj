(ns sicp-mailonline.exercises.2-53)

(defn memq [item [head & others :as orig]]
  (cond (empty? orig) false
        (= item head) orig
        :else (memq item others)))
