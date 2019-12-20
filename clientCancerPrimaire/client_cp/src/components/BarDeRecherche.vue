<template>
  <div class="barrederecherche">
      <ItemRecherche id="griffin" :item='{"id":10,"prenom":"marco","nom":"polo"}' />

      <VueSuggestion
        :items="items"
        v-model="patientSelectionne"
        :setLabel="setLabel"
        :itemTemplate="ItemRecherche"
        @onInputChange="inputChange"
        @onItemSelected="itemSelected"
        key="'obj'+obj.key"
        placeholder="Recherche patient"
        >
      </VueSuggestion>
      <small>{{patientSelectionne}}</small>
      <!--
      -->
  </div>
</template>

<script>
import VueSuggestion from 'vue-suggestion'
import ItemRecherche from './ItemRecherche.vue'
var DONNEES = require('../../resources/patientIACR_topomorphoExemple.json')

export default {
  name: 'BarDeRecherche',
  components: {
    VueSuggestion,
    ItemRecherche
  },
  data () {
    return {
      patientSelectionne: "",
      items:[],
      listePat: [
        { id: 1, nom: 'nom1', prenom:"prenom1"},
        { id: 2, nom: 'nom2', prenom:"prenom2" },
        { id: 3, nom: 'nom3', prenom:"prenom3"},
        { id: 0, nom: 'rrr', prenom:"bbbb"},
      ],
      ItemRecherche,
    }
  },
  methods: {
    itemSelected (item) {
      this.patientSelectionne = item;
      this.$emit('patient_choisi', item)

      this.items=[];
      //alert("requete ajax vers l'api pour récupérer les informations du patient")
    },
    setLabel (item) {
      return item.id+" - "+item.prenom+" "+item.nom;
    },
    inputChange (text) {
      this.items = this.listePat.filter(item => Object.values(item).join("").toLowerCase().search(text.toLowerCase())!=-1);
    }
  },
   created() {
     //a la creation de l'element recupération liste patient
     /*
    axios.get(`http://....`)
    .then(response => {
      this.listePat = response.data
    })
    .catch(e => {
      this.errors.push(e)
    })
    */
    let temp = Object.keys(DONNEES).map(x => DONNEES[x]);
    for(let p=0; p<temp.length; p++)temp[p]["id"]=Object.keys(DONNEES)[p];
    this.listePat = temp;
  }
}
</script>

<style >
#griffin{
  display:none;
}
.vue-suggestion .vue-suggestion-input-group .vue-suggestion-input {
  display: block;
  width: 50%;
  margin: 0 auto;
  padding: 0.5rem 0.7rem;
  font-size: 0.9rem;
  line-height: 1.25;
  color: #464a4c;
  outline: none;
  background-color: #fff;
  background-image: none;
  background-clip: padding-box;
  border: 1px solid #cecece;
  border-radius: 0.25rem;
  transition: border-color ease-in-out 0.15s, box-shadow ease-in-out 0.15s;
}
.vue-suggestion-input:focus {
  border: 1px solid #023d7b;
}
.vue-suggestion-list {
  width: 100%;
  text-align: left;
  border: none;
  border-top: none;
  max-height: 400px;
  overflow-y: auto;
  border-bottom: 1px solid #023d7b;
}
.vue-suggestion-list-item {
  cursor: pointer;
  background-color: #fff;
  padding: 10px;
  border-left: 10px solid #023d7b;
  border-right: 1px solid #023d7b;
}
.vue-suggestion-list-item:last-child {
  border-bottom: none;
}
.vue-suggestion-list-item:hover {
  background-color: #eee;
}
.barrederecherche{
  padding-top:30px;
}
</style>
