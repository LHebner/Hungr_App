<template>
  <div>
    <h1>RestaurantList</h1>
    <!-- <restaurant-list /> -->
  </div>
</template>

<script>
// import RestaurantList from '../components/RestaurantList.vue'
// import RestaurantCard from '../components/RestaurantCard.vue'
// import YelpService from '../services/YelpService.js'

export default {
//   name: "Restaurants",
//   components: { 
//     RestaurantList
//   },
  mounted() {
    this.getRestaurants;
  },
  methods: {
    getRestaurants() {
      console.log(this.$store.state.restaurants);
    }
  },
}
</script>

<style scoped>
  
</style>