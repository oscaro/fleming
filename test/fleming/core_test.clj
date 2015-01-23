(ns fleming.core-test
  (:require [expectations :refer :all]
            [fleming.core :refer :all]))


(def pua (make-cached-parser 1000))
(def ua "Mozilla/5.0 (X11; Linux x86_64; rv:33.0) Gecko/20100101 Firefox/33.0")
(expect true (fn? pua))

(def res (pua ua))
(expect lazymap.core.LazyPersistentMap res)
(expect {:type :BROWSER} (in (into {} res)))
(expect true (map? (:operating-system res)))
(expect #"Mozilla" (:producer res))
