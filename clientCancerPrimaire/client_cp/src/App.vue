<template>
  <div id="app">
    <BarreDeRecherche @patient_choisi="changePatientChoisi"/>
    <Resultat v-bind:users="users" />
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'

import BarreDeRecherche from "./components/BarDeRecherche.vue";
import Resultat from "./components/Resultat.vue";
import axios from "axios";

export default {
  name: "app",
  components: {

    BarreDeRecherche,
    Resultat,
  },
  data () {
    return {
		patient: {},
		users: []
    }
  },
  methods:{
    changePatientChoisi(e){
      //a la selection du patient recherche des cancers primaires
      /*
     axios.get(`http://....`)
     .then(response => {
       //on met tout dans des variables qui sont passées à Resultat
     })
     .catch(e => {
       this.errors.push(e)
     })
     */
      this.patient=e;
    }
	},
  // Librairie axios permet d'utiliser et d'afficher des données provenant d'une API
  // Test à partir d'un fichier Json répertoriant les utilisateurs d'un site
  mounted: function() {
    axios
      .get("https://jsonplaceholder.typicode.com/users")
      .then(response => {
        this.users = response.data;
        
      })
      .catch(error => {
        this.errors.push(error);
      });
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: auto auto;
  width: 75%;
}
</style>
