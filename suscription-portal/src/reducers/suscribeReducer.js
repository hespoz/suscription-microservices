export default function reducer(state={
    message:null,
    error_message:null
}, action) {
    switch(action.type){
        case "SUSCRIBE":{
            return {...state, message:action.message, error_message:null}
        }
        case "ERROR_SUSCRIBING":{
            return {...state, message:null, error_message:action.error_message}
        }
        default:
            break;
    }

    return state
}
