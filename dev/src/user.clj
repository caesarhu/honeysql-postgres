(ns user
  (:require [honeysql.core :as sql]
            [honeysql.helpers :refer :all]
            [honeysql-postgres.helpers :as psqlh]
            [honeysql.format :as sqlf :refer [fn-handler format-clause format-modifiers]]))

(def films
  (-> (psqlh/create-table :films)
      (psqlh/with-columns [[:code (sql/call :char 5) (sql/call :constraint :firstkey) (sql/call :primary-key)]
                           [:title (sql/call :varchar 40) (sql/call :not nil)]
                           [:did :integer (sql/call :not nil)]
                           [:eid :bigint
                            (sql/call :references :employee :id)
                            (sql/call :on-update :cascade)
                            (sql/call :on-delete :restrict)]
                           [:hid :integer (sql/call :generate-column "eid / 2")]
                           [:date_prod :date]
                           [:test-text :text (sql/call :not nil)]
                           [:kind (sql/call :varchar 10)]])
      sql/format))