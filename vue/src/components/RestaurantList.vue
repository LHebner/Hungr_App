<template>
  <div>
    <h1>Restaurant List</h1>
  </div>
</template>

<script>
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)

export default {
  name: "restaurant-list",
  mounted() {
    Vue.axios.get('https://api.yelp.com/v3/businesses/search?location=45701&term=seafood&radius=32000')
      .then( (response) => {
        console.warn(response)
      })
  }
}
</script>

<style>
</style>