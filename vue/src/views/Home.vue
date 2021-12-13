<template>
  <div class="home">
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
      <button id="customSearch" type="submit" v-on:click.prevent="search()">Search</button>
    </form>
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
      if (this.business.radius === '') {
        yelpService.getRestaurantsNoRadius(this.business.zipCode, this.business.category)
        .then( (response) => {
          this.$store.commit("ADD_RESTAURANTS", response.data);
          this.$router.push("/restaurants");
        });
      } else {
        yelpService.getRestaurantsWithRadius(this.business.zipCode, this.business.category, 
        this.business.radius).then( (response) => {
          this.$store.commit("ADD_RESTAURANTS", response.data);
          this.$router.push("/restaurants");
        });
      }
    }
  }
};
</script>

<style>

</style>