;Exercise 1

(ns were-creatures)
( defmulti full-moon-behavior (fn [were-creature] (:were-type were-creature)))
 (defmethod full-moon-behavior :wolf
  [were-creature]
  (str (:name were-creature) " will howl and murder"))
 (defmethod full-moon-behavior :simmons
  [were-creature]
  (str (:name were-creature) " will encourage people and sweat to the oldies"))

  (defmethod full-moon-behavior :my-own-were-creature-type
    [were-creature]
    (str (:name were-creature) " Exercise 1"))
(full-moon-behavior {:name "Vesku" :were-type :my-own-were-creature-type})

;Exercise 2
;Create a WereSimmons record type, and then extend the WereCreature protocol.


(defprotocol WereCreature
   (full-moon-behavior [x]))

   (defrecord WereSimmons [name title]
  WereCreature
  (full-moon-behavior [x]
    (str name "Exercise 2")))

    (full-moon-behavior (map->WereSimmons {:name "Lucian" :title "CEO of Melodrama"}))


;Exercise 3
;Create your own protocol, and then extend it using extend-type and extend-protocol.

(defprotocol MyOwnProtocol
   (full-moon-behavior [x]))

   (extend-type java.lang.Object
     MyOwnProtocol
     (full-moon-behavior [x] "Exercise 3 extend-type"))

     (full-moon-behavior 3)


     (extend-protocol MyOwnProtocol
        java.lang.String
           (full-moon-behavior [x] "Exercise 3 extend-protocol"))

            (full-moon-behavior "ok")



;Exercise 4
;Create a role-playing game that implements behavior using multiple dispatch.
