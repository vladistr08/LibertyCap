<template>
    <b-row>
        <b-container>
            <b-row>
                <b-dropdown id="dropdown-1" text="Sorting" class="m-md-2">
                    <b-dropdown-item>Ascendent price</b-dropdown-item>
                    <b-dropdown-item>Descendent price</b-dropdown-item>
                </b-dropdown>
                <b-dropdown id="dropdown-1" text="View" class="m-md-2">
                    <b-dropdown-item @click="changeViewTypeTrue()">List</b-dropdown-item>
                    <b-dropdown-item @click="changeViewTypeFalse()">Grid</b-dropdown-item>
                </b-dropdown>
            </b-row>
            <b-row>
                
            </b-row>
        </b-container>
    </b-row>
</template>

<script>
import store from '@/store'
export default {
    name: "Filtru",
    methods: {
        changeViewTypeTrue() {
            store.commit('setViewType', true)
        },
        changeViewTypeFalse() {
            store.commit('setViewType', false)
        }
    }
}
</script>

<style >
    
</style>