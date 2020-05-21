import React from 'react';
import '../App.css';
import { Link } from 'react-router-dom';


function Nav(){
 
    return(
      <div id="nav_title">
        <Link to="/"><h1>Rent-A-Wheeler</h1></Link>,
        <Link to="/vehicles"><nav>VEHICLE LIST</nav></Link>
      </div>
    ) ;
   
  
 
}
export default Nav;