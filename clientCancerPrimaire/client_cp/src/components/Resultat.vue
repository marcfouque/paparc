<template>
  <div class="hello">
    <h2>Patient {{patient}}</h2>

  </div>
</template>

<script>
export default {
  name: 'Resultat',
  props: {
    patient: Object
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
