<template>
     <div style="background-color: white">
  <b-card
    title="Card Title"
    img-src="https://picsum.photos/600/300/?image=25"
    img-alt="Image"
    img-top
    tag="article"
    style="max-width: 20rem;"
    class="mb-2"
  >
    <b-card-text>
      Some quick example text to build on the card title and make up the bulk of the card's content.
    </b-card-text>
    <b-button class="buyBtn"> BUY </b-button>
  </b-card>
</div>
</template>

<script>
export default {
    name: "VerticalCard",
}
</script>

<style scoped>
.card {
    height: 50%;
    width: 100%;
    
}
.buyBtn {
  float: right;
}
</style>