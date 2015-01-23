(defproject com.oscaro/fleming "0.1.0"
  :description "Small library for browser user agent identification, based on the UADetector Java library"
  :url "https://github.com/oscaro/fleming"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [net.sf.uadetector/uadetector-resources "2014.10"]
                 [gavagai "0.3.2"]
                 [org.clojure/core.memoize "0.5.7"]]
  :profiles {:dev {:dependencies [[expectations "2.0.13"]]
                   :plugins [[lein-expectations "0.0.7"]]}})
