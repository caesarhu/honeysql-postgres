(defproject caesarhu/honeysql-postgres "0.2.7"
  :description "PostgreSQL extension for honeysql"
  :url "https://github.com/nilenso/honeysql-postgres"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; read dependencies from deps.edn
  ; :plugins [[lein-tools-deps "0.4.1"]]
  ; :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  ; :lein-tools-deps/config {:config-files [:install :user :project]}
  :dependencies [[honeysql "1.0.444"  :exclusions [org.clojure/clojurescript]]]

  :tach {:test-runner-ns 'honeysql-postgres.postgres-test
         :source-paths ["src" "test"]}
  :profiles {:dev {:source-paths   ["dev/src"]
                   :plugins [[lein-tach "0.4.0"]]}})
