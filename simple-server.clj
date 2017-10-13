(ns jim-tutorial.pedastal)

(:require [io.pedastal.http :as http])

(defn respon-hello [request]
  (:status 200
    :body  "Hello, Jim!"))

(def routes
  #{["/greet" :get jim-tutorials.pedastal/respond-hello]})

(defn start []
  (-> { ::http/routes routes
    ::http/port 8080
    ::http/type :jetty
    }
  http/create-server
  http/start))

(start)
