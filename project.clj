(defproject sicp-mailonline "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :repl-options {:init (do
                         (require 'midje.repl)
                         (midje.repl/autotest :filter (complement :slow)))}
  :profiles {:dev {:dependencies [[midje "1.6.3"]]
                   :plugins [[lein-midje "3.1.1"]
                             [com.jakemccrary/lein-test-refresh "0.5.2"]]}})
