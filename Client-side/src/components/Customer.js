import React from "react";
import NavBar from "./Nav";

class CustomerDet extends React.Component {
  render() {
    return (
      <div>
        <NavBar />,
        <CustomerDetForm />
      </div>
    );
  }
}
class CustomerDetForm extends React.Component {
  constructor() {
    super();
    this.state = {};
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);

    fetch("http://localhost:8081/api/addCustomer", {
      method: "POST",
      body: data,
    });
    alert("You have successfully rented the vehicle!");
  }
  render() {
    return (
      <div className="customer">
        <form id="form" onSubmit={this.handleSubmit}>
          <h1>Driver Details</h1>
          <label>NIC No: </label>
          <input type="text" name="cusNICNo" placeholder=" Enter NIC No" />

          <label>First Name:</label>
          <input
            type="text"
            name="cusFirstName"
            placeholder=" Enter First Name"
          />

          <label>Last Name:</label>
          <input type="text" name="cusLastName" placeholder="Enter Last Name" />

          <label>Phone Number: </label>
          <input type="text" name="phoneNo" placeholder="Enter phone number" />

          <label>Date Of Birth :</label>
          <input type="date" name="cusDOB" />

          <label>Is License available : </label>
          <input type="checkbox" value="licenseAvailability" />

          <label>Period of license ownership is over one year:</label>
          <input type="checkbox" value="periodOfLicenseOwnership" />

          <hr />
          <h1>Driver Payment Details</h1>
          <label>
            Cardholder name :
            <input
              type="text"
              name="cardHolderName"
              placeholder="Enter card holder's name"
            />
          </label>
          <label>
            Card number:
            <input type="text" name="cardNo" placeholder="Enter card No" />
          </label>

          <label>
            CCV code :
            <input type="text" name="ccv_code" placeholder="Enter CCV code" />
          </label>
          <button>Submit</button>
        </form>
      </div>
    );
  }
}
export default CustomerDet;
