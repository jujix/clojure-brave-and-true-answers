(ns fwpd.core)
(def filename "suspects.csv")
(def vamp-keys [:name :glitter-index])
(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

 (defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

 (defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

 (defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

 (defn glitter-filter
  [minimum-glitter records]
   (into ()
  (filter #(>= (:glitter-index %) minimum-glitter) records)))

 (defn list-all-suspects
   []
   (mapify (parse(slurp filename))))



 (defn append
   [suspect-name glitter-filter-value]
   (conj (mapify (parse(slurp filename))) {:name suspect-name :glitter-filter glitter-filter-value})
   )



 (defn validate
   [{:name :glitter-index} records]
   ()
   )

 (defn to-csv
  [folks]
  (clojure.string/join "\n" (map #(clojure.string/join "," [(:name %) (:glitter-index %)]) folks)))






