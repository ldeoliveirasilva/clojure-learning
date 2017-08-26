(ns forca.core
  (:gen-class))

(def total-of-lives 6)

(defn lost [] (print "You lost!"))

(defn game [lives] 
	(if (= lives 0)
		(lost)
		(do 
			(print lives)
			(game (dec 1))	
		)
	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
