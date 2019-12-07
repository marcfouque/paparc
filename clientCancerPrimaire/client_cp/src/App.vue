<template>
  <div id="app">
    <BarreDeRecherche @patient_choisi="changePatientChoisi" />
    <Resultat :patient="patient"/>
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->

  </div>

</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import BarreDeRecherche from './components/BarDeRecherche.vue'
import Resultat from './components/Resultat.vue'



export default {
  name: 'app',
  components: {
    /*HelloWorld,*/
    BarreDeRecherche,
    Resultat,
    //Testouille
  },
  data () {
    return {
      patient: {}
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
