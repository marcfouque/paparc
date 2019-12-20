<template>
  <div id="app">
    <BarreDeRecherche @patient_choisi="changePatientChoisi"/>
    <h3 v-if="!affTab">Selectionnez un patient pour afficher ses cancers primaires</h3>
    <Resultat v-else v-bind:patient="patient" />
  </div>
</template>

<script>

import BarreDeRecherche from "./components/BarDeRecherche.vue";
import Resultat from "./components/Resultat.vue";

// import fichier json
import TOPO from '../resources/jsonTopo.json';
import MORPHO from '../resources/jsonMorpho.json';

export default {
  name: "app",
  components: {

    BarreDeRecherche,
    Resultat,
  },
  data () {
    return {
		patient: {"id":"","nom":"","prenom":"","cancers":[],"cancersPrimaires":[]},
    affTab:false
    }
  },

  methods:{
    changePatientChoisi(p){
      for(let i=0;i<p['cancersPrimaires'].length;i++){
        p['cancersPrimaires'][i]['libelleTopo']=TOPO[p['cancersPrimaires'][i]['topo']];
        p['cancersPrimaires'][i]['libelleMorpho']=MORPHO[p['cancersPrimaires'][i]['morpho']];
      }
      this.patient = p;
      this.affTab = true;
    }
  },
  mounted: function(){
    //this.patient=patients["837404"]
    //this.patient["id"]="837404"
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
}
</style>
