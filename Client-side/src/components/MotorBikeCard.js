import React from "react";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faUser,
  faCog,
  faSuitcaseRolling,
  faGasPump,
} from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";

function VehicleCard(props) {
  return (
    <Card>
      <Card.Img variant="top" src="assets/nisan_neo.jpg" />
      <Card.Body>
        <Card.Title>
          {props.data.make} {props.data.model}
        </Card.Title>
        <Card.Text>
          <Row>
            <Col>Plate Number : {props.data.plateNum}</Col>
          </Row>
          <Row>
            <Col>
              <FontAwesomeIcon icon={faCog} />
              {props.data.transmission}
            </Col>
            <Col>
              {" "}
              <FontAwesomeIcon icon={faUser} /> Number of seats:
              {props.data.numOfSeats}
            </Col>
            <Col>
              <FontAwesomeIcon icon={faGasPump} />
              Tank Capacity{props.data.tankCapacity} ltr
            </Col>
            <Col>
              <FontAwesomeIcon icon={faSuitcaseRolling} />
              luggage : {props.data.luggageWeight} Kg
            </Col>
          </Row>
        </Card.Text>
        <Row>
          <Col lg={8}>
            <Link to="/booking">
              <Button variant="primary">Book</Button>
            </Link>
          </Col>
          <Col lg={4}>Rs.{props.data.priceRate}</Col>
        </Row>
      </Card.Body>
    </Card>
  );
}
export default VehicleCard;
