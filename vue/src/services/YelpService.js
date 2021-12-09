import axios from 'axios';

const http = axios.create({
  baseURL: "https://api.yelp.com/v3/businesses/search"
});

export default {

  getByZip(zipCode) {
    return http.get(`?location=${zipCode}`);
  },

  getByCity(city) {
    return http.get(`?location=${city}`);
  }
}