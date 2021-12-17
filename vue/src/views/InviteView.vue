<template>
    <div>
        <navigation />
    <div id="inviteMain">
        <h1>You've Been Invited!</h1>
        <div id="Like">
            <button id="Like" v-on:click.prevent="Like()">👍</button>
        </div>
        <div id="Dislike">
            <button id="Dislike" v-on:click.prevent="Like()">👎</button>
        </div>
    </div>
  </div>
</template>

<script>
import yelpService from '../services/YelpService.js'
import Navigation from '../components/Navigation.vue'
import userService from '../services/UserService.js'

export default {
    name: "invite-view",
    components: {Navigation},
    data() {
        return {
            inviteList : [],
        }
    },
    methods: {
        Like(businessId, inviteId) {
            yelpService.restaurantVote(businessId, true).then((response) => {
                if (response.status === 200) {
                    yelpService.getEventDetails(inviteId).then((response) => {
                        this.eventDetails = response.data;
                    });
                }
            });
        },
        Dislike(businessId, inviteId) {
            yelpService.getEventDetails(inviteId);
            yelpService.restaurantVote(businessId, false).then((response) => {
                if (response.status === 200) {
                    yelpService.getEventDetails(inviteId).then((response) => {
                        this.eventDetails = response.data;
                    });
                }
            });
        },
        GetPopularity(likes, dislikes) {
            return likes - dislikes;
        },
    },
    created() {
        userService.getAllInvites()
        .then( response => {
            this.inviteList = response.data
        })
    }
};
</script>

<style>
body {
  background-color: #ec4c4c;
}
#inviteMain{
  height: auto;
  width: 60%;
  margin-top: 35px;
  background-color: rgb(255, 255, 255, .95);
  position: absolute;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
  border-radius: 10px;
  backdrop-filter: blur(10px);
  border: 2px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0 0 40px rgba(8,7,16,0.6);
  padding: 50px 35px;
}
#inviteMain * {
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: black;
  letter-spacing: 0.5px;
  outline: none;
  border: none;
}
#inviteMain h1 {
  font-size: 32px;
  font-weight: bold;
  line-height: 42px;
  text-align: center;
}
#inviteMain button {
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
#Like button{
    background-color: rgb(0, 185, 0);
}
#Dislike button {
    background-color: rgb(255, 43, 43);;
}
</style>