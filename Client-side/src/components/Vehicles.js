import React from 'react';
import NavBar from './Nav';
import CarCard from './CarCard';
import MotorBikeCard from './MotorBikeCard';

import Container from 'react-bootstrap/Container';

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
            console.log(data)
        }).catch(console.log) 
    }
      render(){ 
        return(
          <Container>
                <VehicleItem vehicles={this.state.vehicles}/>
          </Container>
     
        );
      
      }

}
//Items are displayed in a two column grid
const Items = ({data}) => {
  const rows = [...Array(Math.ceil(data.length / 3))];
  const itemRows = rows.map((row, i) => data.slice(i * 3, i * 3 + 3));
  const content = itemRows.map((row, i) => (
    <div className="row" key={i}>
      {row.map((item) => {
        const Type = (item.vehicle_TYPE==='Car'? CarCard : MotorBikeCard);
        console.log(Type);
        return(
        <div
        className="col mx-lg-2 mx-md-0 mx-sm-0"
          key={item.plateNum}
        >
          
         
             
            
            
             
           
            <Type data={item}/>
         
          
        </div>
           );
})}
    </div>
  ));
  return <div>{content}</div>;
};
const VehicleItem = ({vehicles})=>{
    return(
        <Container fluid>
            <h1><center>VEHICLE LIST</center></h1>
            <Items data={vehicles}/>
            
       
        </Container>
    );

}
export default  Vehicles;