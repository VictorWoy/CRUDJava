<template>
  <div id="app">
    <img alt="DearStage logo" src="./assets/favicon.png">
    <Home/>
    <h1> Quantidade de membros {{persons.length}} </h1>

    <h2>Cadastrar</h2>
    <form @submit.prevent="saveAndUpdate">
      <div>
        <input type="text" v-model="person.name" placeholder="Digite o nome"/>
      </div>
      <div>
        <input type="text" v-model="person.idolGroup" placeholder="Digite o grupo"/>
      </div>
      <div>
        <input type="text" v-model="person.height" placeholder="Digite a altura"/>
      </div>
      <div>
        <input type="text" v-model="person.age" placeholder="Digite a idade"/>
      </div>
      <div>
        <input type="text" v-model="person.birthplace" placeholder="Digite o local de nascimento"/>
      </div>
      <div>
        <button v-show="person.id == 0">Cadastrar</button>
        <button v-show="person.id != 0">Alterar</button>
      </div>

    </form>

    <h2>Pesquisar</h2>
    <form @submit.prevent="findById">
      <div>
        <input type="text" v-model="person.id" placeholder="Digite o codigo">
      </div>
      <button>Procurar</button>
    </form>

    <div v-show="person.name != ''">
      <h3>Pessoa Pesquisada</h3>
    <p>
     <br/> Código: {{person.id}}
     <br/> Nome: {{person.name}}
     <br/> Grupo Idol: {{person.idolGroup}}
     <br/> Altura: {{person.height}}
     <br/> Idade: {{person.age}}
     <br/> Local de nascimento: {{person.birthplace}}
    </p>
    </div>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Idol Group</th>
          <th>Height</th>
          <th>Age</th>
          <th>Birthplace</th>
          <th>Delete</th>
          <th>Update</th>
        </tr>
      </thead>
      <tfoot>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Idol Group</th>
          <th>Height</th>
          <th>Age</th>
          <th>Birthplace</th>
          <th>Delete</th>
          <th>Update</th>
        </tr>
      </tfoot>
      <tbody>
        <tr v-for="person in persons" :key="person.id">
          <td>{{person.id}}</td>
          <td>{{person.name}}</td>
          <td>{{person.idolGroup}}</td>
          <td>{{person.height}}</td>
          <td>{{person.age}}</td>
          <td>{{person.birthplace}}</td>
          <td><button type="button" @click="deletePerson(person)">Excluir</button></td>
          <td><button type="button" @click="updatePerson(person)">Alterar</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Home from './components/Home.vue'
import PersonServices from './services/PersonServices.js'


export default {
  data() {
    return {
      persons: [],
      person: {
        id: 0,
        name: '',
        idolGroup: '',
        height: 0.0,
        age: 0,
        birthplace: ''
      }
    }
  },
  

  name: 'App',
  components: {
    Home
  },
  mounted() {
    this.listPersons();
  },
  methods: {
    listPersons() {
      PersonServices.findAll().then(response => {
        console.log(JSON.stringify(response.data));
        this.persons = response.data;
      })
    },
    findById() {
       PersonServices.findById(this.person).then(response => {
        console.log(JSON.stringify(response));
        this.person = response.data;
      })
    },
    saveAndUpdate() {
      if(this.person.id == 0) {
      PersonServices.save(this.person).then(response => {

        console.log(JSON.stringify(response));
        this.listPersons();
        this.person = {};
      })
      } else {
        PersonServices.update(this.person).then(response => {

        console.log(JSON.stringify(response));
        this.listPersons();
        this.person = {};
      })
      }
    },
    deletePerson(person) {
      console.log(JSON.stringify(person));
      if(confirm("Deseja excluir o membro?")) {
        
        PersonServices.delete(person).then(response => {
          if(response.status == 200) {
            alert("Excluido");
            console.log(JSON.stringify(response));
            this.listPersons();
           
          }
      }).catch(error => {
        console.log(JSON.stringify(error));
      })

      }
      else {
        alert("Cancelado");
      }
    },
    
    updatePerson(person) {
      console.log(JSON.stringify(person));
      this.person = person;
      
       
    }

  }
 
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
