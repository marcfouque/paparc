<template>
  <div class="hello">
    <h2>Les resultats {{msg}}</h2>

  </div>
</template>

<script>
export default {
  name: 'Resultat',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h2 {
  background-color:blue;
  height: 400px;
}

</style>
