(ns sicp-mailonline.exercises.3-9)

(def ^:dynamic *dbg* false)

(defmacro whendbg [msg]
  `(when *dbg* (println "### [3.9]:" ~msg)))

(defmacro with-dbg [& body]
  `(binding [*dbg* true]
    ~@body))

(defn factorial [n]
  (whendbg (str "iterative factorial enter n=" n))
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(defn fact-iter [product counter max-count]
  (if (> counter max-count)
    product
    (fact-iter (* counter product)
               (+ counter 1)
               max-count)))

(defn factorial-iter [n]
  (fact-iter 1 1 n))
