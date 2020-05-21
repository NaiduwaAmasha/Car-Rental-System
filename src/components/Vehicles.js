import React from 'react';
import NavBar from './Nav';

class Vehicles extends React.Component{
    constructor(props){
        super(props);
        this.state={
          vehicles:[]
        }
      }
      componentDidMount(){
        fetch('http://localhost:8081/api/get')
        .then(res=>res.json())
        .then((data)=>{
            this.setState({vehicles : data})
        }).catch(console.log) 
    }
      render(){ 
        return(
          <div>
              <NavBar/>,
                <VehicleItem vehicles={this.state.vehicles}/>
          </div>
     
        );
      
      }

}
const VehicleItem = ({vehicles})=>{
    return(
        <div>
            <h1><center>VEHICLE LIST</center></h1>
            {vehicles.map((item)=>{
            return(
              <div className="card">
                            <div className="card-body" >
                                 <label >Vehicle Type:{item.vehicle_TYPE} </label> 
                                 <label>Make:{item.make} </label>
                                 <label>Model:{item.model} </label>
                                <label>Number Of Seats:{item.numOfSeats} </label>
                                <label>Rate:{item.priceRate} </label>
                                <label >Plate Number:{item.plateNum} </label>
                                <label>A/C Availability:{item.acAvailability} </label>
                                <label >Color:{item.color} </label>
                                <label>Number of Doors:{item.numOfDoors} </label>
                                <label >Transmission:{item.transmission} </label>
                                <label >TankCapacity:{item.tankCapacity} </label>
                                <label>Luggage Weight:{item.luggageWeight} </label>
                                <label >Number of seats:{item.numOfSeats} </label>
                             </div>
                        </div>
            );
        })}
        </div>
    );

}
export default  Vehicles;