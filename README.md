# ProcessusStochastique
Sujet 2
Modeles d'infection
avril{mail 2016
La problematique est d'etudier des modeles simples d'infection d'un reseau d'ordina-
teurs par un virus, a l'aide de cha^nes de Markov.
On considere un systeme constitue de n ordinateurs, pouvant ^etre chacun soit infecte,
soit sain. Chaque ordinateur peut passer d'un etat a l'autre.
Pour chaque modele propose (par le sujet ou par le groupe), on donnera des reponses
theoriques et numeriques, par exemple sur la convergence du nombre moyen d'ordinateurs
infectes au cours du temps.
Premier modele : a chaque instant n, on choisit uniformement un ordinateur, et on
change son etat.
Deuxieme modele : a chaque instant n, on choisit uniformement un ordinateur ; s'il
est infecte, on a une probabilite p de le guerir ; s'il est sain, il a une probabilite q d'^etre
infecte.
Troisieme modele : les ordinateurs sont places au sommet d'un graphe (par exemple
un cercle). Le virus se deplace d'un ordinateur a l'autre sur ce graphe, selon une marche
aleatoire ; independamment, l'antivirus fait de m^eme. Le virus infecte l'ordinateur ou il se
trouve, avec une certaine probabilite ; cet ordinateur reste alors infecte tant que l'antivirus
n'a pas fait eet. L'antivirus agit de la maniere symetrique : il peut guerir l'ordinateur ou
il se trouve, si besoin, avec une certaine probabilite.
Les modeles ci-dessus sont simplistes, et il sera naturel de vouloir proposer des modeles
plus realistes. On pourra par exemple envisager des situations ou trois etats sont pos-
sibles : sain, infecte mais pouvant ^etre gueri, infecte ne pouvant pas ^etre gueri. On pourra
considerer les virus comme une population, qui se reproduit, se deplace, et meurt sui-
vant certaines regles. Enn, on pourra considerer que le reseau d'ordinateur forme un
graphe plus raisonnable qu'un cercle. Il sera notamment interessant de s'interesser a
quelques caracterisques geometriques du graphe (plut^ot \centralises", avec quelques hubs
tres connectes et beaucoup d'ordinateurs connectes essentiellements a des hubs, ou plut^ot
decentralises) et comment, toutes choses egales par ailleurs, la geometrie du graphe aecte
la propagation du virus.
On pourra aussi considerer des modeles en temps continu, ou les taux d'infection et de
guerison dependent de la conguration.

