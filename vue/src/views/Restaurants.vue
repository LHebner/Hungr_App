<template>
  <div>
    <restaurant-card />
  </div>
</template>

<script>
import RestaurantCard from '../components/RestaurantCard.vue';
// import RestaurantList from '../components/RestaurantList.vue'

// import YelpService from '../services/YelpService.js'

export default {
  components: { RestaurantCard },
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