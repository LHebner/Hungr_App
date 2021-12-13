<template>
  <div class="fav">
    <div id="card" class="business-summary" :restaurant="restaurant">
      <a id="link" :href="`${restaurant.url}`" target="_blank">
        <h1 id="name">{{restaurant.name}}</h1>
        <div id="contact">
          <h2> {{restaurant.location.display_address[0]}} <br>
            {{restaurant.location.display_address[1]}}</h2>
          <h2>{{restaurant.display_phone}}</h2>
        </div>
      </a>
      <div id="bottomRow">
        <img id="stars" :src="getStars" />
        <button id="removeButton" v-on:click.prevent="submit">Remove from list</button>
      </div>
    </div>
  </div>
</template>

<script>
import YelpService from '../services/YelpService'

export default {
  name: "business-info",
  props: {
    restaurant: {
      id: String,
      name: String,
      location: Array,
      display_phone: String,
      rating: Number
    }
  },
  methods: {
    submit() {
      YelpService.deleteInvites(this.restaurant.id);
      location.reload();
    }
  },
  computed: {
      getStars() {
        const rating = this.restaurant.rating;
        if (rating == 0.0) {
          return require("@/assets/small_0.png");
        } else if (rating == 1.0) {
          return require("@/assets/small_1.png");
        } else if (rating == 1.5) {
          return require("@/assets/small_1_half.png");
        } else if (rating == 2.0) {
          return require("@/assets/small_2.png");
        } else if (rating == 2.5) {
          return require("@/assets/small_2_half.png");
        } else if (rating == 3.0) {
          return require("@/assets/small_3.png");
        } else if (rating == 3.5) {
          return require("@/assets/small_3_half.png");
        } else if (rating == 4.0) {
          return require("@/assets/small_4.png");
        } else if (rating == 4.5) {
          return require("@/assets/small_4_half.png");
        } else {
          return require("@/assets/small_5.png");
        }
    }
  }
}
</script>

<style>
</style>