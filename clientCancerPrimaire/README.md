<p align="center">
  <a href="http://www.isped.u-bordeaux.fr/" target="_blank">
    <img src="http://www.isped.u-bordeaux.fr/Portals/0/ISPED-UBX_2019CJMN.jpg?ver=2019-03-27-141509-167" alt="isped-ub logo">
   </a>
</p>
<p align="center">Papa Yatma Diop - Marc Fouqué</p>

# Paparc - clientCancerPrimaire

Partie du projet paparc permettant de visualiser les cancers primaires des patients.


## Pré-Requis
- l'ensemble du module 1 <a href="https://github.com/fbarbier/diagCancer">https://github.com/fbarbier/diagCancer</a>

si "compilation" des sources
- NodeJs
- npm
- VueJs

## Installation & Utilisation

```.sh
git clone https://github.com/marcfouque/paparc.git
```

### sources non-"compilés"

```shell
cd paparc\clientCancerPrimaire
```

#### VueJs non installé

```shell
npm install
```

#### Compilation des sources

```shell
cd paparc\client_cp
npm install
npm run build
cd dist
```
ou

```shell
cd paparc\client_cp
npm install
vue build
cd dist
```

### Utilisation
Ouvrir le fichier <i>index.html</i> du repertoire <i>dist/</i> créé par la compilation.
Recherche au travers de la barre de recherche (recherche par prénom, nom et ou identifiant).
