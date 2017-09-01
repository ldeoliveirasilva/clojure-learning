(ns spellchecker.core
  (:require [clojure.string :as str])
  (:import (org.apache.commons.lang3 StringUtils)))

(def words-file-path "resources/wordsEn.txt")

(def words
	(->> 
		(slurp words-file-path)
		(str/split-lines)
		(map str/trim)
		(set)))

(defn distance [from to] (StringUtils/getLevenshteinDistance from to))

(defn min-distance [word] 
  (apply min-key (partial distance word) words))

(defn correct? [word] (contains? words word))



(defn -main
  [& args]
  (let [word (first args)] (
  		if (correct? word)
  		(println "correct")
  		(println "Did you mean" (min-distance word) "?"))))
