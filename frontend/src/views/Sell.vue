<template>
    <div style="background-color:#404040">
        <div><Navi/></div>
        
        <b-row style="height: 100%;">
                <b-col cols="2"><Categories style="height: 100%; min-height:91vh;"/></b-col>
                <b-col cols="8">
                <h3 style="color:white; padding-top:10px;">Add product</h3>
                   <form>
                    <div class="form-group">
                        <input v-model="form.name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter article title">
                    </div>
                     <div class="form-group">
                        <input v-model="form.description" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter article description">
                    </div>
                     <div class="form-group">
                        <input v-model="form.priceUm" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter price">
                    </div>
                    <div class="form-group">
                        <input v-model="form.availableUm" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter quantity">
                    </div>
                    <div class="form-group">
                        <input v-model="form.um" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter measurement">
                    </div>
                    <div class="form-group">
                        <input v-model="form.city" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter city">
                    </div>
                    <button type="submit" class="btn btn-primary bg-dark">Submit</button>
                    </form>
                </b-col>
        </b-row>
    </div>
</template>

<script>
import Navi from '@/components/Navi'
import Categories from '@/components/Categories'
import store from "@/store"

export default {

    name: "Sell",
    computed: {
        getToken () {
            return this.$store.state.token
        }
    },
    data () {
        return {
            form: 
            {
                email: '',
                name: '',
                decription: '',
                um: '',
                availableUm: '',
                priceUm: '',
                subcategory_id: 0,
                city: ''
            }
        }  
    },
    components: {
        Navi, Categories
    },
    handleSubmit: function () {

      var vm = this

      let axiosConfig = {
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': "Bearer " + vm.getToken()
        }
      }

      axios.post('http://localhost:8081/products/post', vm.form, axiosConfig)
        .then(function (response) {
          vm.responseData = response.data
          vm.status = 'Product added'
        })
        .catch(function (error) {
          vm.status = error
          console.log(error.message)
        })
    }
}
</script>

<style scoped>
    
</style>