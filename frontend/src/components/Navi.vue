<template>
    <nav class="navbar navbar-dark bg-dark navbar-expand-lg static-top" style="border-bottom:  1px solid #28a745">
        <router-link to="/"><a class="navbar-brand text-success">iVandut</a></router-link>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <router-link to="/"><a class="nav-link">Home <span class="sr-only">(current)</span></a></router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/cart"><a class="nav-link">Cart</a></router-link>
                </li>
                <li class="nav-item" v-if="getIsSeller">
                    <router-link to="/sell"><a class="nav-link">Sell</a></router-link>
                </li>
            </ul>

            <div class="form-inline my-2 my-lg-0">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <router-link to="/login"> <a class="nav-link">Log in</a> </router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/signin"> <a class="nav-link">Register</a> </router-link>
                    </li>
                    <form >
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </ul>

            </div>
        </div>
    </nav>
</template>

<script>
import store from "@/store"
export default {
    name: "Navi",
    computed: {
        getIsSeller() {
            return this.$store.state.isSeller
        },
        getIsAuth() {
            return this.$store.state.authenticated;
        }
    }
}
</script>

<style scoped>
</style>