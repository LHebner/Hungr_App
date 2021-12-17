import axios from 'axios'

export default {

  getAllUsers() {
    return axios.get('/users')
  },
  getUserById(id) {
    return axios.get(`/users/${id}`)
  },
  getAllInvites() {
    return axios.get('/invites')
  },
  sendInvite(invite) {
    return axios.post('/invites', invite)
  }
}