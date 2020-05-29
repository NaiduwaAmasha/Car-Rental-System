import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link } from 'react-router-dom';

function VehicleCard(props){
    return(
        <Card style={{ width: '18rem' }}>
  <Card.Img variant="top" src="assets/nisan_neo.jpg" />
  <Card.Body>
    <Card.Title>{props.data.make} {props.data.model}</Card.Title>
    <Card.Text>
    <Row>
        <Col>Number of seats:{props.data.numOfSeats}</Col>
        <Col>Rs.{props.data.priceRate}</Col>
        
    </Row>
    <Row>
    <Col>Plate Number : {props.data.plateNum}</Col>
    </Row>
    <Row>
        <Col>
        
        <Form>
        
        <Form.Check
        custom
        checked = {props.data.acAvailability}
        type='checkbox'
        label={'A/C Availability'}
        id={'disabled-custom-checkbox'}
      />
        </Form>
        </Col>
        <Col> Color : {props.data.color}<div className="colorBox" style={{backgroundColor:props.data.color}}></div></Col>
    </Row>
    <Row>
    <Col>{props.data.numOfDoors} Doors</Col>
    <Col>{props.data.transmission}</Col>
    <Col>Tank Capacity{props.data.tankCapacity} ltr</Col>
    <Col>luggage : {props.data.luggageWeight} Kg</Col>
    <Col>Number of seats:{props.data.numOfSeats}</Col>
    </Row>
    </Card.Text>
    <Button variant="primary">Book</Button>
  </Card.Body>
</Card>
    // <div className="card">
    //                         <div className="card-body" >
    //                              <label >Vehicle Type:{props.vehicle_TYPE} </label> 
    //                              <label>Make:{props.make} </label>
    //                              <label>Model:{props.model} </label>
    //                             <label>Number Of Seats:{props.numOfSeats} </label>
    //                             <label>Rate:{props.priceRate} </label>
    //                             <label >Plate Number:{props.plateNum} </label>
    //                             <label>A/C Availability:{props.acAvailability} </label>
    //                             <label >Color:{props.color} </label>
    //                             <label>Number of Doors:{props.numOfDoors} </label>
    //                             <label >Transmission:{props.transmission} </label>
    //                             <label >TankCapacity:{props.tankCapacity} </label>
    //                             <label>Luggage Weight:{props.luggageWeight} </label>
    //                             <label >Number of seats:{props.numOfSeats} </label>
    //                             <Link to="/booking"><button>Book</button></Link>
    //                          </div>
    //                     </div>
    );
}
export default VehicleCard;