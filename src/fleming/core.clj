(ns fleming.core
  (:require [gavagai.core :as g]
            [clojure.core.memoize :as memo])
  (:import [net.sf.uadetector.service UADetectorServiceFactory]
           [net.sf.uadetector UserAgentStringParser]))

(defn make-parser
  ([typ]
   (case typ
     :caching-and-updating (UADetectorServiceFactory/getCachingAndUpdatingParser)
     :online-updating (UADetectorServiceFactory/getOnlineUpdatingParser)
     :resource-module (UADetectorServiceFactory/getResourceModuleParser)))
  ([] (make-parser :resource-module)))

(def translator
  (g/register-converters
   {:exclude [:class]}
   [["net.sf.uadetector.UserAgent"]
    ["net.sf.uadetector.DeviceCategory"]
    ["net.sf.uadetector.OperatingSystem"]
    ["net.sf.uadetector.VersionNumber"]]))

(defn translate-useragent
  [ua]
  (g/translate translator ua {}))

(defn parse-ua
  ([^UserAgentStringParser parser ^String ua]
   (translate-useragent (.parse parser ua)))
  ([ua] (parse-ua (make-parser) ua)))

(defn make-cached-parser
  ([theshold]
   (let [parser (make-parser)]
     (memo/lu
      (fn [ua] (parse-ua parser ua))
      :lu/threshold
      theshold)))
  ([] (make-cached-parser 100)))
