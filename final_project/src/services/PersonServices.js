import { http } from "./Api";

export default {
    findAll: () => {
        return http.get("person");
    },

    findById: (person) => {
        console.log(JSON.stringify(person))
        return http.get(`person/${person.id}`);
    },

    save: (person) => {
        return http.post("person", person);
    } ,

    delete: (person) => {
        console.log(JSON.stringify(person))
        return http.delete(`person/${person.id}`)
    },

    update: (person) => {
        return http.put("person", person)
    }
}