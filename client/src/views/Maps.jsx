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

let tryt = () => {
    return <Marker position={{lat: 40.7481, lng: -73.985428}}/>;
};

const CustomMap = withScriptjs(
    withGoogleMap(props => (

        <GoogleMap
            key={new Date().getTime()}
            onClick={props.onMouseOver}
            defaultZoom={20}
            defaultCenter={{lat: 41.6654294, lng: -87.6168563}}
            defaultOptions={{
                scrollwheel: false,
                zoomControl: true
            }}
        >
            <Marker position={{lat: 41.6654294, lng: -87.6168563}}/>
            <Marker position={{lat: 41.6653294, lng: -87.6163563}}/>
            <Marker position={{lat: 41.6655294, lng: -87.6168563}}/>
            {/*{props.users.map((user) => {*/}
                {/*console.log(user);*/}
                {/*return <Marker position={{lat: 41.6654294, lng: -87.6168563}}/>;}*/}
            {/*)}*/}
        </GoogleMap>
    ))
);


function Maps({...prop}) {

    const [users, setUsers] = useState(null);
    let onMouseOver = async () => {

        let res = await axios.get('http://localhost:8080/users/block/3');
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
