;; Example 2.3.1 Quotation

(ns sicp-mailonline.examples.2-3-1)

(defn memq [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (recur item (rest x))))
