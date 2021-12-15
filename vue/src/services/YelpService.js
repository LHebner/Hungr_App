import axios from 'axios';

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
  createEvent(invite) {
    return axios.post(`invites/save`, invite)
  },
  getEvents() {
    return axios.get(`/invites`)
  },
  getEventById(eventId) {
    return axios.get(`/invites/${eventId}`)
  },
  getEventDetails(eventId) {
    return axios.get(`/invites/${eventId}/restaurants`)
  },
  addRestaurants(businessID) {
    return axios.post(`/invites/${businessID}`)
  },
  getInvites() {
    return axios.get('/invites')
  },
  deleteInvites(businessID) {
    return axios.delete(`/invites/${businessID}`)
  }
}