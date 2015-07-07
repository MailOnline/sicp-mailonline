(ns sicp-mailonline.paragraphs.2-4-2-tagged-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.paragraphs.2-4-2-tagged :refer :all]))

(facts "tagged data"
       (fact "correct tagging"
             (type-tag (attach-tag 'test [:x :y])) => 'test
             (contents (attach-tag 'test [:x :y])) => [:x :y]
             (rectangular? (attach-tag 'rectangular [:x :y])) => true
             (polar? (attach-tag 'polar [:x :y])) => true)
       (fact "bogus tagging"
             (contents ['bogus :x :y]) => (throws Exception))
       (fact "new rect/polar with tagging"
             (polar? (make-from-mag-ang-polar 2 3)) => true))
