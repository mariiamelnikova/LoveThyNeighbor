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
import React, {useState} from 'react';
import axios from 'axios';
// react components used to create a google map
import {GoogleMap, Marker, withGoogleMap, withScriptjs} from "react-google-maps";

const CustomMap = withScriptjs(
    withGoogleMap(props => (

        <GoogleMap
            key={new Date().getTime()}
            onClick={props.onMouseOver}
            defaultZoom={20}
            defaultCenter={{lat: props.users[0].nlat, lng: props.users[0].nlon}}
            defaultOptions={{
                scrollwheel: false,
                zoomControl: true
            }}
        >
            {props.users.map((t) => {
                return <Marker position={{lat: t.lat, lng: t.lon}}/>;
            })}
        </GoogleMap>
    ))
);


function Maps({...prop}) {

    const [users, setUsers] = useState([{nlat: 0, nlon: 0}]);
    let onMouseOver = async () => {

        let res = await axios.get('http://localhost:8080/users/block/' + Math.round(Math.random() * 10));
        setUsers(res.data);
    };

    return (
        <CustomMap
            onMouseOver={onMouseOver}
            users={users}
            googleMapURL="https://maps.googleapis.com/maps/api/js?key=AIzaSyADBW2MReyXCEh7HHdKgQVTqYVm3acBC6o&libraries=geometry,drawing,places"
            loadingElement={<div style={{height: `100%`}}/>}
            containerElement={<div style={{height: `100vh`}}/>}
            mapElement={<div style={{height: `100%`}}/>}
        />
    );
}

export default Maps;
