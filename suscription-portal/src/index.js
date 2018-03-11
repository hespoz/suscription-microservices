import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {Provider} from "react-redux";
import AppRoutes from './AppRoutes';
import registerServiceWorker from './registerServiceWorker';
import store from './store'

ReactDOM.render(<Provider store={store}><AppRoutes/></Provider>, document.getElementById('root'));
registerServiceWorker();
