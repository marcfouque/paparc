<template>
  <div id="app">
    <BarreDeRecherche />
    <Resultat msg="tftyfg"/>
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->

  </div>

</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import BarreDeRecherche from './components/BarDeRecherche.vue'
import Resultat from './components/Resultat.vue'
//import 'vue-suggestion/dist/vue-suggestion.css';
//import Testouille from "./components/Testouille.vue"


export default {
  name: 'app',
  components: {
    /*HelloWorld,*/
    BarreDeRecherche,
    Resultat,
    //Testouille
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: auto auto;
  width:75%;
}
</style>
