(ns forca.core
  (:gen-class))

(def total-of-lives 6)

(defn lost [] (print "You lost!"))

(defn won [] (print "You won!"))

(defn take-another-shot [] (print "Take another shot..."))

(defn has-matched-the-word? [word hits] (empty? (missing-letters word hits)))

(defn missing-letters [word hits] 
	(remove 
		(fn [letter] (contains? hits (str letter)))
		word))

(defn game [lives word hits] 
	(if (= lives 0)
		(lost)
		(if (has-matched-the-word? word hits)
				(won)
				(take-another-shot)
			)
	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
