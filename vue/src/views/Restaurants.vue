<template>
  <div>
    <h1>Food in your area</h1>
    <restaurant-card />
  </div>
</template>

<script>
import RestaurantCard from '../components/RestaurantCard.vue'

export default {
  components: { 
    RestaurantCard
  }
}
</script>

<style scoped>
</style>