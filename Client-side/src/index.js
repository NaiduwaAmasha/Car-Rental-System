import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route,Switch } from 'react-router-dom';
import './index.css';
import Home from './components/Home.js';
import Results from './components/ResultPage.js';
import Booking from './components/Customer.js';
import Vehicle from './components/Vehicles.js';
import NavBar from './components/Nav';


ReactDOM.render(
    <Router>
        
        <Switch>
           
            <Route exact path="/" component={Home}/>
            <Route exact path="/results" component={Results}/>
            <Route exact path="/booking" component={Booking}/>
            <Route exact path="/vehicles" component={Vehicle}/>
        </Switch>
    </Router>,
     document.getElementById('root')
);



