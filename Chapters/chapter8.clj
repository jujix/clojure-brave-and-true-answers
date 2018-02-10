;Exercise 1







;Exercise 2

 (defmacro or
   ([] nil)
   ([x] x)
   ([x & next]
    `(let [or# ~x]
       (if or# or# (or ~@next))))

   )



;Exercise 3
