(ns sicp-mailonline.examples.2-3-1-test
  (:require [sicp-mailonline.examples.2-3-1 :refer :all]
            [clojure.test :refer :all]))

(deftest example2-3-1
  (testing "not a member"
    (is (not (memq 'apple '(pear banana prune)))))

  (testing "membership"
    (is (= '(apple pear)
           (memq 'apple '(x (apple sauce) y apple pear))))))
