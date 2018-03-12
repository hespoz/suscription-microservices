export default function reducer(state={
    message:null,
    error_message:null,
    showForm:true
}, action) {
    switch(action.type){
        case "SUSCRIBE":{
            return {...state, message:action.message, error_message:null, showForm:action.showForm}
        }
        case "ERROR_SUSCRIBING":{
            return {...state, message:null, error_message:action.error_message, showForm:true}
        }
        case "GOBACK":{
            return {...state, showForm:true}
        }
        default:
            break;
    }

    return state
}
