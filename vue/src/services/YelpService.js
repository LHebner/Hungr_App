import axios from 'axios';

// const http = axios.create({
//   baseURL: "https://api.yelp.com/v3/businesses/search"
// });

export default {

  getRestaurantsNoRadius(zipCode, category) {
    return axios.get(`/businesses?zipCode=${zipCode}&category=${category}`)
  },
  getRestaurantsWithRadius(zipCode, category, radius) {
    return axios.get(`/business?zipCode=${zipCode}&category=${category}&radius=${radius}`)
  },
  CreateRestaurants(restaurants) {
    let exportRestaurants = [];
    restaurants.forEach(restaurant => {
        let currentRestaurant = {};
        currentRestaurant.restaurantName = restaurant.name;
        currentRestaurant.yelpRestaurantId = restaurant.id;
        currentRestaurant.restaurantStreetAddress = restaurant.location.address1;
        currentRestaurant.restaurantCity = restaurant.location.city;
        currentRestaurant.restaurantState = restaurant.location.state;
        currentRestaurant.restaurantZip = restaurant.location.zip_code;
        currentRestaurant.category = restaurant.categories[0].title;
        currentRestaurant.phoneNumber = restaurant.display_phone;
        currentRestaurant.photoUrl = restaurant.image_url;
        exportRestaurants.push(currentRestaurant);
    });
    return axios.post(`/restaurants`, exportRestaurants)
},
  // getBusinessByID(businessID) {
  //   return axios.get(`/businesses/${businessID}`)
  // },
  // getReviews(businessID) {
  //   return axios.get(`/reviews/${businessID}`)
  // },
  addInvites(businessID) {
    return axios.post(`/invites/${businessID}`)
  },
  getInvites() {
    return axios.get('/invites')
  },
  deleteInvites(businessID) {
    return axios.delete(`/invites/${businessID}`)
  }
}