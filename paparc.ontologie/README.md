<p align="center">
  <a href="http://www.isped.u-bordeaux.fr/" target="_blank">
    <img src="http://www.isped.u-bordeaux.fr/Portals/0/ISPED-UBX_2019CJMN.jpg?ver=2019-03-27-141509-167" alt="isped-ub logo">
   </a>
</p>
<p align="center">Papa Yatma Diop - Marc Fouqué</p>

# Paparc - paparc.ontologie
<small>Ceci n'est pas une ontologie</small>
Partie du projet paparc permettant d'identifier les cancers primaires des patients.
L'identification se déroule en amont ponctuellement, et non à la volée durant la consultation.

## Pré-Requis
- l'ensemble du module 1 <a href="https://github.com/fbarbier/diagCancer">https://github.com/fbarbier/diagCancer</a>

## Installation & Utilisation
```.sh
git clone https://github.com/marcfouque/paparc.git
cd paparc\paparc.ontologie
mvn compile
javac src\main\java\algo\Algo.java
java src\main\java\algo\Algo
```
