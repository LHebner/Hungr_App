<template>
  <div v-if="this.$store.state.token != ''">
    <div id="nav" v-if="displayBar">
      <div id="spacerOne">&nbsp;</div>
      <div class="center">
        <router-link class="center" id="search" v-if="notSearch" :to="{name: 'home'}">
          New Search
        </router-link>
        <div class="center" id="pipe" v-if="displayPipe">|</div>
        <router-link class="center" id="invites" v-if="notInvites" :to="{name: 'invites'}">
          My Invites
        </router-link>
      </div>
      <div id="spacerTwo">&nbsp;</div>
      <router-link id="logOut" :to="{name: 'logout'}">Logout</router-link>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    notSearch() {
      return this.$route.name != 'home';
    },
    notInvites() {
      return this.$route.name != 'invites';
    },
    displayPipe() {
      return this.$route.name != 'home' && this.$route.name != 'invites';
    },
    displayBar() {
      return !this.route.query.matches;
    }
  }
}
</script>

<style>

</style>