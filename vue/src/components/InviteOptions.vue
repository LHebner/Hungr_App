<template>
  <div id="body">
    <h1 id="inviteHeader">Who do you want to invite?</h1>
    <div id="inviteInfo">
      <div id="restaurant">Business Info</div>
      <div id="userList">
        Users
        <ul>
          <li>Luke</li>
          <li>Austen</li>
          <li>Ryan</li>
          <li>Carson</li>
          </ul>
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
  name: "invite-options"
}
</script>

<style>
  #body{
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    color: #ffffff;
  }
  #inviteInfo {
    display: grid;
    grid-template-columns: 3fr 2fr 2fr 1fr;
    column-gap: 20px;
    align-items: center;
    width: 80%;
    color: black;
    background-color: rgba(255, 255, 255, 0.95);
    border-radius: 10px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    padding: 35px 50px;
    margin: 35px auto 0 auto;
    letter-spacing: 0.5px;
  }
  #inviteHeader {
    text-align: center;
  }
  #dinnerTime {
    background: rgba(255,255,255,0.27);
    color: rgb(0, 0, 0);
    /* position: relative; */
    cursor: pointer;
    margin-bottom: 10px;
    border: 2px solid #ddd;
    font-size: 18px;
    /* padding: 12px; */
    border-radius: 3px;
    width: 180px;
    text-align: center;
  }
  
</style>