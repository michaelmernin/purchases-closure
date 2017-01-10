(ns people-clojure.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn -main []
  (println "Type a country name:")
  (let [people (slurp "people.csv")
        people (str/split-lines people)
        people (map (fn [line]
                      (str/split line #","))
                 people)
        header (first people)
        people (rest people)
        people (map (fn [line]
                      (zipmap header line))
                 people)
        country-name (read-line)
        people (filter (fn [line]
                         (= (get line "country") country-name))
                 people)
        file-text (pr-str people)]  
    (spit "filtered_people.edn" file-text)))

