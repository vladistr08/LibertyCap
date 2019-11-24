<template>
    <div class="bg-dark" style="
        margin: 0px;
        padding: 0px;
    ">
        <!--<b-button v-b-toggle="'collapse-2'" class="m-1">Agriculture</b-button>

        <b-collapse id="collapse-2">
            <b-button>Vegetables</b-button>
            <b-button>Fruits</b-button>
            <b-button>Tools</b-button>
            <b-button>All</b-button>
        </b-collapse>

        <b-button v-b-toggle="'collapse-2'" class="m-1">Hand crafted</b-button>

        <b-collapse id="collapse-2">
            <b-button>Wood</b-button>
            <b-button>Stone</b-button>
            <b-button>All</b-button>
        </b-collapse>
        -->

        <!--<b-dropdown id="dropdown-1" text="Agriculture" class="m-md-2">
            <b-dropdown-item>Vegetables</b-dropdown-item>
            <b-dropdown-item>Fruits</b-dropdown-item>
            <b-dropdown-item>Tools</b-dropdown-item>
            <b-dropdown-item>All</b-dropdown-item>
        </b-dropdown>
        <b-dropdown id="dropdown-1" text="Hand crafted" class="m-md-2">
            <b-dropdown-item>Wood</b-dropdown-item>
            <b-dropdown-item>Stone</b-dropdown-item>
            <b-dropdown-item>All</b-dropdown-item>
        </b-dropdown>-->
        <h4><input type="button" value="Agriculture"/></h4>
        <ul style="list-style: none;">
            <li><input type="button" value="Vegetables"/></li>  
            <li><input type="button" value="Fruits"/></li>   
            <li><input type="button" value="Tools"/></li>         
        </ul>
        <h4><input type="button" value="Handmade"/></h4>
        <ul style="list-style: none;">
            <li><input type="button" value="Wood"/></li>
            <li><input type="button" value="Stone"/></li>
        </ul>
    </div>
</template>

<script>
export default {
    name: "Categories"
}
</script>
<style scoped>
/* .btn:focus {
  outline: none;
}

button{
    color: white;
}

button:hover{
    background-color: #343a40;
    color: #28a745;
    border: none;
    outline:none;
    border-color: #343a40;
}*/

input[type="button"]
{
    background-color:#343a40;
    border: none;
    outline:none;
    color: rgba(255, 255, 255, 0.5);
}

input[type="button"]:hover
{
    background-color:#343a40;
    border: none;
    outline:none;
    color: #28a745;
}

</style>