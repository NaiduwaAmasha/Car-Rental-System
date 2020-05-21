import React from 'react';
import NavBar from './Nav';
import BookingSec from './BookingForm';


class Home extends React.Component{
  
  render(){ 
    return(
      <div>
          <NavBar/>,
          <BookingSec/> ,         
      </div>
 
    );
  
  }
 
}
export default Home;