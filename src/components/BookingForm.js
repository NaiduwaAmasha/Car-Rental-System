import React from "react";
import { Link } from "react-router-dom";
import Axios from "axios";

class BookingForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      schedules: [],
      pickUpLocation:'Galle',
      returnLocation:'Galle',
      pickUpDate: "",
      dropOffDate: "",
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
  }

 
  // componentDidMount(){
  //     fetch('http://localhost:8081/api/getSchedules')
  //     .then(res=>res.json())
  //     .then((data)=>{
  //         this.setState({schedules : data})
  //     }).catch(console.log)

  // }
  handleInputChange(event) {
    const name = event.target.name;
    const value = event.target.value;
    this.setState({
      [name]: value,
    });
  }
  handleSubmit(event) {
    event.preventDefault();

    console.log(this.state.pickUpDate + "/" + this.state.dropOffDate+"/"+this.state.pickUpLocation+"/"+this.state.returnLocation);
    Axios.post('http://localhost:8081/api/addSchedule',{
        pickUpDate:this.state.pickUpDate,
        dropOffDate:this.state.dropOffDate,
        pickUpLocation:this.state.pickUpLocation,
        returnLocation:this.state.returnLocation
    })
    .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });

  }

  render() {
    return (
      <div className="bookingbody">
        <div className="bookingSec">
          <form className="bookingForm" onSubmit={this.handleSubmit}>
            <label>
              Pick-Up Date :
              <input
                type="date"
                name="pickUpDate"
                value={this.state.pickUpDate}
                onChange={this.handleInputChange}
              />
            </label>
            <label>
              Drop-Off Date :
              <input
                type="date"
                name="dropOffDate"
                value={this.state.dropOffDate}
                onChange={this.handleInputChange}
              />
            </label>
            <label>
              Pick-Up Location :
             <select name="pickUpLocation" value={this.state.pickUpLocation} onChange={this.handleInputChange}>
                 <option value="Galle">Galle</option>
                 <option value="Colombo">Colombo</option>
                 <option value="Kandy">Kandy</option>
                 <option value="Negombo">Negombo</option>
             </select>
            </label>
            <label>
              Return Location :
              <select name="returnLocation" value={this.state.returnLocation} onChange={this.handleInputChange}>
                 <option value="Colombo">Colombo</option>
                 <option value="Kandy">Kandy</option>
                 <option value="Negombo">Negombo</option>
                 <option value="Galle">Galle</option>
             </select>
            </label>

            <input type="submit" value="Find" onClick={this.onSubmit} />
          </form>
        </div>
      </div>
    );
  }
}

export default BookingForm;
