import React from 'react';
import { Link } from 'react-router-dom';

function VehicleCard(props){
    return(
    <div className="card">
                            <div className="card-body" >
                                 <label >Vehicle Type:{props.vehicle_TYPE} </label> 
                                 <label>Make:{props.make} </label>
                                 <label>Model:{props.model} </label>
                                <label>Number Of Seats:{props.numOfSeats} </label>
                                <label>Rate:{props.priceRate} </label>
                                <label >Plate Number:{props.plateNum} </label>
                                <label>A/C Availability:{props.acAvailability} </label>
                                <label >Color:{props.color} </label>
                                <label>Number of Doors:{props.numOfDoors} </label>
                                <label >Transmission:{props.transmission} </label>
                                <label >TankCapacity:{props.tankCapacity} </label>
                                <label>Luggage Weight:{props.luggageWeight} </label>
                                <label >Number of seats:{props.numOfSeats} </label>
                                <Link to="/booking"><button>Book</button></Link>
                             </div>
                        </div>
    );
}
export default VehicleCard;