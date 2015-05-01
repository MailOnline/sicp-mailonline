(ns sicp-mailonline.paragraphs.2-3-4)

(defn make-leaf [symbol weight]
     (list 'leaf symbol weight))

(defn leaf? [object]
  (= (first object) 'leaf))

(defn symbol-leaf [x] (nth x 1))
(defn weight-leaf [x] (nth x 2))

(defn left-branch [tree] (first tree))
(defn right-branch [tree] (second tree))

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

(defn choose-branch [bit branch]
  (cond
    (= bit 0) (left-branch branch)
    (= bit 1) (right-branch branch)
    :else (throw (RuntimeException. (format "bad bit '%s' CHOOSE-BRANCH" bit)))))

(defn decode [bits tree]
  (letfn [(decode-1 [[bit & bits] current-branch]
            (if (nil? bit)
              '()
              (let [next-branch (choose-branch bit current-branch)]
                (if (leaf? next-branch)
                  (cons (symbol-leaf next-branch) (decode-1 bits tree)) ; cons symbol and recur from top
                  (decode-1 bits next-branch)))))] ; recur from current
    (decode-1 bits tree)))
