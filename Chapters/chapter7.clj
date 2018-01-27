(use 'clojure.pprint)

(defn exercise-1 [] (eval (list (read-string "print") "Vesku:" "Back to the future")))


(1 + 3 * 4 - 5)

(defmacro exercise-2Kerto
  "3*4"
  [infixed]
  (list (nth infixed 3)
        (nth infixed 2)
        (nth infixed 4)
        ))

(defmacro exercise-2Plus
  "1 + 3"
  [infixed]
  (list (nth infixed 1)
        (nth infixed 0)
        (nth infixed 2)
        ))

(defmacro exercise-2Minus
  "5 - 4"
  [infixed]
  (list (nth infixed 5)
        (nth infixed 6)
        (nth infixed 4)
        ))
