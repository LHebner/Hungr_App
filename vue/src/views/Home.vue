<template>
  <div class="home">
    <navigation/>
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
        <button id="customSearch" type="submit" v-on:click.prevent="search()">
          Search
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import yelpService from '../services/YelpService.js'
import navigation from '../components/Navigation.vue'

export default {
  name: 'restaurant-search',
  data() {
    return {
      business: {
        zipCode: '',
        category: '',
        radius: ''
      },
    };
  },
  components: {navigation},
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
        this.$router.push("/restaurants")
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
  }
};
</script>

<style>
.home {
  height: auto;
}
  #questionnaire {
    height: auto;
    width: 60%;
    background-color: rgba(255, 255, 255, 0.95);
    position: absolute;
    transform: translate(-50%, -25%);
    top: 50%;
    left: 50%;
    border-radius: 10px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    padding: 50px 35px;
    }

    #questionnaire * {
      font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
      color: black;
      letter-spacing: 0.5px;
      outline: none;
      border: none;
    }

  #zipMessage {
    font-size: 32px;
    font-weight: bold;
    line-height: 42px;
    text-align: center;
  }

  #distanceRadius {
    width: 25%;
    color: black;
  }
  #distanceRadius option {
    color: black;
  }

  #soundsGood {
    text-align: center;
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

  #customSearch {
    margin-top: 50px;
    width: 100%;
    background-color: #dddddd;
    color: #080710;
    padding: 15px 0;
    font-size: 18px;
    font-weight:bold;
    border-radius: 5px;
    cursor: pointer;
  }
</style>