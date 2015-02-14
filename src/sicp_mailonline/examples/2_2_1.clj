;; 2.2.1 Mapping over lists

(ns sicp-mailonline.examples.2-2-1)

(defn map [proc items]
  (if (empty? items)
    '()
    (cons (proc (first items))
          (map proc (rest items)))))

(defn scale-list [items factor]
  (map (fn [x] (* x factor)) items))
