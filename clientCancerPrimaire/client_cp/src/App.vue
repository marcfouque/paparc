<template>
  <div id="app">
    <BarreDeRecherche @patient_choisi="changePatientChoisi"/>
    <Resultat v-bind:patient="patient" />
  </div>
</template>

<script>

import BarreDeRecherche from "./components/BarDeRecherche.vue";
import Resultat from "./components/Resultat.vue";

// import fichier json
import patients from '../resources/patientListCancer.json';

export default {
  name: "app",
  components: {

    BarreDeRecherche,
    Resultat,
  },
  data () {
    return {
		patient: {}
    }
  },

  methods:{
    changePatientChoisi(e){
      
      this.patient=e;
    }
  },
  mounted: function(){
    this.patient=patients["837404"]
    this.patient["id"]="837404"
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
