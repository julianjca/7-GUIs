(ns myproject.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]
      [myproject.components.counter :refer [counter]]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "Welcome to Reagent"]
  [counter]
  ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
