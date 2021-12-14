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
  getBusinessByID(businessID) {
    return axios.get(`/businesses/${businessID}`)
  },
  getReviews(businessID) {
    return axios.get(`/reviews/${businessID}`)
  },
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