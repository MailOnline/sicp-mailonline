;; Exercise 2.64
;; The following procedure list->tree converts an ordered list to a balanced
;; binary tree.  The helper procedure partial-tree takes as arguments an integer
;; n and list of at least n elements and constructs a balanced tree containing
;; the first n elements of the list.  The result returned by partial-tree is a
;; pair (formed with cons) whose car is the constructed tree and whose cdr is
;; the list of elements not included in the tree.
;;
;; (define (list->tree elements)
;;   (car (partial-tree elements (length elements))))
;;
;; (define (partial-tree elts n)
;;   (if (= n 0)
;;     (cons '() elts)
;;     (let ((left-size (quotient (- n 1) 2)))
;;       (let ((left-result (partial-tree elts left-size)))
;;         (let ((left-tree (car left-result))
;;               (non-left-elts (cdr left-result))
;;               (right-size (- n (+ left-size 1))))
;;           (let ((this-entry (car non-left-elts))
;;                 (right-result (partial-tree (cdr non-left-elts) right-size)))
;;             (let ((right-tree (car right-result))
;;                   (remaining-elts (cdr right-result)))
;;               (cons (make-tree this-entry left-tree right-tree)
;;                     remaining-elts))))))))
;;
;; a.  Write a short paragraph explaining as clearly as you can how partial-tree
;; works.  Draw the tree produced by list->tree for the list (1 3 5 7 9 11).
;;
;; b.  What is the order of growth in the number of steps required by list->tree
;; to convert a list of n elements?

;; a)
;; A perfectly balanced tree has a root node, and then (n-1) child nodes evenly
;; distributed across the left & right branches.  As the input list is ordered,
;; the first (n-1)/2 elements form the left branch of the root node, the next
;; element forms the root node itself, and the remaining elements form the right
;; branch of the root node.
;; The algorithm is recursive, calling itself once to create the left branch,
;; and again to create the right branch, of the current entry.  When the size of
;; the target tree is zero, the algorithm simply returns a pair consisting of
;; the empty tree, with all of the supplied elements in the "not included in the
;; tree" slot.
;;
;; The tree produced by list->tree for the list (1 3 5 7 9 11) is:
;; (5 (1 () (3 () ())) (9 (7 () ()) (11 () ())))
;; 
;;        5
;;      /   \
;;     1     9
;;      \   / \
;;       3 7  11
;;
;; A detailed trace of the procedure is listed below.

;; b)
;; The order of growth is O(n).


;; detailed trace
;; --------------
;; [a] (1 3 5 7 9 11) n=6
;; left-size: 2
;; left-result: [b] (1 3 5 7 9 11) n=2 -> ((1 () (3 () ()) (5 7 9 11))
;; left-tree: (1 () (3 () ())
;; non-left-elts: (5 7 9 11)
;; right-size: 3
;; this-entry: 5
;; right-result: [c] (7 9 11) n=3 -> ((9 (7 () ()) (11 () ())) ())
;; right-tree: (9 (7 () ()) (11 () ()))
;; remaining-elts: ()
;; -> ((5 (1 () (3 () ())) (9 (7 () ()) (11 () ()))) ())
;;
;; [b] (1 3 5 7 9 11) n=2
;; left-size: 0
;; left-result: [d] (1 3 5 7 9 11) n=0 -> (() (1 3 5 7 9 11))
;; left-tree: ()
;; non-left-elts: (1 3 5 7 9 11)
;; right-size: 1
;; this-entry: 1
;; right-result: [e] (3 5 7 9 11) 1 -> (((3 () ())) (5 7 9 11))
;; right-tree: (3 () ())
;; remaininhg-elts: (5 7 9 11)
;; -> ((1 () (3 () ()) (5 7 9 11))
;;
;; [c] (7 9 11) n=3
;; left-size: 1
;; left-result: [f] (7 9 11) n=1 -> ((7 () ()) (9 11))
;; left-tree: (7 () ())
;; non-left-elts: (9 11)
;; right-size: 1
;; this-entry: 9
;; right-result: [g] (11) n=1 -> ((11 () ()) ())
;; right-tree: (11 () ())
;; remaining-elts: ()
;; -> ((9 (7 () ()) (11 () ())) ())
;;
;; [d] (1 3 5 7 9 11) n=0
;; -> (() (1 3 5 7 9 11)
;;
;; [e] (3 5 7 9 11) n=1
;; left-size: 0
;; left-result: (3 5 7 9 11) n=0 -> (() (3 5 7 9 11))
;; left-tree: ()
;; non-left-elts: (3 5 7 9 11)
;; right-size: 0
;; this-entry: 3
;; right-result: (5 7 9 11) n=0 -> (() (5 7 9 11))
;; right-tree: ()
;; remaining-elts: (5 7 9 11)
;; -> ((3 () ()) (5 7 9 11))
;;
;; [f] (7 9 11) n=1
;; left-size: 0
;; left-result: (7 9 11) n=0 -> (() (7 9 11))
;; left-tree: ()
;; non-left-elts: (7 9 11)
;; right-size: 0
;; this-entry: 7
;; right-result: (9 11) n=0 -> (() (9 11))
;; right-tree: ()
;; remaining-elts: (9 11)
;; -> ((7 () ()) (9 11))
;;
;; [g] (11) n=1
;; left-size: 0
;; left-result: (11) n=0 -> (() (11))
;; left-tree: ()
;; non-left-elts: (11)
;; right-size: 0
;; this-entry: 11
;; right-result: () n=0 -> (() ())
;; right-tree: ()
;; remaining-elts: ()
;; -> ((11 () ()) ())
