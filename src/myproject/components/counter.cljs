(ns myproject.components.counter
  (:require [reagent.core :as r]))

(def click-count (r/atom 0))

(defn counter
  []
  [:div 
    [:h4 "Counter"]
    [:div @click-count]
    [:button {:on-click #(swap! click-count inc)} "count" ]
  ]
)