<template>
  <vue-suggestion :items="items"
                  v-model="item"
                  :setLabel="setLabel"
                  :itemTemplate="itemTemplate"
                  @onInputChange="inputChange"
                  @onItemSelected="itemSelected">
  </vue-suggestion>
</template>

<script>
import itemTemplate from './ItemRecherche.vue';
export default {
  data () {
    return {
      item: {},
      items: [
        { id: 1, name: 'Golden Retriever'},
        { id: 2, name: 'Cat'},
        { id: 3, name: 'Squirrel'},
      ],
      itemTemplate,
    }
  },
  methods: {
    itemSelected (item) {
      this.item = item;
    },
    setLabel (item) {
      return item.name;
    },
    inputChange (text) {
      // your search method
      this.items = items.filter(item => item.name.contains(text));
      // now `items` will be showed in the suggestion list
    },
  },
};
</script>
