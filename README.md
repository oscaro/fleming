# fleming

Small library for browser user agent identification, based on the UADetector Java library.

## Usage

```clojure
(use 'fleming.core)
(def parse-ua (make-cached-parser 1000))
(parse-ua "Mozilla/5.0 (X11; Linux x86_64; rv:33.0) Gecko/20100101 Firefox/33.0")
;;=>
{:device-category {:category :PERSONAL_COMPUTER, :icon "desktop.png", :info-url "/list-of-ua/device-detail?device=Personal computer",
                   :name "Personal computer"},
 :family :FIREFOX, :icon "firefox.png", :name "Firefox",
 :operating-system {:family :LINUX, :family-name "Linux", :icon "linux.png", :name "Linux", :producer "", :producer-url "",
                    :url "http://en.wikipedia.org/wiki/Linux",
                    :version-number {:bugfix "", :extension "", :groups ["" "" ""], :major "", :minor ""}},
 :producer "Mozilla Foundation", :producer-url "http://www.mozilla.org/", :type :BROWSER, :type-name "Browser", :url "http://www.firefox.com/",
 :version-number {:bugfix "", :extension "", :groups ["33" "0" ""], :major "33", :minor "0"}}
 ```

## License

Copyright © 2014 Oscaro.com

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
