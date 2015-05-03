;; Exercise 2.70
;; The following eight-symbol alphabet with associated relative frequencies was
;; designed to efficiently encode the lyrics of 1950s rock songs.  (Note that
;; the "symbols" of an "alphabet" need not be individual letters.)
;;
;; A      2
;; BOOM   1
;; GET    2
;; JOB    2
;; NA    16
;; SHA    3
;; YIP    9
;; WAH    1
;;
;; Use generate-huffman-tree (exercise 2.69) to generate a corresponding Huffman
;; tree, and use encode (exercise 2.68) to encode the following message:
;;
;; Get a job
;; Sha na na na na na na na na
;; Get a job
;; Sha na na na na na na na na
;; Wah yip yip yip yip yip yip yip yip yip
;; Sha boom
;;
;; How many bits are required for the encoding?
;; What is the smallest number of bits that would be needed to encode this song
;; if we used a fixed-length code for the eight-symbol alphabet?

(ns sicp-mailonline.exercises.2-70-test
  (:require [sicp-mailonline.exercises.2-68 :refer [encode]]
            [sicp-mailonline.exercises.2-69 :refer [generate-huffman-tree]]
            [clojure.test :refer :all]))

(def ^:private ^:const alphabet '((A 2) (BOOM 1) (GET 2) (JOB 2) (NA 16) (SHA 3)
                                  (YIP 9) (WAH 1)))

(def ^:private ^:const get-a-job '(GET A JOB))
(def ^:private ^:const sha-na-na '(SHA NA NA NA NA NA NA NA NA))
(def ^:private ^:const wah-yip '(WAH YIP YIP YIP YIP YIP YIP YIP YIP YIP))
(def ^:private ^:const sha-boom '(SHA BOOM))
(def ^:private ^:const song (concat get-a-job sha-na-na get-a-job sha-na-na
                                    wah-yip sha-boom))

(deftest exercise2-70
  (testing "encoding a song"
    (let [tree (generate-huffman-tree alphabet)]
      (is (= 84
             (count (encode song tree)))))))

;; A variable-length encoding enables us to encode the song in 84 bits.

;; A fixed-length encoding would require 3 bits per symbol (log2 8 for 8
;; symbols).  The song consists of 36 symbols.  A fixed length encoding would
;; therefore require 3*36=108 bits.  
