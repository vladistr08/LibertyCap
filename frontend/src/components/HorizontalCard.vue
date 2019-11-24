<template>
    <div>
    <b-card img-src="https://placekitten.com/300/300" img-alt="Card image" img-left class="mb-3 card" >
        <b-card-text>
            <b-container>
              <b-row style="padding-bottom: 10%;" >
                Some quick example text to build on the card and make up the bulk of the card's content.
              </b-row>
              <b-row class="buyBtn">
                <b-button class="buyBtn"> BUY </b-button>
              </b-row>
           </b-container>
        </b-card-text>
    </b-card>
    </div>
</template>

<script>
export default {
    name: "HorizontalCard",
}
</script>

<style scoped>
.buyBtn {
  float: right;
  padding: 25px; 
}
</style>