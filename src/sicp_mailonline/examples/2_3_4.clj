;; Example 2.3.4: Huffman Encoding Trees

(ns sicp-mailonline.examples.2-3-4)

(defn make-leaf [symbol weight]
  (list :leaf symbol weight))

(defn leaf? [object]
  (= (first object) :leaf))

(defn symbol-leaf [x]
  (second x))

(defn weight-leaf [x]
  (nth x 2))

(defn left-branch [tree]
  (first tree))

(defn right-branch [tree]
  (second tree))

(defn symbols [tree]
  (if (leaf? tree)
    (list (symbol-leaf tree))
    (nth tree 2)))

(defn weight [tree]
  (if (leaf? tree)
    (weight-leaf tree)
    (nth tree 3)))

(defn make-code-tree [left right]
  (list left
        right
        (concat (symbols left) (symbols right))
        (+ (weight left) (weight right))))

(defn- choose-branch [bit branch]
  (cond (zero? bit) (left-branch branch)
        (= bit 1) (right-branch branch)
        :else (throw (IllegalArgumentException.
                      (str "bad bit -- CHOOSE-BRANCH " bit)))))

(defn decode [bits tree]
  (letfn [(decode-1 [bits current-branch]
            (if (empty? bits)
              '()
              (let [next-branch (choose-branch (first bits) current-branch)]
                (if (leaf? next-branch)
                  (cons (symbol-leaf next-branch) (decode-1 (rest bits) tree))
                  (recur (rest bits) next-branch)))))]
    (decode-1 bits tree)))

(defn adjoin-set [x set]
  (cond (empty? set) (list x)
        (< (weight x) (weight (first set))) (cons x set)
        :else (cons (first set) (adjoin-set x (rest set)))))

(defn make-leaf-set [pairs]
  (if (empty? pairs)
    '()
    (let [pair (first pairs)]
      (adjoin-set (make-leaf (first pair)        ; symbol
                             (second pair))      ; frequency
                  (make-leaf-set (rest pairs))))))
