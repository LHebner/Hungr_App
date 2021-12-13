<template>
  <div id="app">
    <img id="gif" v-if="isLoading" src="../assets/loadingImg.gif"/>
    <div id="header">
      <div id="review">Data provided by </div>
      <a id="link" href="https://www.yelp.com/" target="_blank">
        <img id="yelpLogo" src="@/assets/YelpLogo.png" alt="Yelp Logo"/>
      </a>
    </div>
    <restaurant-info :restaurant="r" :key="r.id" v-for="r in theRestaurants" />
  </div>
</template>

<script>
import RestaurantInfo from '../components/RestaurantInfo.vue'
import yelpService from '../services/YelpService.js'

export default {
  data() {
    return {
      isLoading: true
    }
  },
  components: {
    RestaurantInfo
  },
  computed: {
    theRestaurants() {
      return this.$store.state.favorites;
    }
  },
  created() {
    this.isLoading = true;
    yelpService.getInvites().then( (response) => {
      this.isLoading = false;
      this.$store.commit("MAKE_FAVORITES", response.data);
    });
  }
}
</script>

<style scoped>
  #header {
  font-size: 20pt;
  font-weight: bold;
  display: flex;
  text-align: center;
  align-self: center;
  flex-basis: 100%;
  justify-content: center;
  flex-wrap: wrap;
}
#yelpLogo {
  display: flex;
  max-width: 320px;
}
#review {
  margin-top: 10px;
  align-self: center;
  color: rgb(254, 254, 254);
  font-size: 20pt;
}
#app {
  display: flex;
  flex-wrap: wrap;
  background-size: cover;
  height: 100vh; 
  justify-content: space-evenly;
}
#gif {
  display: flex;
  align-self: center;
  width: 200px;
  margin-top: 10px;
}
</style>