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
		(game (dec lives) word hits)))

(defn game [lives word hits] 
	(cond 
		(= lives 0) (lost)
		(has-matched-the-word? word hits) (won)
		:else
			(let [shot (read-letter!)]
				(if (hit? shot word)
					(do 
						(println "It's a hit!") 
						(game lives word (conj hits shot)))
					(do 
						(println "It's a miss...")
						(game (dec lives) word hits))))))
					
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
