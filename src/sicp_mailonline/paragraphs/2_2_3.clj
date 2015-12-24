(ns sicp-mailonline.paragraphs.2-2-3
  (:require [sicp-mailonline.paragraphs.2-2-1 :refer [s-map]]))

;
; 2.2.3 Sequences as Conventional Interfaces
;

(def square #(* % %))

(defn sum-odd-squares [tree]
  (cond
    (nil? tree)         0
    (not (coll? tree))  (if (odd? tree) (square tree) 0)
    (empty? tree)       0
    :else               (+ (sum-odd-squares (first tree))
                          (sum-odd-squares (rest tree)))))

(println (sum-odd-squares '(1 2 (3 4) 5 6)))

(defn fib[n] 
  (condp = n 
    0     0
    1     1
    (+ (fib (- n 1)) (fib (- n 2)))))


(defn even-fibs [n]
  (letfn [(next [k]
            (if (> k n)
              nil
              (let [f (fib k)]
                (if (even? f)
                  (cons f (next (inc k)))
                  (recur (inc k)))
                )))]
    (next 0)))

(println (even-fibs 10))


;
; Sequence operations
;

(println  (->> (list 1 2 3 4 5) (s-map square)))

(defn s-filter [predicate sequence]
  (cond (empty? sequence)               nil
        (predicate (first sequence))    (cons (first sequence) (filter predicate (rest sequence)))
         :else                          (recur predicate (rest sequence))))


(defn s-accumulate [op initial sequence]
  (if (empty? sequence)
      initial
      (op (first sequence)
           (s-accumulate op initial (rest sequence)))))

(println (s-accumulate + 0 (list 1 2 3 4 5)))

(println (s-accumulate * 1 (list 1 2 3 4 5)))

(println (s-accumulate cons nil (list 1 2 3 4 5)))

(defn enumerate-interval [low high]
  (if (> low high)
    nil
    (cons low (enumerate-interval (inc low) high))))

(println (enumerate-interval 2 7))

(defn enumerate-tree [tree]
  (cond 
    (nil? tree)           nil
    (not (coll? tree))    (list tree)
    (empty? tree)         nil
    :else                 (concat 
                            (enumerate-tree (first tree))
                            (enumerate-tree (rest tree)))))
(println (enumerate-tree '(1 (2 (3 4) 5))))


(defn sum-odd-squares [tree]
  (->> (enumerate-tree tree)
       (s-filter odd?)
       (s-map square)
       (s-accumulate + 0)))

(println (sum-odd-squares '(1 2 (3 4) 5 6)))

(defn even-fibs [n]
  (->> (enumerate-interval 0 n)
       (s-map fib)
       (s-filter even?)
       (s-accumulate cons nil)))

(println (even-fibs 10))

(defn list-fib-squares [n]
  (->> (enumerate-interval 0 n)
       (s-map fib)
       (s-map square)
       (s-accumulate cons nil)))

(println (list-fib-squares 10))


(defn product-of-squares-of-odd-elements [sequence]
  (->> sequence
       (s-filter odd?)
       (s-map square)
       (s-accumulate * 1)))

(println (-> '(1 2 3 4 5) product-of-squares-of-odd-elements))


(defn programmer? [e]
  (= (:job-title e) :programmer)) 

(defn salary [e]
  (:salary e))

(defn salary-highest-paid-programmer [records]
  (->> records
       (s-filter programmer?)
       (s-map salary)
       (s-accumulate max 0)))

(def employees [{ :name "Bob"   :job-title :programmer :salary 2 }
                { :name "Mike"  :job-title :programmer :salary 5 } 
                { :name "Randy" :job-title :manager    :salary 10}])

(println (str "Salary " (salary-highest-paid-programmer employees)))


;
; Nested mappings
;
(defn enumerate-pairs [n]
  (->> 
    (enumerate-interval 1 n)
    (s-map (fn [i]
      (->> (enumerate-interval 1 (dec i))
           (s-map (fn [j] (list i j))))))
    (s-accumulate concat nil)))

(println (enumerate-pairs 5))

(defn s-flatmap [proc seq]
  (->>
    seq
    (s-map proc)
    (s-accumulate concat nil)))


(defn enumerate-pairs [n]
  (->> 
    (enumerate-interval 1 n)
    (s-flatmap (fn [i]
      (->> (enumerate-interval 1 (dec i))
           (s-map (fn [j] (list i j))))))))

(println (enumerate-pairs 5))

(defn prime? [n]
  "Reasonably efficent for a naive implementation. Only checks factors 
  up to the square root and uses lazy sequences to fail fast."
  (->> 
    (range 2 (inc (Math/round (Math/pow n 0.5))))
    (every? (fn [i] (not= (mod n i) 0)))))

(defn prime-sum? [pair]
  (->> pair (apply +) prime?))

(defn make-pair-sum [pair]
  (->> pair (apply +) list (concat pair)))

(defn prime-sum-pairs [n]
 (->> 
    (enumerate-interval 1 n)
    (s-flatmap (fn [i]
      (->> (enumerate-interval 1 (dec i))
           (s-map (fn [j] [i j])))))
    (s-filter prime-sum?)
    (s-map make-pair-sum)))

(println "Prime sum pairs")
(println (prime-sum-pairs 6))


(defn s-remove [item sequence]
  (->> sequence (s-filter #(not= % item))))

(defn permutations [s]
  (if (empty? s)
    (list nil)
      (->> s
           (s-flatmap (fn [x]
              (->>
                s
                (s-remove x)
                permutations
                (map #(cons x %))))))))

(println "Permutations")
(println (permutations (list 1 2 3)))




