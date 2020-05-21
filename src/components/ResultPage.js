import React from 'react';

import NavBar from './Nav';
import BookingForm from './BookingForm';
import VehicleCard from './VechicleCard';

class ResultPage extends React.Component{
  constructor(props){
    super(props);
    this.state={
      vehicles:'',
      pickUpDate:'',
      dropOffDate:'',
    }
  }

  handleParentData = (formModel) => {
    this.setState({...formModel});
  }

  componentDidMount(){
    fetch('http://localhost:8081/api/get')
    .then(res=>res.json())
    .then((data)=>{
        this.setState({vehicles : data})
        
    }).catch(console.log) 
}

render(){ 
    
    var filterData=this.state.vehicles;
    return(
      <div>
          <NavBar/>,
       <FilterForm data={filterData}/>  
      </div>
    );
  } 
}
var createReactClass = require('create-react-class');
var FilterForm = createReactClass({
  getInitialState:function(){
    return{
      data:[],
      vehicle_TYPE:''
    }
  },
  handleChange:function(val){
    this.setState({vehicle_TYPE:val});
    var filteredData = this.props.data.filter(function(item){
      return item.vehicle_TYPE === val;
    });
    this.setState({data:filteredData});
    console.log(filteredData,val);
  },
  render:function(){
    return(
      <div>
        <h2>Vehicle Type</h2>
      <FilterOptions data={this.state.data} changeOption={this.handleChange}/>
      <FilterItems data ={this.state.data}/>
    </div>
    );
  }
});
var FilterOptions = createReactClass({
  getInitialState:function(){
    return{
      data:this.props.data,
      vehicle_TYPE:''
    }
  },
  handleChange:function(e){
    var val= e.target.value;
    this.setState({vehicle_TYPE:val});
    this.props.changeOption(val);
  },
  render:function(){
    return(
      <div>
         <BookingForm handleData={this.handleParentData}/>
         <p>{this.state.pickUpDate}</p>
      </div>
      
      // <select id="filterDropdrown" value={this.state.vehicle_TYPE} onChange={this.handleChange}>
      //   <option value=" "></option>
      //   <option value="Car">Car</option>
      //   <option value="MotorBike">MotorBike</option>
      // </select>
    );
  }
});
var FilterItems = createReactClass({
  render:function(){
    return(
     

      <div>
        
        {this.props.data.map((item)=>
          <li key={item.plateNum}>
            <VehicleCard vehicle_TYPE={item.vehicle_TYPE} make={item.make} model={item.model} numOfSeats={item.numOfSeats}
          priceRate={item.priceRate} plateNum={item.plateNum} acAvailability={item.acAvailability} numOfDoors={item.numOfDoors} 
          color={item.color} transmission={item.transmission} tankCapacity={item.tankCapacity} luggageWeight={item.luggageWeight}
        />
          </li>
          
        )}
      </div>
    )
  }
});
export default ResultPage;