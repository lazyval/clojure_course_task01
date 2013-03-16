(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))

(defn- has-childs? [x] (and (not (char? x)) (seq x)))
                           
(defn get-links []
  (->> (parse "clojure_google.html")
       (tree-seq has-childs? rest)
       (filter #(= (:class %1) "l"))
       (map :href)
        vec))

(defn -main []
  (println (str "Found " (count (get-links)) " links!")))