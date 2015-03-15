;; Exercise 2.42
;; The "eight-queens puzzle" asks how to place eight queens on a chessboard so
;; that no queen is in check from any other (i.e. no two queens are in the same
;; row, column, or diagonal).  One possible solution is shown in figure 2.8.
;;
;; 8           Q
;; 7     Q
;; 6 Q
;; 5             Q
;; 4         Q
;; 3               Q
;; 2   Q
;; 1       Q
;;   a b c d e f g h
;;
;; One way to solve the puzzle is to work across the board, placing a queen in
;; each column.  Once we have placed k-1 queens, we must place the kth queen in
;; a position where it does not check any of the queens already on the board.
;; We can formulate this approach recursively: Assume that we have already
;; generated the sequence of all possible ways to place k-1 queens in the first
;; k-1 columns of the board.  For each of these ways, generate an extended set
;; of positions by placing a queen in each row of the kth column.  Now filter
;; these, keeping only the positions for which the queen in the kth column is
;; safe with respect to the other queens.  This produces the sequence of all
;; ways to place k queens in the first k columns.  By continuing this process,
;; we will produce not only one solution, but all solutions to the puzzle.
;; We implement this solution as a procedure queens, which returns a sequence
;; of all solutions to the problem of placing n queens on an n x n chessboard.
;; Queens has an internal procedure queen-cols that returns the sequence of all
;; ways to place queens in the first k columns of the board.
;;
;; (define (queens board-size)
;;   (define (queen-cols k)
;;     (if (= k 0)
;;       (list empty-board)
;;       (filter
;;        (lambda (positions) (safe? k positions))
;;        (flatmap
;;         (lambda (rest-of-queens)
;;                 (map (lambda (new-row)
;;                              (adjoin-position new-row k rest-of-queens))
;;                      (enumerate-interval 1 board-size)))
;;         (queen-cols (- k 1))))))
;;   (queen-cols board-size))
;;
;; In this procedure rest-of-queens is a way to place k-1 queens in the first
;; k-1 columns, and new-row is a proposed row in which to place the queen for
;; the kth column.  Complete the program by implementing the representation
;; for sets of board positions, including the procedure adjoin-position, which
;; adjoins a new row-column position to a set of positions, and empty-board,
;; which represents an empty set of positions.  You must also write the
;; procedure safe?, which determines for a set of positions, whether the queen
;; in the kth column is safe with respect to the others.  (Note that we need
;; only check whether the new queen is safe - the other queens are already
;; guaranteed safe with respect to each other).

(ns sicp-mailonline.exercises.2-42
  (:require [sicp-mailonline.examples.2-2-3 :refer :all]))

(def ^:private ^:const empty-board '())

(defn- position [col row]
  (list col row))

(defn- column [position]
  (first position))

(defn- row [position]
  (last position))

(defn- adjoin-position [row column positions]
  (cons (position column row) positions))

;; Note: we generate the board in such a way that the column check is actually
;; unnecessary - but this procedure doesn't need to know that
(defn- in-check? [queen1 queen2]
  (letfn [(same-diagonal? [queen1 queen2]
            (= (Math/abs (- (column queen1) (column queen2)))
               (Math/abs (- (row queen1) (row queen2)))))]
    (or (= (column queen1) (column queen2))
        (= (row queen1) (row queen2))
        (same-diagonal? queen1 queen2))))

(defn- safe? [col positions]
  (let [col-queen (first (filter (fn [pos] (= (column pos) col)) positions))
        other-queens (filter (fn [pos] (not= (column pos) col)) positions)]
    (empty? (filter (fn [queen] (in-check? col-queen queen))
                    other-queens))))

(defn queens
  "returns all solutions to the problem of placing n queens on an n x n chessboard"
  [n]
  (letfn [(queen-cols [k]
            (if (zero? k)
              (list empty-board)
              (filter (fn [positions] (safe? k positions))
                      (flatmap (fn [rest-of-queens]
                                 (map (fn [new-row] (adjoin-position new-row k rest-of-queens))
                                      (enumerate-interval 1 n)))
                               (queen-cols (dec k))))))]
    (queen-cols n)))

;; On my machine this solution stack overflows at n=10
