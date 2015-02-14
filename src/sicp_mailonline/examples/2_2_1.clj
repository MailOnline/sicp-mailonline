;; 2.2.1 Mapping over lists

(ns sicp-mailonline.examples.2-2-1)

(defn map [proc items]
  (if (empty? items)
    '()
    (cons (proc (first items))
          (map proc (rest items)))))

(defn scale-list [items factor]
  (map (fn [x] (* x factor)) items))

(defn list-ref [items n]
  (if (zero? n)
    (first items)
    (recur (rest items) (dec n))))

(defn length [items]
  (if (empty? items)
    0
    (+ 1 (length (rest items)))))

(defn append [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (append (rest list1) list2))))
