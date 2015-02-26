(ns sicp-mailonline.core)

; 
; Exercise 2.7 - 2.16
;

;
; Exercise 2.7
;

; lower, then upper
(defn make-interval [a b]
  (list a b))

(defn lower-bound [interval]
  (first interval))

(defn upper-bound [interval]
  (first (rest interval)))

(defn add-interval [x y]
  (make-interval 
    (+ (lower-bound x) (lower-bound y))
    (+ (upper-bound x) (upper-bound y))))

(defn mul-interval [x y]
  (let [
    p1 (* (lower-bound x) (lower-bound y))
    p2 (* (lower-bound x) (upper-bound y))
    p3 (* (upper-bound x) (lower-bound y))
    p4 (* (upper-bound x) (upper-bound y))
    ]
    (make-interval 
      (min p1 p2 p3 p4)
      (max p1 p2 p3 p4))))

;
; Exercise 2.8
;

(defn subtract-interval [x y]
  (make-interval 
    (- (lower-bound x) (upper-bound y))
    (- (upper-bound x) (lower-bound y))))

;
; Exercise 2.9
;

; width([a, b]) =  0.5 * (b - a) 
;
; For addition
;
;     width([a, b] + [c, d])
; =   width([a+c], [b+d])
; =   0.5 * (b+d -a -c)
; =   0.5 * (b - a) + 0.5 * (d - c)
; =   width([a, b]) + width([c, d])
;
; Counter example not true for multiplication
;
;   [-1, 1] * [0, 1]  = [-1, 1]
;
;  width([-1, 1]) = 1
;  width([0, 1])  = 0.5
;  width ([-1, 1]) = 1
;  So width([-1, 1] * width([0, 1]) = 1 * 0.5 = 0.5
;  width([-1, 1]) = 1 
;
(defn width [interval]
  (/  (- (upper-bound interval) 
        (lower-bound interval)) 
      2))

;
; With exercise 2.10 changes
;

(defn div-interval [x y]
  (let [  yl (lower-bound y)
          yu (upper-bound y)]
    (if
      (and 
        (<= yl 0)      
        (>= yu 0))
      "Cannot divide by zero"
      (mul-interval 
        x 
        (make-interval
          (/ 1.0 yu)
          (/ 1.0 yl))))))


;
; Exercise 2.11
;

; A = [al, ah] B = [bl, bh]
; + suffix means number is +ve, - suffix the number is negative

;1  al+, ah+, bl+, bh+ -> AB = [albl, ahbh] 
;2  al+, ah+, bl+, bh- -> AB = [ahbh, ahbl]
;3  al+, ah+, bl-, bh+ -> AB = [ahbl, ahbh]
;4  al+, ah+, bl-, bh- -> AB = [ahbl, albh]

;4  al+, ah-, bl+, bh+ -> AB = [ahbl, albh]
;5  al+, ah-, bl+, bh- -> AB = [min(albh, ahbl), ahbh]   - 3 multiplications
;6  al+, ah-, bl-, bh+ -> AB = [albl, max(albh, ahbl)]   - 3 multiplications
;7  al+, ah-, bl-, bh- -> AB = [albl, ahbl]              

;8  al-, ah+, bl+, bh+ -> AB = [albh, ahbh]
;6  al-, ah+, bl+, bh- -> AB = [albl, max(albh, ahbl)]   
;9  al-, ah+, bl-, bh+ -> AB = [min(albh, ahbl), max(ahbh, albl)] - 4 multiplications
;10  al-, ah+, bl-, bh- -> AB = [ahbl, albl]           

;11 al-, ah-, bl+, bh+ -> AB = [albh, ahbl]
;1  al-, ah-, bl+, bh- -> AB = [albl, ahbh]
;12 al-, ah-, bl-, bh+ -> AB = [albh, albl]
;13 al-, ah-, bl-, bh- -> AB = [ahbh, albl]

;
; According to SICP it is possible to break multiplication into 9 cases
; only one of which requires more than two multiplications.
;
; I make it 13 cases - of which 2 require 3 multiplications and one requires
; 4 multiplications. Four cases could be collapsed on to one to match SICP
; but this defeats the purpose.
;

(defn mul-interval-opt [a b]
  (let [al (lower-bound a)
        ah (upper-bound a)
        bl (lower-bound b)
        bh (upper-bound b)]

    (cond
      ; Case 1
      (or
        (and (>= al 0) (>= ah 0) (>= bl 0)(>= bh 0))
        (and (<= al 0) (<= ah 0) (>= bl 0)(<= bh 0)))
      (make-interval (* al bl) (* ah bh))

      ; Case 2
      (and (>= al 0) (>= ah 0) (>= bl 0)(<= bh 0))
      (make-interval (* ah bh) (* ah bl))

      ; Case 3
      (and (>= al 0) (>= ah 0) (<= bl 0)(>= bh 0))
      ;(println "case 3")
      (make-interval (* ah bl) (* ah bh))

      ; Case 4
      (or
       (and (>= al 0) (>= ah 0) (<= bl 0)(<= bh 0))
       (and (>= al 0) (<= ah 0) (>= bl 0)(>= bh 0)))
      (make-interval (* ah bl) (* al bh))

      ; Case 5
      (and (>= al 0) (<= ah 0) (>= bl 0)(<= bh 0))
      (make-interval (min (* al bh) (* ah bl)) (* ah bh))

      ; Case 6
      (or
        (and (>= al 0) (<= ah 0) (<= bl 0)(>= bh 0))
        (and (<= al 0) (>= ah 0) (>= bl 0)(<= bh 0)))
      (make-interval (* al bl) (max (* al bh) (* ah bl)))

      ; Case 7
      (and (>= al 0) (<= ah 0) (<= bl 0)(<= bh 0))
      (make-interval (* al bl) (* ah bl))

      ; Case 8
      (and (<= al 0) (>= ah 0) (>= bl 0)(>= bh 0))
      (make-interval (* al bh) (* ah bh))

      ; Case 9
      (and (<= al 0) (>= ah 0) (<= bl 0)(>= bh 0))
      (make-interval (min (* al bh) (* ah bl)) (max (* ah bh) (* al bl)))

      ; Case 10
      (and (<= al 0) (>= ah 0) (<= bl 0)(<= bh 0))
      (make-interval (* ah bl) (* al bl))

      ; Case 11
      (and (<= al 0) (<= ah 0) (>= bl 0)(>= bh 0))
      (make-interval (* al bh) (* ah bl))

      ; Case 12
      (and (<= al 0) (<= ah 0) (<= bl 0)(>= bh 0))
      (make-interval (* al bh) (* al bl))

      ; Case 13
      (and (<= al 0) (<= ah 0) (<= bl 0)(<= bh 0))
      (make-interval (* ah bh) (* al bl))

      :else "Error - combination of end points not handled")))


;
; Exercies 2.12
;

(defn centre [i]
  (/  
    (+ (upper-bound i) (lower-bound i))
    2))

(defn make-centre-percent [centre, percent]
  (let [width (* centre percent 0.01)]
    (make-interval (- centre width) (+ centre width))))

(defn percent [interval]
  (*
    (/ (width interval) (centre interval))
    100.0))
  
;
; Exercise 2.13
;

; Let ca be centre, ta be tolerance for interval A
; likewise with cb, tb for interval B
;
; A = [(1-ta)ca, (1+ta)ca]
; B = [(1-tb)cb, (1+tb)cb]
; 
; Assuming A and B only span positive intervals
; AB = [(1-ta)(1-tb)cacb, (1+ta)(1+tb)cacb]
;    = [(1 - (ta + tb) + tatb)cacb, (1 + (ta + tb) + tatb)cacb]
;
; Allowing 2nd order term to drop out as ta and tb are small
; Substitute cacb ← C, tatb ← T
; AB = [(1 - T)C, (1 + T)C]
;
; Therefore AB is centred on cacb and has tolerance ta + tb
;




;
; Exercise 2.14
;

(defn par1 [r1 r2]
  (div-interval
    (mul-interval r1 r2)
    (add-interval r1 r2)))

(defn par2 [r1 r2]
  (let [one (make-interval 1 1)]
    (div-interval 
      one
      (add-interval
        (div-interval one r1)
        (div-interval one r2)))))

;
; Exercise 2.15
;

; Eva La Ator is correct. When using the 
; R1R2/(R1 + R2) form the lower bound estimate assumes
; that the R1 in the numerator is at the bottom of its range
; but R1 in the denominator is at the top of its range.
; This is clearly not possible. Hence this formula produces
; ranges that are too wide. If each variable is only 
; present once this problem cannot happen and the ranges
; are accurate.

;
; Excercise 2.16
; 

; An interval artihmetic package designed in the current way
; would need to algebraically manipulate the expression so that each variable
; is only represented once. This is not possible. 
; e.g. R1R2 + R2R3 + R3R1 or R1^2 + R1R2 + 1

;
; The general problem is
; 
; For a given formula f(R1, ,, Rn) we need to find 
;
; lower bound = min[R1 in R1 range, ..., Rn in Rn range, f]
; upper bound = max[R1 in R1 range, ..., Rn in Rn range, f]
;
; The branch of mathematics that tackles the general problem is called
; Optimisation. 
; If f is linear, then there are relatively easy ways of finding the answer
; e.g. Simplex method - called Linear Programming.
; If f is non-linear then it is harder sometimes it is not NP complete
;

; So we can write an interval arithmetic evaluator, but it may not work efficiently
; Here is an example of an evalator for brute forcing the answer for two variables
; This solves the parallel resistance problem
;

(defn evaluate-interval 
  ([Fn R1 R2] 
    (evaluate-interval Fn R1 R2 10000))
  
  ([Fn R1 R2 resolution]
    (defn create-range [r]
      (let [delta (/ (width r) resolution)]
        (range 
          (lower-bound r) 
          (+ (upper-bound r) delta)
          delta)))

    (let [possible-values 
      (map
          Fn
          (create-range R1)
          (create-range R2))]

      (make-interval
        (apply min possible-values)
        (apply max possible-values)))))


(defn par1-lambda [r1 r2]
  (/
    (* r1 r2)
    (+ r1 r2)))

(defn par2-lambda [r1 r2]
  (/
    1
    (+
      (/ 1 r1)
      (/ 1 r2))))



















