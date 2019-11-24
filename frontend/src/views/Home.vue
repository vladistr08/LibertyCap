<template>
    <div style="background-color:#404040">
        <div><Navi /></div>
            <b-row style="height: 100%;">
                <b-col cols="2"><Categories style="height: 100%; min-height:91vh;"/></b-col>
                <b-col cols="8">
                    <b-container class="bv-example-row">
                        <b-row>
                            <Filtru />
                        </b-row>
                        <b-row>
                            <Products />
                        </b-row>
                    </b-container>
                </b-col>
            </b-row>
    </div>
</template>

<script>
import Navi from "@/components/Navi.vue";
import Categories from "@/components/Categories.vue";
import Products from "@/components/Products.vue"
import Filtru from "@/components/Filtru.vue"

export default {
    name: "Home",
    components:{
        Navi, Categories, Products, Filtru
    }
}
</script>

<style scoped>
.cont{
    width: 100%;
    padding-right: 15px;
    padding-left: 0;
    margin-left: 0; 
    height: 100%;
}
</style>