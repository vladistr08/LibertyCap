<template>
<div>
    <b-row v-if="getViewType">
        <HorizontalCard style="margin-top: 30px; margin-bottom: 30px;"/>
        <HorizontalCard style="margin-top: 30px; margin-bottom: 30px;"/>
        <HorizontalCard style="margin-top: 30px; margin-bottom: 30px;"/>
        <HorizontalCard style="margin-top: 30px; margin-bottom: 30px;"/>
        <HorizontalCard style="margin-top: 30px; margin-bottom: 30px;"/>
        <HorizontalCard style="margin-top: 30px; margin-bottom: 30px;"/>
    </b-row>  
    <b-row v-if="!getViewType">
        <VerticalCard style="margin-right: 30px; margin-bottom: 30px;"/>
        <VerticalCard style="margin-right: 30px; margin-bottom: 30px;"/>
        <VerticalCard style="margin-right: 30px; margin-bottom: 30px;"/>
        <VerticalCard style="margin-right: 30px; margin-bottom: 30px;"/>
        <VerticalCard style="margin-right: 30px; margin-bottom: 30px;"/>
        <VerticalCard style="margin-right: 30px; margin-bottom: 30px;"/>

    </b-row>
</div>
</template>

<script>
import HorizontalCard from "./HorizontalCard.vue"
import VerticalCard from "./VerticalCard.vue"
import store from "@/store"
import axios from 'axios'

export default {
    name: "Products",
    data() {
        return {
            products: [{
                name,
                description,
                price,
                availableUm,
                um
            }]
        }
    },
    components: {
        HorizontalCard,
        VerticalCard
    },
    computed: {
        getViewType () {
            return this.$store.state.viewType
        },
        getToken () {
            return this.$store.state.token
        }
    },
    /*created() {
        var vm = this;
        axios.get('http://localhost:8081/api/products', {
            headers:{
                'Authorization': "Bearer" + this.getToken()
            }
        })
        .then(response => {
            // JSON responses are automatically parsed.
           vm.product.push( response.data )
        })
        .catch(e => {
            this.errors.push(e)
        })
    }*/
    
}
</script>

<style scoped>

</style>