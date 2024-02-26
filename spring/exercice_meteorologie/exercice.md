# Exercice : Agrégation de Données Météorologiques et de News

*Objectif* : Créer une application Spring WebFlux qui utilise WebClient pour récupérer les données météorologiques et les dernières nouvelles de deux API différentes, puis les combine en un seul objet de réponse.
Description :

Supposons que vous ayez accès à deux API REST :

    - Une API météorologique (WeatherAPI) qui fournit les prévisions météorologiques actuelles.
    - Une API de nouvelles (NewsAPI) qui fournit les dernières nouvelles.

Vous devez écrire un service qui récupère simultanément les données météorologiques et les nouvelles, les combine, et retourne une réponse agrégée.