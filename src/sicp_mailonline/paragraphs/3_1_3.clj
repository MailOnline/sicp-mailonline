;
; Paragraph 3.1.3
;
(ns sicp-mailonline.paragraphs.3-1-3)

(defn make-simplified-withdraw[init-balance]
  (let [balance (atom init-balance)]
    (fn [amount]
      (swap! balance #(- % amount)))))

(println "Make simplified withdraw")

(def w (make-simplified-withdraw 25))

(println (w 20))
(println (w 10))




(defn make-decrementer [balance]
  (fn [amount]
      (- balance amount)))

(println "Make decrementer")

(def D (make-decrementer 25))

(println (D 20))

(println (D 10))

(println  "W1 and W2 have different effects")

(def W1 (make-simplified-withdraw 25))
(def W2 (make-simplified-withdraw 25))

(println (W1 20))
(println (W1 20))
(println (W2 20))


(defn factorial [n]
  (let [product (atom 1)
        counter (atom 1)]

        (letfn [(iter [] 
          (if (> @counter n)
            @product
            (do 
              (swap! product #(* % @counter))
              (swap! counter inc)
              (recur))))]
          
          (iter))))


