<template>
  <v-container>
    Home
    <div>
      {{ this.$store.state.userStore.token }}
    </div>
  </v-container>
</template>

<script>
export default {
  name: 'App',
  data: () => ({
    b1: '',
    a: ''
  }),
  methods: {



  }
}
</script>
