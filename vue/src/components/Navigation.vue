<template>
<div id="header">
  <img id="logo" src="@/assets/hungr.png" alt="hungr logo"/>
  <nav>
    <ul>
        <li id="home">
            <button type="submit" v-on:click.prevent="goHome">Home</button>
        </li>
        <li id="invites">
            <button type="submit" v-on:click.prevent="goInvites">Invites</button>
        </li>
        <li id="logout">
            <button type="submit" v-on:click.prevent="logOut">Log Out</button>
        </li>
    </ul>
  </nav>
</div>
</template>

<script>
export default {
    name: "navigation",
    methods: {
        goHome() {
            this.$router.push('/');
        },
        goInvites() {
            this.router.push('/invites');
        },
        logOut() {
            this.$router.push('/logout');
        }
    }
}
</script>

<style>
    #header {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        height: 60px;
        width: 100%;
    }

    #logo {
        height: 50px;
        max-width: 140px;
        flex-basis: 70%;
        padding-left: 20px;
        padding-top: 5px;
    }
    nav {
        flex-basis: 30%;
        
    }
    nav ul {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        padding: 20px 20px 0 0;
    }
    nav ul li {
        list-style: none;
        
    }
    nav ul li button {
        width: 100px;
        font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        text-align: center;
        font-weight: bold;
        text-transform: uppercase;
        color: #ffffff;
        background-color: rgba(255, 255, 255, 0.13);
        font-size: 18px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    nav ul li button:hover {
        background-color: rgba(255,255,255,0.47);
    }
</style>