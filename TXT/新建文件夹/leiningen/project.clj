(defproject thheller/shadow-cljs "2.20.15"

  :repositories
  {"clojars" {:url "https://clojars.org/repo"
              :sign-releases false}}

  :managed-dependencies
  [[commons-codec "1.5.648"]
   ;; [com.google.errorprone/error_prone_annotations "2.4.0"]
    ]

  :dependencies
  [[org.clojure/clojure "1.11.1"]

   [nrepl "1.0.0"]
   [cider/piggieback "0.5.3"
    :exclusions
    [org.clojure/clojure
     org.clojure/clojurescript
     nrepl/nrepl]]
   [org.java-websocket/java-websocket "1.3.1"]
   ]

  :profiles
  {:provided
   {:source-paths
    ["src/ui-release"]}
   :dev
   {
    :dependencies [[com.cemerick/piggieback "0.2.2-SNAPSHOT"]
        ]}
   :cljs {

    :dependencies 
    [[com.novemberain/validateur "2.5.0"]
     [ring-server "0.5.0"]
     [re-frisk "0.5.3"]]
}
})
