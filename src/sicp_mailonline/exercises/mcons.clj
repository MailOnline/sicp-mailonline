(ns sicp-mailonline.mcons)

; mcons
; car
; cdr
;
; set-car!
; set-cdr!
;

; (defprotocol MutableCons

;   )


; (deftype MCons
;   mutable-cons

;   (init [h t]
;       (merge this { :h (atom h)
;                     :t (atom t)})))


; (defn mcons [h t]
;   (init (MCons.) h t))

(defn mcons [h t]
  [(atom h) (atom t)])

(defn mcar [mcons]
  (-> mcons first deref))

(defn set-car! [mcons h]
  (swap! (first mcons) (constantly h))
  mcons)
