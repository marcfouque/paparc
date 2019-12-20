<template>
  <div class="container mt-4" id="app">
            <strong>Patient : id={{patient.id}}, Nom={{patient.nom}}, Prenom={{patient.prenom}}</strong>
    <section class="d-inline-flex justify-content-around">
      <table class="table table-bordered macl">
        <caption>Cancers</caption>
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Groupe Morpho</th>
            <th scope="col">Groupe Topo</th>
            <th scope="col">Libellé Morpho</th>
            <th scope="col">Libellé Topo</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(cancer, index) in patient.cancersPrimaires" v-bind:key="index">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ cancer.morpho }}</td>
            <td>{{ cancer.topo }}</td>
            <td>{{ cancer.libelleMorpho }}</td>
            <td>{{ cancer.libelleTopo }}</td>
          </tr>
          <tr v-for="(cancer, index) in patient.cancersPrimaires" v-bind:key="index">
            <th scope="row">{{ 3+ index + 1 }}</th>
            <td>{{ cancer.morpho }}</td>
            <td>{{ cancer.topo }}</td>
            <td>{{ cancer.libelleMorpho }}</td>
            <td>{{ cancer.libelleTopo }}</td>
          </tr>
        </tbody>
      </table>
      <table class="table table-bordered macla">
        <caption>Cancers Primaires</caption>
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Groupe Morpho</th>
            <th scope="col">Groupe Topo</th>
            <th scope="col">Libellé Morpho</th>
            <th scope="col">Libellé Topo</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(cancer, index) in patient.cancersPrimaires" v-bind:key="index">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ cancer.morpho }}</td>
            <td>{{ cancer.topo }}</td>
            <td>{{ cancer.libelleMorpho }}</td>
            <td>{{ cancer.libelleTopo }}</td>
          </tr>
        </tbody>
      </table>
    </section>
  </div>
</template>

<script>
export default {
  name: "Resultat",
  props: {
    patient: Object,
    index: Number,
  },
  data() {
    return {
      donnees:{},
      //cancers:[]
    };
  },
  mounted: function(){
    console.log(Object.toString(this.patient))
    console.log(Object.keys(this.patient)[0])
    //this.cancers=this.patient.cancers;
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  caption{
    caption-side: top;
    text-align :center;
  }
  section{
    position:relative;
    height: 100%;
  }
  .macl{
    margin-right:2%;
  }
  .macla{
    margin-left:2%;
  }
</style>
