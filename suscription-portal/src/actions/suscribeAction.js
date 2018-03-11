
import api from '../utils/api'

export function suscribe(payload){
    return function(dispatch) {

        api.suscribe(payload).then((resp) => {
            dispatch({type:"SUSCRIBE", message:resp.data === "ALREADY_REGISTERED" ? "Oh seems you are already registered" : `Your registration is ${resp.data}`})
        }).catch(function(err){
            dispatch({type:"ERROR_SUSCRIBING", error_message:"Ups! We have a problem, we will be working as soon as possible!"})
        });

    }
}