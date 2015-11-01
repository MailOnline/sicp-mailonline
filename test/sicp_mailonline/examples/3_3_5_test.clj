;; Example 3.3.5 Propagation of Constraints

(ns sicp-mailonline.examples.3-3-5-test
  (:require [sicp-mailonline.examples.3-3-5.celsius-fahrenheit :as cf]
            [sicp-mailonline.examples.3-3-5.constraints :as con]
            [clojure.test :refer :all]))

(deftest celsius-fahrenheit
  (let [c (con/make-connector)
        f (con/make-connector)]
    (con/probe "Celsius temp" c)
    (con/probe "Fahrenheit temp" f)
    (cf/celsius-fahrenheit-converter c f)
    
    (testing "from celsius"
      (con/set-value! c 25 'user)
      (is (= 77 (con/get-value f))))

    (con/forget-value! c 'user)
    
    (testing "from fahrenheit"
      (con/set-value! f 212 'user)
      (is (= 100 (con/get-value c))))))
