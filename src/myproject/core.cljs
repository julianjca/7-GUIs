(ns myproject.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]
      [myproject.components.counter :refer [counter]]
      [myproject.components.temperature :refer [temperature]]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "7 GUIs Challenge"]
  [counter]
  [temperature]
  ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
