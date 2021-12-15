<template>
  <div id="body">
    <div id="header">
      <h1>Who do you want to invite?</h1>
    </div>
    <div id="inviteInfo">
      <div id="restaurant">Business Info</div>
      <div id="userList">
        Users
        <ul></ul>
          <li>Luke</li>
          <li>Austen</li>
          <li>Ryan</li>
          <li>Carson</li>
      </div>
      <div id="dateTime">
        When's Dinner?
        <input type="date" id="dinnerTime" name="dinnerTime">
      </div>
      <div id="inviteButton">
        <button id="invite" v-on:click.prevent>Invite</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
  #body{
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    color: #ffffff;
  }
  #inviteInfo {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: auto;
  }
  #header {
    text-align: center;
  }
  #dinnerTime {
    background: rgba(255,255,255,0.27);
    color: #fff;
    /* position: relative; */
    cursor: pointer;
    margin-bottom: 10px;
    border: 2px solid #ffffff;
    font-size: 18px;
    /* padding: 12px; */
    border-radius: 3px;
    width: 180px;
    text-align: center;
  }
</style>