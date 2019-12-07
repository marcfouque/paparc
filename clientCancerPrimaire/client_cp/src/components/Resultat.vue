<template>
  <div class="container mt-4" id="app">
    <table class="table table-bordered">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Website</th>
          <th scope="col">City</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(user, index) in users" v-bind:key="index">
          <th scope="row">{{ index + 1 }}</th>
          <td>{{ user.name }}</td>
          <td>{{ user.email.toLowerCase() }}</td>
          <td>{{ user.website }}</td>
          <td>{{ user.address.city }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "Resultat",
  props: {
    msg: String,
    user: String,
    index: Number,
    users: Array
  },
  data() {
    return {
      data: null
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.table {
  background-color: white;
  height: 400px;
}
</style>
