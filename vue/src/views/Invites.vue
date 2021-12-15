<template>
  <div>
    <navigation />
    <invite-options />
    <!-- <img id="gif" v-if="isLoading" src="../assets/loadingImg.gif"/> -->
    <div id="header">
    </div>
    <div id="footer">
      <div id="review">
        <a id="yelpLink" href="https://www.yelp.com/" target="_blank">
        Powered by
          <img id="yelpLogo" src="@/assets/YelpLogo.png" alt="Yelp Logo"/>
        </a>
      </div>
    </div>
  </div>
</template>

<script>
import yelpService from '../services/YelpService.js'
import InviteOptions from '../components/InviteOptions.vue'
import navigation from '../components/Navigation.vue'

export default {
  data() {
    return {
      isLoading: true
    }
  },
  components: {InviteOptions,
  navigation},
  computed: {},
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
#yelpLink {
  display: block;
  margin-right: auto;
  padding: 4px;
  color: #ffffff;
  text-align: right;
  position: absolute;
  right: 0;
  bottom: 0;
}
#yelpLogo {
  height: 50px;
  max-width: 100%;
}
  /* #header {
  font-size: 20pt;
  font-weight: bold;
  display: flex;
  text-align: center;
  align-self: center;
  flex-basis: 100%;
  justify-content: center;
  flex-wrap: wrap;
}

#review {
  margin-top: 10px;
  align-self: center;
  color: rgb(254, 254, 254);
  font-size: 20pt;
}
#app {
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
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
#footer {
  display: flex;
} */
</style>