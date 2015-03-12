;; Exercise 2.29

(ns sicp-mailonline.exercises.2-29-test
  (:require [sicp-mailonline.exercises.2-29 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const simple-balanced-mobile (make-mobile (make-branch 2 3)
                                                           (make-branch 2 3)))
(def ^:private ^:const simple-unbalanced-mobile (make-mobile (make-branch 2 3)
                                                             (make-branch 4 5)))

(deftest exercise2-29
  (testing "simple balanced mobile"
    (is (= 6
           (total-weight simple-balanced-mobile)))

    (is (balanced? simple-balanced-mobile)))

  (testing "simple unbalanced mobile"
    (is (= 8
           (total-weight simple-unbalanced-mobile)))

    (is (not (balanced? simple-unbalanced-mobile))))

  (testing "hierarchical unbalanced mobile"
    (let [mobile (make-mobile (make-branch 5 simple-balanced-mobile)
                              (make-branch 3 simple-unbalanced-mobile))]
      (is (= 14
             (total-weight mobile)))

      (is (not (balanced? mobile)))))

  (testing "balanced mobile"
    (let [mobile (make-mobile (make-branch 10 simple-balanced-mobile)
                              (make-branch 12 5))]
      (is (= 11
             (total-weight mobile)))

      (is (balanced? mobile)))))
