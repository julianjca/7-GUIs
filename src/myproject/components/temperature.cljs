(ns myproject.components.temperature
  (:require [reagent.core :as r]))

(def celcius (r/atom ""))
(def fahrenheit (r/atom ""))

(defn on-calcius-change [] )

(defn celcius-input
  []
  [:input {
    :type "text"
    :value @celcius
    :on-change (fn [event]
                  (reset! celcius (-> event .-target .-value))
                  (let [temp (+ 32 (/ (* 9 (js/parseInt (.. event -target -value))) 5))]
                    (reset! fahrenheit (if (js/isNaN temp) "" temp))
                    ))
  }]
)

(defn fahrenheit-input
  []
  [:input {
    :type "text"
    :value @fahrenheit
    :on-change (fn [event]
                  (reset! fahrenheit (-> event .-target .-value))
                  (let [temp (+ 32 (/ (* 5 (js/parseInt (.. event -target -value))) 9))]
                    (reset! celcius (if (js/isNaN temp) "" temp))
                    ))
  }]
)

(defn temperature
  []
  [:div 
    [:h4 "Temperature"]
    [celcius-input]
    [fahrenheit-input]
  ]
)