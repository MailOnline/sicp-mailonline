;; Example 3.3.5 Progagation of Constraints

(ns sicp-mailonline.examples.3-3-5.constraints)

(defn- inform-about-value [constraint]
  (constraint :I-have-a-value))

(defn- inform-about-no-value [constraint]
  (constraint :I-lost-my-value))

(defn- for-each-except [except procedure list]
  (doall
   (for [constraint list :when (not= constraint except)]
     (procedure constraint))))

(defn has-value? [connector]
  (connector :has-value?))

(defn get-value [connector]
  (connector :value))

(defn set-value! [connector new-value informant]
  ((connector :set-value!) new-value informant))

(defn forget-value! [connector retractor]
  ((connector :forget) retractor))

(defn connect [connector new-constraint]
  ((connector :connect) new-constraint))

(defn adder [a1 a2 sum]
  (letfn [(process-new-value []
            (cond (and (has-value? a1) (has-value? a2))
                    (set-value! sum (+ (get-value a1) (get-value a2)) me)
                  (and (has-value? a1) (has-value? sum))
                    (set-value! a2 (- (get-value sum) (get-value a1)) me)
                  (and (has-value? a2) (has-value? sum))
                    (set-value! a1 (- (get-value sum) (get-value a2)) me)))
          (process-forget-value []
            (forget-value! sum me)
            (forget-value! a1 me)
            (forget-value! a2 me)
            (process-new-value))
          (me [request]
            (cond (= request :I-have-a-value)
                    (process-new-value)
                  (= request :I-lost-my-value)
                    (process-forget-value)
                  :else (throw (IllegalArgumentException.
                                (str "Unknown request -- ADDER" request)))))]
    (connect a1 me)
    (connect a2 me)
    (connect sum me)
    me))

(defn multiplier [m1 m2 product]
  (letfn [(process-new-value []
            (cond (or (and (has-value? m1) (zero? (get-value m1)))
                      (and (has-value? m2) (zero? (get-value m2))))
                    (set-value! product 0 me)
                  (and (has-value? m1) (has-value? m2))
                    (set-value! product (* (get-value m1) (get-value m2)) me)
                  (and (has-value? product) (has-value? m1))
                    (set-value! m2 (/ (get-value product) (get-value m1)) me)
                  (and (has-value? product) (has-value? m2))
                    (set-value! m1 (/ (get-value product) (get-value m2)) me)))
          (process-forget-value []
            (forget-value! product me)
            (forget-value! m1 me)
            (forget-value! m2 me)
            (process-new-value))
          (me [request]
            (cond (= request :I-have-a-value)
                    (process-new-value)
                  (= request :I-lost-my-value)
                    (process-forget-value)
                  :else (throw (IllegalArgumentException.
                                (str "Unknown request -- MULTIPLIER" request)))))]
    (connect m1 me)
    (connect m2 me)
    (connect product me)
    me))

(defn constant [value connector]
  (letfn [(me [request]
            (throw (IllegalArgumentException.
                    (str "Unknown request -- CONSTANT" request))))]
    (connect connector me)
    (set-value! connector value me)
    me))

(defn probe [name connector]
  (letfn [(print-probe [value]
            (printf "%nProbe: %s = %s" name value))
          (process-new-value []
            (print-probe (get-value connector)))
          (process-forget-value []
            (print-probe "?"))
          (me [request]
            (cond (= request :I-have-a-value)
                    (process-new-value)
                  (= request :I-lost-my-value)
                    (process-forget-value)
                  :else (throw (IllegalArgumentException.
                                (str "Unknown request -- PROBE" request)))))]
    (connect connector me)))

;; the check-then-acts on the value atom are not ideal here - but we assume a single thread here
(defn make-connector []
  (let [value (atom {:value false
                     :informant false})
        constraints (atom #{})
        has-value? (fn []
                     (:informant @value))
        set-my-value (fn [newval setter]
                       (cond (not (has-value?))
                               (do
                                 (swap! value assoc :value newval :informant setter)
                                 (for-each-except setter inform-about-value @constraints))
                             (not= (:value @value) newval)
                               (throw (IllegalStateException.
                                       (str "Contradiction" (list value newval))))
                             :else 'ignored))
        forget-my-value (fn [retractor]
                          (if (= retractor (:informant @value))
                            (do
                              (swap! value assoc :informant false)
                              (for-each-except retractor inform-about-no-value @constraints))
                            'ignored))
        connect (fn [new-constraint]
                  (swap! constraints conj new-constraint)
                  (if (has-value?)
                    (inform-about-value new-constraint))
                  'done)
        me (fn [request]
             (cond (= request :has-value?) (has-value?)
                   (= request :value) (:value @value)
                   (= request :set-value!) set-my-value
                   (= request :forget) forget-my-value
                   (= request :connect) connect
                   :else (throw (IllegalArgumentException.
                                 (str "Unknown operation -- CONNECTOR" request)))))]
    me))
