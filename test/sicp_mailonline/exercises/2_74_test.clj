;; Exercise 2.74

(ns sicp-mailonline.exercises.2-74-test
  (:require [sicp-mailonline.exercises.2-74 :refer :all]
            [clojure.test :refer :all]))

(def ^:private ^:const engineering-personnel-file
  (make-personnel-file :engineering
                       {"engineer-Joe Bloggs" {:name "Joe Bloggs"
                                               :engineering-salary 100}
                        "engineer-Sam Smith" {:name "Sam Smith"
                                              :engineering-salary 110}}))
(def ^:private ^:const sales-personnel-file
  (make-personnel-file :sales
                       {"salesperson-Joe Bloggs" {:name "Joe Bloggs"
                                                  :sales-salary 90}
                        "salesperson-Jane Doe" {:name "Jane Doe"
                                                :sales-salary 95}}))

(deftest exercise.2-74
  (install-personnel!)
  
  (testing "engineering"
    (is '(:engineering
          {:name "Joe Bloggs"
           :engineering-salary 100})
        (get-record "Joe Bloggs" engineering-personnel-file))

    (is '(:engineering
          {:name "Sam Smith"
           :engineering-salary 110})
        (get-record "Sam Smith" engineering-personnel-file)))

  (testing "sales"
    (is '(:sales
          {:name "Joe Bloggs"
           :sales-salary 90})
        (get-record "Joe Bloggs" sales-personnel-file))

    (is '(:sales
          {:name "Jane Doe"
           :sales-salary 95})
        (get-record "Jane Doe" sales-personnel-file)))

  (testing "find engineering employee's salary"
    (let [record (find-employee-record "Sam Smith" [sales-personnel-file
                                                    engineering-personnel-file])]
      (is (= 110
             (get-salary record)))))

  (testing "find sales employee's salary"
    (let [record (find-employee-record "Jane Doe" [engineering-personnel-file
                                                   sales-personnel-file])]
      (is (= 95
             (get-salary record)))))

  (testing "find's only first employee with the specified name"
    (let [record (find-employee-record "Joe Bloggs" [engineering-personnel-file
                                                     sales-personnel-file])]
      (is (= 100
             (get-salary record))))))
