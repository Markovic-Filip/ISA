import React from 'react';
import { Link } from 'react-router-dom';

const Navigation = () => {
  return (
    <header>
        <nav>
        <ul>
            <li>
            <Link to="/">Home</Link>
            </li>
            <li>
            <Link to="/login">LogIn</Link>
            </li>
            <li>
            <Link to="/register">Register</Link>
            </li>
        </ul>
        </nav>  
    </header>
  );
};

export default Navigation;
