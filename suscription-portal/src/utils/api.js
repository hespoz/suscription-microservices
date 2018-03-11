import axios from 'axios';

const host = 'http://localhost:8080';

const api = {

    suscribe : function(payload) {
        return axios.post(`${host}/suscribe`, payload)
    }

}

export default api