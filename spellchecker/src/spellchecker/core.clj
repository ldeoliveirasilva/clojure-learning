(ns spellchecker.core
  (:require [clojure.string :as str]))

(def words-file-path "resources/wordsEn.txt")

(def words
	(->> 
		(slurp words-file-path)
		(str/split-lines)
		(map str/trim)
		(set)))

(defn correct? [word] (contains? words word))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
