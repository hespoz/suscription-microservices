import React from 'react';

import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom';

import SuscriptionContainer from './containers/SuscriptionContainer.js'

const AppRoutes = () => (
  <Router>
    <div>
      <Route exact path='/' component={SuscriptionContainer}/>
    </div>
  </Router>
)

export default AppRoutes;
