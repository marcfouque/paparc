<template>
  <p >
    <b>{{item.id}}</b> -
    <span>{{ item.prenom }} </span>
    <span>{{ item.nom }}</span>
  </p>
</template>

<script>
export default {
  name:"ItemRecherche",
  props: {
    item: { required: true},
  }
}
</script>
<style>

</style>
