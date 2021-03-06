(ns forca.core
  (:gen-class))

(def total-of-lives 6)

(def secret-word "WATERMELON")

(defn lost [] (println "You lost!"))

(defn won [] (println "You won!"))

(defn read-letter! [] (read-line))

(defn missing-letters [word hits] 
	(remove 
		(fn [letter] (contains? hits (str letter)))
		word))

(defn has-matched-the-word? [word hits] (empty? (missing-letters word hits)))

(defn hit? [shot word] (.contains word shot))

(defn print-state [lives word hits]
	(println "You still have" lives "shots") 
	(doseq [letter (seq word)]
		(if (contains? hits (str letter))
			(print letter " ")
			(print "_" " ")))

	(println))

(defn game [lives word hits] 
	(print-state lives word hits)
	(cond 
		(= lives 0) (lost)
		(has-matched-the-word? word hits) (won)
		:else
			(let [shot (read-letter!)]
				(if (hit? shot word)
					(do 
						(println "It's a hit!") 
						(recur lives word (conj hits shot)))
					(do 
						(println "It's a miss...")
						(recur (dec lives) word hits))))))

(defn start-game  [] (game total-of-lives secret-word #{}))
					
(defn -main
  [& args]
  (start-game))
