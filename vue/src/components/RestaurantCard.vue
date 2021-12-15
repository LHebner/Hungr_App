<template>
  <div>
      <h1 id="name">{{restaurant.name}}</h1>
      <div id="contact">
          <p id="phone">{{restaurant.display_phone}}</p>
          <p id="address">{{restaurant.location}}</p>
      </div>
      <button id="invite">invite</button>
  </div>
</template>

<script>
import yelpService from "../services/YelpService"

export default {
    name: "restaurant-card",
    components: {},
    data() {
        return {
            restaurant: ''
        };
    },
    methods: {
        getRestaurant() {
            yelpService.CreateRestaurants(this.restaurant)
        }
    }, 
    computed: {},
}
</script>

<style>

</style>