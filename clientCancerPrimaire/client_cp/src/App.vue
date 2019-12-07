<template>
  <div id="app">
    <BarreDeRecherche />
    <Resultat v-bind:users="users" />
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import BarreDeRecherche from "./components/BarDeRecherche.vue";
import Resultat from "./components/Resultat.vue";
//import 'vue-suggestion/dist/vue-suggestion.css';
//import Testouille from "./components/Testouille.vue"
import axios from "axios";

export default {
  name: "app",
  components: {

    BarreDeRecherche,
    Resultat

  },
  data: function() {
    return {
      users: []
    };
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
