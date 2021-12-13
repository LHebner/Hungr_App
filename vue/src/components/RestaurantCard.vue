<template>
  <div id="container">
    <div id="row">
      <button id="noThanks" type="submit" @click.prevent="addReject">
        <div id="crossMark">❌</div>
      </button>
      <div class="card">
        <h1 id="name"> {{restaurant.name}} </h1>
        <div id="imgGroup">
          <img id="image" v-if="restaurant.image_url != ''" :src="`${restaurant.image_url}`" />
          <img id="image" alt="No Image Available" />
          <div id="yelpPrice">
            <a id="link" href="https://www.yelp.com/" target="_blank">
              <img id="yelpLogo" src="@/assets/YelpLogo.png" alt="Yelp Logo">
            </a>
            <p id="price">Price: {{restaurant.price}} </p>
          </div>
        </div>
        <div id="midRow">
          <p id="contacts">
            {{restaurant.location.display_address[0]}} <br>
            {{restaurant.location.display_address[1]}} <br>
            {{restaurant.location.display_phone}}
          </p>
          <a id="reviews" href="`${restaurant.url}`" target="_blank">
            Reviews: {{restaurant.review_count}} <br>
            See this restaurant's reviews!
          </a>
      </div>
      <img id="stars" :src="getStars" />
    </div>
    <button id="yesPlease" type="submit" @click.prevent="addToInvite">
      <div id="checkMark">✔️</div>
    </button>
    </div>
  </div>
</template>

<script>
import yelpService from '../services/YelpService.js';

export default {
  name: "restaurant-card",
  data() {
    return {
      restaurant: '',
    };
  },
  methods: {
    addToInvite() {
      yelpService.addInvites(this.$store.state.restaurants[0].id).then( (response) => {
        if (response.status === 201) {
          this.$store.commit("REMOVE_RESTAURANT");
          if (this.$store.state.restaurants[0] == null) {
            this.$router.push({
              path: "/invites",
              query: {matches: "empty"},
            });
          } else {
            this.restaurant = this.$store.state.restaurants[0];
          }
        }
      });
    },
    addReject() {
      this.$store.commit("ADD_REJECTS", this.restaurant);
      this.$store.commit("REMOVE_RESTAURANT");
      if (this.$store.state.restaurants[0] == null) {
        this.$router.push({
          path: "/invites",
          query: {matches: "empty"},
        });
      } else {
        this.restaurant = this.$store.state.restaurants[0];
      }
    },
    created() {
      this.restaurant = this.$store.state.restaurants[0];
      if (this.restaurant == null) {
        this.$router.push({
          path: "/invites",
          query: {matches: "none"},
        });
      }
    }
  },
  computed: {
    getStars() {
      const rating = this.restaurant.rating;
      if (rating == 0.0) {
        return require("@/assets/extra_large_0.png");
      } else if (rating == 1.0) {
        return require("@/assets/extra_large_1.png");
      } else if (rating == 1.5) {
        return require("@/assets/extra_large_1_half.png");
      } else if (rating == 2.0) {
        return require("@/assets/extra_large_2.png");
      } else if (rating == 2.5) {
        return require("@/assets/extra_large_2_half.png");
      } else if (rating == 3.0) {
        return require("@/assets/extra_large_3.png");
      } else if (rating == 3.5) {
        return require("@/assets/extra_large_3_half.png");
      } else if (rating == 4.0) {
        return require("@/assets/extra_large_4.png");
      } else if (rating == 4.5) {
        return require("@/assets/extra_large_4_half.png");
      } else {
        return require("@/assets/extra_large_5.png");
      }
    }
  }
};
</script>

<style>

</style>