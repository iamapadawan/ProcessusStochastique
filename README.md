# Projet ProcessusStochastique

Sujet 2 : Modéles d'infection avec les chaines de Markov
=========================
La problematique est d'etudier des modeles simples d'infection d'un reseau d'ordina-
teurs par un virus, a l'aide de chaines de Markov.
On considere un systeme constitue de n ordinateurs, pouvant etre chacun soit infecte,
soit sain. Chaque ordinateur peut passer d'un etat a l'autre.
Pour chaque modele propose (par le sujet ou par le groupe), on donnera des reponses
theoriques et numeriques, par exemple sur la convergence du nombre moyen d'ordinateurs
infectes au cours du temps.
Premier modele : a chaque instant n, on choisit uniformement un ordinateur, et on
change son etat.
Deuxieme modele : a chaque instant n, on choisit uniformement un ordinateur ; s'il
est infecte, on a une probabilite p de le guerir ; s'il est sain, il a une probabilite q d'etre
infecte.
Troisieme modele : les ordinateurs sont places au sommet d'un graphe (par exemple
un cercle). Le virus se deplace d'un ordinateur a l'autre sur ce graphe, selon une marche
aleatoire ; independamment, l'antivirus fait de m^eme. Le virus infecte l'ordinateur ou il se
trouve, avec une certaine probabilite ; cet ordinateur reste alors infecte tant que l'antivirus
n'a pas fait et. L'antivirus agit de la maniere symetrique : il peut guerir l'ordinateur ou
il se trouve, si besoin, avec une certaine probabilite.
Les modeles ci-dessus sont simplistes, et il sera naturel de vouloir proposer des modeles
plus realistes. On pourra par exemple envisager des situations ou trois tats sont pos-
sibles : sain, infecte mais pouvant etre gueri, infecte ne pouvant pas ^etre gueri. On pourra
considerer les virus comme une population, qui se reproduit, se deplace, et meurt sui-
vant certaines regles. Enfin, on pourra considerer que le reseau d'ordinateur forme un
graphe plus raisonnable qu'un cercle. Il sera notamment interessant de s'interesser a
quelques caracterisques geometriques du graphe (plutot \centralises", avec quelques hubs
tres connectes et beaucoup d'ordinateurs connectes essentiellements a des hubs, ou plut^ot
decentralises) et comment, toutes choses egales par ailleurs, la geometrie du graphe aecte
la propagation du virus.
On pourra aussi considerer des modeles en temps continu, ou les taux d'infection et de
guerison dependent de la conguration.
Participants
------------

> Ahmed Salem Soumare   
> Talha Ayub
> Ali Elouardi   

Fichier inclus
--------------

> Markovirus.java    
>    executable permettant le lancement de l'application et son execution.    


Directives maven
----------------------

> mvn:install  
    Compilation de tous les fichiers   

> mvn:clean
    Suppression de tous les fichiers dan le repertoire "target"        
    
Execution
---------

> grace à l'executable "Markovirus.exe"      

ou

> grace au fichier jar "ProcessusStochastique-1.0.0-SNAPSHOT.jar"    
>    Archive java de l'application pouvant etre executé avec la commande suivante:
         >java -cp "ProcessusStochastique-1.0.0-SNAPSHOT.jar"  fr.esiea.unique.binome.aliayubsoumare.Main        

Version Java utilisée
---------------------

> Java 8    
