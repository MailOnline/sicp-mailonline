;; Example 3.3.4 - A Simulator for Digital Circuits

(ns sicp-mailonline.examples.3-3-4.wire)

(defn make-wire []
  (let [signal-value (atom 0)
        action-procedures (atom (list))
        set-my-signal! (fn [new-value]
                         (reset! signal-value new-value))
        accept-action-procedure! (fn [proc]
                                   (swap! action-procedures conj proc)
                                   (proc))
        call-each (fn [procedures]
                    (when-not (empty? procedures)
                      ((first procedures))
                      (recur (rest procedures))))
        dispatch (fn [m]
                   (cond (= m :get-signal) @signal-value
                         (= m :set-signal!) set-my-signal!
                         (= m :add-action!) accept-action-procedure!
                         :else (throw (IllegalArgumentException.
                                       (str "Unknown operation -- WIRE " m)))))]
    (set-validator! signal-value (fn [new-value]
                                   (or (= new-value 0)
                                       (= new-value 1))))
    (add-watch signal-value 'signal (fn [key ref old-value new-value]
                                      (if (not= old-value new-value)
                                        (call-each @action-procedures))))
    dispatch))

(defn get-signal [wire]
  (wire :get-signal))

(defn set-signal! [wire new-value]
  ((wire :set-signal!) new-value))

(defn add-action! [wire action-procedure]
  ((wire :add-action!) action-procedure))
