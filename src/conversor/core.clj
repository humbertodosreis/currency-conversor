(ns conversor.core
;; importando outros namespaces do projeto 
  (:require [conversor.formatador :refer [formatar]]
            [conversor.interpretador-de-opcoes :refer [interpretar-opcoes]]
            [conversor.cambista :refer [obter-cotacao]]))

(def opcoes-do-programa [["-d" "--de moeda base" "moeda base para conversão"
                          :default "eur"]
                         ["-p" "--para moeda destino"
                          "moeda a qual queremos saber o valor"]])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [{:keys [de para]} (interpretar-opcoes args)]
    (-> (obter-cotacao de para)
        (formatar de para)
        (prn))))
