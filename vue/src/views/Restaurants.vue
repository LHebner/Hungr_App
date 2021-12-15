<template>
  <div>
    <navigation />
    <restaurant-card />
  </div>
</template>

<script>
import RestaurantCard from '../components/RestaurantCard.vue';
import navigation from '../components/Navigation.vue'

export default {
  components: { RestaurantCard,
  navigation },
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