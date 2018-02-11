;Exercise 1

(defn quote-word-count
  []
  (let [number-of-quotes (atom 8)]
  (println (str "The result is first: " @number-of-quotes))
  (swap! number-of-quotes inc)
  (swap! number-of-quotes inc)
(println (str "After swapping: " @number-of-quotes))))



;Exercise 2

(def quote-url "http://www.braveclojure.com/random-quote")

(defn word-count
    [wctext]
    (->> (clojure.string/split wctext #"[ .;?!\-\n\r]")
        (filter #(not (empty? %)))
        (map #(clojure.string/lower-case %))
        (frequencies)))

(defmacro n-futures
    [n body]
    `(let [promises# (take ~n (repeatedly promise))]
        (doseq [p# promises#]
            (do ~body (deliver p# true)))
        (every? ~deref promises#)))

(defn random-quote-word-count
    [num-quotes]
    (let [wc (atom {})]
      (do
        (n-futures num-quotes
            (swap! wc (fn [current-wc]
                        (merge-with + current-wc (word-count (slurp quote-url))))))
        @wc)))


;Exercise 3

(defn str-character-state
  [character]
  (clojure.string/join " " (map #(str % " => " (% character)) (keys character))))


(defn start-game
  []
  (let [alliance-knight (ref {:hp 15 :max-hp 40 :healing-potions 0})
  horde-orc (ref {:hp 40 :max-hp 40 :healing-potions 1})]
(do
  (println (str "alliance-knight: " (str-character-state @alliance-knight)))
(println (str "horde-orc: " (str-character-state @horde-orc)))

(println "Orc uses a potion... ")
(dosync
  (alter horde-orc update-in [:healing-potions] dec)
    (alter alliance-knight update-in [:hp] + (- (:max-hp @alliance-knight) (:hp @alliance-knight))))
    (println (str "Alliance knight status: " (str-character-state @alliance-knight)))
        (println (str "Horde orcs status: " (str-character-state @horde-orc)))
  )
  ))
