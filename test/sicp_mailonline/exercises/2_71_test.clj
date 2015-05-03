;; Exercise 2.71
;; Suppose we have a Huffman tree for an alphabet of n symbols, and that the
;; relative frequencies of the symbols are 1,2,4,...,2^(n-1).  Sketch the tree
;; for n=5; for n=10.  In such a tree (for general n) how many bits are required
;; to encode the most frequent symbol? the least frequent symbol?

;; n=5
;; ((A 1) (B 2) (C 4) (D 8) (E 16))
;; merge (A 1) + (B 2)   -> ((AB 3) (C 4) (D 8) (E 16))
;; merge (AB 3) + (C 4)  -> ((ABC 7) (D 8) (E 16))
;; merge (ABC 7) + (D 8) -> ((ABCD 15) (E 16))

;; n=10
;; ((A 1) (B 2) (C 4) (D 8) (E 16) (F 32) (G 64) (H 128) (I 256) (J 512))
;; merge (A 1) + (B 2)            -> ((AB 3) (C 4) (D 8) (E 16) (F 32) (G 64) (H 128) (I 256) (J 512))
;; merge (AB 3) + (C 4)           -> ((ABC 7) (D 8) (E 16) (F 32) (G 64) (H 128) (I 256) (J 512))
;; merge (ABC 7) + (D 8)          -> ((ABCD 15) (E 16) (F 32) (G 64) (H 128) (I 256) (J 512))
;; merge (ABCD 15) + (E 16)       -> ((ABCDE 31) (F 32) (G 64) (H 128) (I 256) (J 512))
;; merge (ABCDE 31) + (F 32)      -> ((ABCDEF 63) (G 64) (H 128) (I 256) (J 512))
;; merge (ABCDEF 63) + (G 64)     -> ((ABCDEFG 127) (H 128) (I 256) (J 512))
;; merge (ABCDEFG 127) + (H 128)  -> ((ABCDEFGH 255) (I 256) (J 512))
;; merge (ABCDEFGH 255) + (I 256) -> ((ABCDEFGHI 511) (J 512))
;;
;; The most frequent symbol can always be encoded with 1 bit in such a tree.
;; The least frequent symbol requires n-1 bits in such a tree.
