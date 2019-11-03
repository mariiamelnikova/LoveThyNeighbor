/*!

=========================================================
* Light Bootstrap Dashboard React - v1.3.0
=========================================================

* Product Page: https://www.creative-tim.com/product/light-bootstrap-dashboard-react
* Copyright 2019 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/light-bootstrap-dashboard-react/blob/master/LICENSE.md)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
import React, { Component } from "react";
import { Grid, Row, Col } from "react-bootstrap";
import Tasks from "../components/Tasks/Tasks";

import Card from "components/Card/Card.jsx";

class Typography extends Component {
  render() {
    return (
      <div className="content">
        <Col md={6}>
          <Card
              category=""
              stats="Updated 3 minutes ago"
              statsIcon="fa fa-history"
              content={
                <div className="table-full-width">
                  <table className="table">
                    <Tasks />
                  </table>
                </div>
              }
          />
        </Col>
      </div>
    );
  }
}

export default Typography;
