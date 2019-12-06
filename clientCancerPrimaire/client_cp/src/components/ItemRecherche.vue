<template>
  <div>
    <b>#{{item.id}}</b> -
    <span>{{ item.prenom }} </span>
    <span>{{ item.nom }}</span>
  </div>
</template>

<script>
export default {
  name:"ItemRecherche",
  props: {
    item: { required: true},
  }
}
</script>
