;; Example 3.3.4 - A Simulator for Digital Circuits

(ns sicp-mailonline.examples.3-3-4.simulation
  (:require [sicp-mailonline.examples.3-3-4.wire :as wire]))

(defn make-agenda []
  {:current-time (atom 0)
   :segments (atom (sorted-map))})

(defn- current-time [agenda]
  @(:current-time agenda))

(defn- set-current-time! [agenda time]
  (reset! (:current-time agenda) time))

(defn- empty-agenda? [agenda]
  (empty? @(:segments agenda)))

(defn- add-to-agenda! [time action agenda]
  (letfn [(add-action [segments]
            (assoc segments
                   time
                   (conj (get segments time []) action)))]    
    (swap! (:segments agenda) add-action)))

(defn- remove-first-agenda-item! [agenda]
  (letfn [(remove-action [segments]
            (let [[time queue] (first segments)]
              (if (empty? (rest queue))
                (dissoc segments time)
                (assoc segments time (rest queue)))))]
    (swap! (:segments agenda) remove-action)))

(defn- first-agenda-item! [agenda]
  {:pre [(not (empty-agenda? agenda))]}
  (let [[time queue] (first @(:segments agenda))]
    (set-current-time! agenda time)
    (first queue)))

(defn after-delay [agenda delay action]
  (add-to-agenda! (+ delay (current-time agenda))
                  action
                  agenda))

(defn propagate [agenda]
  (if (empty-agenda? agenda)
    'done
    (let [first-item (first-agenda-item! agenda)]
      (first-item)
      (remove-first-agenda-item! agenda)
      (recur agenda))))

(defn probe [name agenda wire]
  (wire/add-action! wire
                    #(printf "%n%s %d new-value=%d"
                             name
                             (current-time agenda)
                             (wire/get-signal wire))))
