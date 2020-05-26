import React from "react";
import NavBar from "./Nav";
import Axios from "axios";
import VehicleCard from "./VechicleCard";

class ResultPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      vehicles: "",
      pickUpDate: "",
      dropOffDate: "",
    };
  }

  componentDidMount() {
    const localStorageData = JSON.parse(localStorage.getItem("formdata"));
    console.log(localStorageData);
    var self = this;
    Axios.get("http://localhost:8081/api/getAvailableVehicles", {
      params: {
        pickUpDate: localStorageData["pickUpDate"],
        dropOffDate: localStorageData["dropOffDate"],
      },
    })
      .then(function (response) {
        self.setState({ vehicles: response.data });
        console.log(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  render() {
    var filterData = this.state.vehicles;
    return (
      <div>
        <NavBar />,
        <FilterForm data={filterData} />
      </div>
    );
  }
}
var createReactClass = require("create-react-class");
var FilterForm = createReactClass({
  getInitialState: function () {
    return {
      data: [],
      vehicle_TYPE: "",
    };
  },
  handleChange: function (val) {
    this.setState({ vehicle_TYPE: val });
    var filteredData = this.props.data.filter(function (item) {
      return item.vehicle_TYPE === val;
    });
    this.setState({ data: filteredData });
    console.log(filteredData, val);
  },
  render: function () {
    return (
      <div>
        <h2>Vehicle Type</h2>
        <FilterOptions
          data={this.state.data}
          changeOption={this.handleChange}
        />
        <FilterItems data={this.state.data} />
      </div>
    );
  },
});
var FilterOptions = createReactClass({
  getInitialState: function () {
    return {
      data: this.props.data,
      vehicle_TYPE: "",
    };
  },
  handleChange: function (e) {
    var val = e.target.value;
    this.setState({ vehicle_TYPE: val });
    this.props.changeOption(val);
  },
  render: function () {
    return (
      // <div>
      //    <p>{this.state.pickUpDate}</p>
      // </div>

      <select
        id="filterDropdrown"
        value={this.state.vehicle_TYPE}
        onChange={this.handleChange}
      >
        <option value=" "></option>
        <option value="Car">Car</option>
        <option value="MotorBike">MotorBike</option>
      </select>
    );
  },
});
var FilterItems = createReactClass({
  render: function () {
    return (
      <div>
        {this.props.data.map((item) => (
          <li key={item.plateNum}>
            <VehicleCard
              data={item}
            />
          </li>
        ))}
      </div>
    );
  },
});
export default ResultPage;
