<template>
  <div class="home">
    <div id="questionnaire">
      <form>
        <div id="zipCode">
          <h1 id="zipMessage">Enter your ZIP code!</h1>
          <br>
          <input id="zipInput" v-model="business.zipCode" type="text"
            placeholder="ex. 45701" maxlength="5" minlength="5" pattern="[0-9]*" />
        </div>
        <div id="distanceOptions">
          <h2 id="distance">Looking for food within</h2>
          <div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
          <select id="distanceRadius" v-model="business.radius" >
            <option value=''>Any Distance</option>
            <option value='1610'>1 Mile</option>
            <option value='8050'>5 Miles</option>
            <option value='16100'>10 Miles</option>
            <option value='32200'>20 Miles</option>
          </select>
        </div>
        <div>
        <h1 id="soundsGood">What sounds good?</h1>
        <div id="category">
          <div>
            <input class="foodCategory" value="barbeque" name="barbeque" v-model="business.category" type="radio" />
            <label for="barbeque">Barbeque</label>
          </div>
          <div>
            <input class="foodCategory" value="chinese" name="chinese" v-model="business.category" type="radio" />
            <label for="chinese">Chinese</label>
          </div>
          <div>
            <input class="foodCategory" value="fast-food" name="fastfood" v-model="business.category" type="radio" />
            <label for="fastfood">Fast Food</label>
          </div>
          <div>
            <input class="foodCategory" value="fine-dining" name="finedining" v-model="business.category" type="radio" />
            <label for="finedining">Fine Dining</label>
          </div>
          <div>
            <input class="foodCategory" value="indian" name="indian" v-model="business.category" type="radio" />
            <label for="indian">Indian</label>
          </div>
          <div>
            <input class="foodCategory" value="italian" name="italian" v-model="business.category" type="radio" />
            <label for="italian">Italian</label>
          </div>
          <div>
            <input class="foodCategory" value="mexican" name="mexican" v-model="business.category" type="radio" />
            <label for="mexican">Mexican</label>
          </div>
          <div>
            <input class="foodCategory" value="pizza" name="pizza" v-model="business.category" type="radio" />
            <label for="pizza">Pizza</label>
          </div>
          <div>
            <input class="foodCategory" value="seafood" name="seafood" v-model="business.category" type="radio" />
            <label for="seafood">Seafood</label>
          </div>
          <div>
            <input class="foodCategory" value="steakhouse" name="steakhouse" v-model="business.category" type="radio" />
            <label for="steakhouse">Steakhouse</label>
          </div>
          <div>
            <input class="foodCategory" value="sushi" name="sushi" v-model="business.category" type="radio" />
            <label for="sushi">Sushi</label>
          </div>
          <div>
            <input class="foodCategory" value="thai" name="thai" v-model="business.category" type="radio" />
            <label for="thai">Thai</label>
          </div>
        </div>
        </div>
        <button id="customSearch" type="submit" v-on:click.prevent="search(); toggleQuestionnaire(); showSearchResults()">
          Search
        </button>
      </form>
    </div>
    <div id="searchResults">
      <ul id="restaurantList">restaurants serving {{ business.category }} in {{ business.zipCode }}</ul>
        <li v-for="business in this.$store.state.restaurants" :key="business.id">
          {{ business.name }}, {{ business.categories[0] }}, {{ business.location }}, 
          <img id="foodPic" :src="business.image_url"/>
        </li>
    </div>
  </div>
</template>

<script>
import yelpService from '../services/YelpService.js'

export default {
  name: 'business-search',
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
    changeCategory(category) {
      this.business.category = category;
    },
    search() {
      yelpService.getRestaurantsWithRadius(this.business.zipCode, this.business.category,
      this.business.radius).then( (response) => {
        this.$store.commit("ADD_RESTAURANTS", response.data);
        // this.$router.push("restaurants");
        console.log(this.$store.state.restaurants);
      }).catch( error => {
        if (error.response) {
          this.errorMsg = "Response received was '" + error.response.statusText + "'.";
        } else if (error.request) {
          this.errorMsg = "Server could not be reached.";
        } else {
          this.errorMsg = "Request could not be created.";
        }
          console.log(this.errorMsg)
      })
    },
    toggleQuestionnaire() {
      const questionnaire = document.getElementById("questionnaire");
      if (questionnaire.style.display === "none") {
        questionnaire.style.display = "block";
      } else {
        questionnaire.style.display = "none";
      }
    },
    showSearchResults() {
      const searchResults = document.getElementById("searchResults");
      searchResults.style.display = "block";
    },
  }
};
</script>

<style>
  #zipMessage {
    margin-top: 100px;
  }

  #distanceRadius {
    width: 25%;
    color: black;
  }

  #category {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
  }

  #category div {
    display: grid;
    grid-template-columns: 1fr 2fr;
    margin: 5px;
    height: 50px;
  }

  #category div input{
    height: 30px;
    align-self: center;
  }

  #category div label {
    font-size: 20px;
    text-align: left;
    margin-bottom: 10px;
  }
  #searchResults {
    display: none;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    color: #ffffff;
    letter-spacing: 0.5px;
    outline: none;
    border: none;
  }
  #restaurantList {
    font-size: 20px;
    font-weight: bold;
    text-align: center;
  }
  #foodPic {
    border: 1px solid #ddd;
    border-radius: 4px;
    padding: 5px;
    height: 10rem;
    max-width: 100%;
  }
  li {
    display: grid;
    display: block;
    height: 200px;
    font-size: 18px;
  }
</style>