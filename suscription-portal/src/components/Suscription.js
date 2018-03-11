import React from 'react';
import '../index.scss'

import DatePicker from 'react-datepicker';
import moment from 'moment';
import 'react-datepicker/dist/react-datepicker.css';

import logo from '../images/logo.png';

import { Form, Input, Button, Checkbox, Radio, Message, Image } from 'semantic-ui-react'

const Suscription = (props) => {

    const { firstName, email, gender, flag, dateOfBirth } = props.fields;

    return <div className="container">
        <div className="row d-flex justify-content-center suscribe-container">
            <div className="col-12 col-sm-12 col-md-12 col-lg-6 form-wrapper">

                <div className="row d-flex justify-content-center">
                    <div className="col-5 col-sm-5 col-md-5 col-lg-5">
                        <Image src={logo} size='small' />
                    </div>
                </div>

                <div className="row title-wrapper">
                    <div className="col-12 col-sm-12 col-md-12 col-lg-12 text-center">
                        <h1>SUSCRIBE TO OUR NEWSLETTER</h1>
                    </div>
                </div>




                {props.error_message ?
                    <Message
                    negative
                        content={props.error_message}
                    />
                    :
                    null
                }

                {props.message ?
                    <Message
                        info
                        content={props.message}
                    />
                    :
                    null
                }
                    
                <Form onSubmit={(e) => {
                    props.onSubmit(e)
                }}>

                    <Form.Field>
                        <label>First name</label>
                        <Input placeholder='First name' {...firstName.props}/>
                    </Form.Field>

                    <Form.Field>
                        <label>Email</label>
                        <Input placeholder='Email' {...email.props}/>
                        <small className="validation-error">{email.error}</small>
                    </Form.Field>

                    <Form.Field>
                        <label>Birth date</label>
                        <DatePicker
                            readOnly
                            showYearDropdown
                            selected={dateOfBirth.value !== '' ? dateOfBirth.value : moment()}
                            onChange={props.onBirthDateSelect}
                        />
                        <small className="validation-error">{dateOfBirth.error}</small>
                    </Form.Field>
                    
                    <Form.Field inline>
                        <Radio
                            label='Male'
                            name='radioGroup'
                            value='MALE'
                            checked={gender.value === 'MALE'}
                            onChange={props.onGenderSelect}
                        />
                        <Radio
                            label='Female'
                            name='radioGroup'
                            value='FEMALE'
                            checked={gender.value === 'FEMALE'}
                            onChange={props.onGenderSelect}
                        />

                    </Form.Field>
                        

                    <Form.Field>
                        <Checkbox label='I agree to the Terms and Conditions' onChange={props.onTermsAgree}
                        checked={flag.props.value !== '' ? flag.props.value : false}/>
                    </Form.Field>

                    <div className="terms-error-wrapper">
                        <small className="validation-error">{flag.error}</small>        
                    </div>
                    
                    <div className="submit-btn-wrapper">
                        <Button type='submit' fluid color='blue'>Suscribe</Button>      
                    </div>
                    
                </Form>
                
            </div>
        </div>
      
    </div>
}

export default Suscription