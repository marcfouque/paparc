<template>
  <div class="hello">
    <h2>
      Barre de recherche
      </h2>
                  <ItemRecherche :item='{"id":10,"prenom":"marco","nom":"polo"}' />

      <VueSuggestion :items="items" v-model="item" :setLabel="setLabel" :itemTemplate="ItemRecherche" @onInputChange="inputChange" @onItemSelected="itemSelected" ></VueSuggestion>
      {{item}}
      <!--
      -->
  </div>
</template>

<script>
import VueSuggestion from 'vue-suggestion'
import ItemRecherche from './ItemRecherche.vue'

export default {
  name: 'BarDeRecherche',
  components: {
    VueSuggestion,
    ItemRecherche
  },
  data () {
    return {
      item: {id:42,prenom:"amerigo",nom:"vespucci"},
      items:[
        { id: 1, nom: 'nom1', prenom:"prenom1"},
        { id: 2, nom: 'nom2', prenom:"prenom2" },
        { id: 3, nom: 'nom3', prenom:"prenom3"},
        { id: 0, nom: 'rrr', prenom:"bbbb"}
      ],
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
      this.item = item;
    },
    setLabel (item) {
      return item.id+" - "+item.prenom+" "+item.nom;
    },
    inputChange (text) {
      //alert(this.listePat)
      alert(this.listePat.filter(item => Object.values(item).join("").contains(text)));
      //this.items = this.listePat.filter(item => (Object.values(item).join("")).contains(text));
    }
  }
}
</script>

<style scoped>
  h2{
    background-color:red;
  }
</style>
