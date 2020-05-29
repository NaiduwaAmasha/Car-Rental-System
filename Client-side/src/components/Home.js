import React from 'react';
import NavBar from './Nav';
import BookingSec from './BookingForm';
import Vehicles from './Vehicles';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';


class Home extends React.Component{
  
  render(){ 
    return(
      <Container fluid>
        <Row >
          <Container fluid className="bookingbody">
            <div className="main_header"> 
            <h1 style={{fontSize:100}}>Rent-A-Car</h1>
          <h2>Car rental in Sri Lanka</h2>
          <p>Travel in style</p>
          <BookingSec />
          </div>
         
         </Container> 
          </Row>
        <Row><Vehicles/> </Row>
        
      </Container>
 
    );
  
  }
 
}
export default Home;