<template>
  <div id="body"> 
      <h1 id="listTitle">Here are some restaurants you may like!</h1>
      <ul id="restaurantList">
        <li id="searchResults" v-for="business in getRestaurants" :key="business.id">
          <a :href="business.url" target="_blank" id="name">{{ business.name }}</a>
          <div id="contact">
          <div id="phone">{{ business.display_phone }}</div>
          <div id="location">{{ business.location.display_address[0] }}</div>
          <div id="location">{{ business.location.display_address[1] }}</div>
          </div>
          <img id="foodPic" :src="business.image_url"/>
          <button id="invite" v-on:click.prevent="invite()">Invite</button>
        </li>
        </ul>
    </div>
</template>

<script>

export default {
  name: "restaurant-card",
  data() {
    return {
      business: {
        zipCode: '',
        category: '',
        radius: ''
      },
    };
  },
  methods: {
    invite() {
      this.$router.push("/invites");
    },
    // addToInvite() {
    //   yelpService.addInvites(this.$store.state.restaurants[0].id).then( (response) => {
    //     if (response.status === 201) {
    //       this.$store.commit("REMOVE_RESTAURANT");
    //       if (this.$store.state.restaurants[0] == null) {
    //         this.$router.push({
    //           path: "/restaurants",
    //           query: {matches: "empty"},
    //         });
    //       } else {
    //         this.restaurant = this.$store.state.restaurants[0];
    //       }
    //     }
    //   });
    // },
    // addReject() {
    //   this.$store.commit("ADD_REJECTS", this.restaurant);
    //   this.$store.commit("REMOVE_RESTAURANT");
    //   if (this.$store.state.restaurants[0] == null) {
    //     this.$router.push({
    //       path: "/restaurants",
    //       query: {matches: "empty"},
    //     });
    //   } else {
    //     this.restaurant = this.$store.state.restaurants[0];
    //   }
    // },
    created() {
    //   this.restaurant = this.$store.state.restaurants[0];
    //   if (this.restaurant == null) {
    //     this.$router.push({
    //       path: "/restaurants",
    //       query: {matches: "none"},
    //     });
    //   }
    }
  },
  computed: {
    getRestaurants() {
      return this.$store.state.restaurants
    }
  }
};
</script>

<style>
  #body{
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  }
  #listTitle {
    text-align: center;
    color: #ffffff;
  }
  #restaurantList {
    font-size: 30px;
    font-weight: bold;
    text-align: center;
  }
  
  #searchResults {
    display: grid;
    grid-template-columns: 2fr 2fr 2fr 1fr;
    column-gap: 20px;
    align-items: center;
    justify-content: center;
    width: 70%;
    background-color: rgba(255, 255, 255, 0.95);
    border-radius: 10px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    padding: 35px 50px;
    margin: 35px auto 0 auto;
    color: rgb(63, 63, 63);
    letter-spacing: 0.5px;

  }
  #name {
    font-size: 45px;
    text-align: center;
    color: #ec4c4c;
    margin: 0 5px;
    text-decoration: none;
  }
  #contact {
    width: 250px;
    text-align: center;
  }
  #phone {
    line-height: 50px;
  }
  #foodPic {
    border: 1px solid #ddd;
    border-radius: 4px;
    padding: 5px;
    height: 10rem;
    max-width: 100%;
  }
  #invite {
    margin-top: 50px;
    width: 100px;
    background-color: rgb(0, 187, 0);
    color: white;
    padding: 15px 0;
    font-size: 18px;
    font-weight:bold;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
</style>