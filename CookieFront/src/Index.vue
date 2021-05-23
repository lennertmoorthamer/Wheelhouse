<template>
  <div>
    <h1>Lets eat some cookies !</h1>
    <h3 v-if="this.calories > 0">
      Oh no, you gained {{ this.calories }} calories already!
    </h3>
    <div class="cookiesHolder" v-if="this.cookies">
      <div
        @click="handleCookie(cookie.brand, cookie.calories)"
        class="cookie"
        v-for="cookie in cookies.data"
        :key="cookie.id"
      >
        <img :src="cookie.image" alt="cookie" />
        <h2>{{ cookie.brand }}</h2>
        <p>Calories: {{ cookie.calories }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from './services/Axios';

export default {
  name: 'Index',
  components: { },
  data(){
    return{
      cookies: null,
      calories: 0
    }
  },
  async created() {
      this.cookies = await axios.get('/cookies');
  },
  methods: {
    handleCookie(brand, cal){
      this.$toast.open(`You munched a ${ brand } and gained ${ cal } calories!`);
      this.calories += cal
    }
  }
};
</script>

<style lang="scss" scoped>
h1 {
  color: #7cbd47;
}

h1,
h3 {
  text-align: center;
}

.cookiesHolder {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  width: 100%;

  .cookie {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    transition: 0.3s;
    width: 25vw;
    height: 25vw;
    margin: 3vw;
    background-color: white;

    &:hover {
      box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
      cursor: pointer;
    }

    img {
      width: 100%;
      height: 60%;
      object-fit: cover;
    }

    h2 {
      text-align: center;
    }

    p {
      padding-left: 2vw;
    }
  }
}
</style>
