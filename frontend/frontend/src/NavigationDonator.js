import React from 'react';
import { Link } from 'react-router-dom';

function logOut() {
    localStorage.clear();
    console.log(localStorage);
    window.location.href = '/login';
 }

const NavigationDonator = () => {
  return (
    <header>
        <nav>
        <ul>
            <li>
            <Link to="/">Home</Link>
            </li>
            <li>
            <Link to="/centers">Centers</Link>
            </li>
            <li>
            <Link to="/history">History</Link>
            </li>
            <li>
            <Link onClick={() => logOut()}>LogOut</Link>
            </li>
        </ul>
        </nav>  
    </header>
  );
};

export default NavigationDonator;
