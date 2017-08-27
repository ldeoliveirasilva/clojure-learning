(ns forca.core
  (:gen-class))

(def total-of-lives 6)

(defn lost [] (print "You lost!"))

(defn won [] (print "You won!"))

(defn read-letter! [] (read-line))

(defn has-matched-the-word? [word hits] (empty? (missing-letters word hits)))

(defn missing-letters [word hits] 
	(remove 
		(fn [letter] (contains? hits (str letter)))
		word))

(defn hit? [shot word] (.contains word shot))

(defn eval-shot [shot lives word hits]
	(if (hit? shot word) 
		(game lives word (conj hits shot))
		(game (dec lives) word hits)
	)
)

(defn game [lives word hits] 
	(if (= lives 0)
		(lost)
		(if (has-matched-the-word? word hits)
			(won)
			(eval-shot (read-letter!) lives word hits)
		)
	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
