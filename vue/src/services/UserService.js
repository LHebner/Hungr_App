import axios from 'axios'

export default {

  getAllUsers() {
    return axios.get('/users')
  },
  getAllInvites() {
    return axios.get('/invites')
  },
  sendInvite(invite) {
    return axios.post('/invites', invite)
  }
}