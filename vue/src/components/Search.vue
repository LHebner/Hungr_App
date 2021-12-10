<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="location">City/Zip Code</label>
      <input type="text" name="location" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="getByZip()">Search</button>
    </div>
  </form>
</template>

<script>
import YelpService from '@/services/YelpService.js';

export default {
  name: 'restaurant-list',
  methods: {
    getRestaurants() {
      YelpService.getByZip(zipCode).then( (response) => {
        this.restaurants = response.data;
      });
    },
  }
}
</script>

<style>
</style>