import React, { Component } from 'react';

import Suscription from '../components/Suscription.js'

import { suscribe } from "../actions/suscribeAction";

import { form } from 'react-inform'
import {connect} from "react-redux"

import moment from 'moment'
import approve from 'approvejs'



const fields = ['firstName', 'email', 'gender', 'flag', 'dateOfBirth']; 

const validate = values => {
    const { email, flag, dateOfBirth } = values;
    const errors = {};

    if (!approve.value(email,{ email: true }).approved) errors.email = 'Please provide a valid email';
    if (!flag) errors.flag = 'Please agree the terms and conditions';    
    if (!dateOfBirth) errors.dateOfBirth = 'Birthdate is required!';

    return errors;
}

@form({
    fields,
    validate
})
@connect((store) => {
    return {
        message:store.suscribe.message,
        error_message:store.suscribe.error_message
    }
})
class SuscriptionContainer extends Component {

    componentWillMount = () => {
        const {form} = this.props;
        form.onValues({
            dateOfBirth:moment(),
            flag:false
        })
    }

    updateFormValues = (input) => {
        const {form} = this.props;
        form.onValues(Object.assign(form.values(), input))
    }

    onSubmit = (e) => {
        e.preventDefault();
        const {form} = this.props;

        form.forceValidate();

        if (form.isValid()) {
            this.props.dispatch(suscribe(form.values()))
        }
 
    }

    onGenderSelect = (e, { value }) => {
        this.updateFormValues({gender:value})
    } 

    onTermsAgree = () => {
        const {fields} = this.props;
        this.updateFormValues({flag:!fields.flag.value})
    } 

    onBirthDateSelect = (date) => {
       this.updateFormValues({dateOfBirth: date})
    }

    render () {
        return (
            <Suscription 
                message={this.props.message}
                error_message={this.props.error_message}
                fields={this.props.fields}
                onTermsAgree={this.onTermsAgree}
                onGenderSelect={this.onGenderSelect}
                onBirthDateSelect={this.onBirthDateSelect}
                onSubmit={this.onSubmit}
            />
        )
    }

}

export default SuscriptionContainer