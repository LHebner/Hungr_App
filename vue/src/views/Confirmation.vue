<template>
  <div>
      <navigation />
    <div id="sent">Invite Sent!</div>
    </div>
</template>

<script>
import Navigation from '../components/Navigation.vue'

export default {
  name: "confirmation",
  components: {Navigation},
}
</script>

<style>
  #sent{
    color: #ffffff;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size: 50px;
    font-weight: bolder;
    text-align: center;
    margin-top: 15%;
    text-shadow: 0px 5px 10px rgb(60, 62, 70);
  }
</style>