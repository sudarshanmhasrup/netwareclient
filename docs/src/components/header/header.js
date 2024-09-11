import React from 'react';
import { Link } from 'react-router-dom';

// Assets
import logo from "../../assets/logo.png";

// Styles
import "./header.css";

const HeaderTitleWithLogo = () => {
    return(
        <nav className="header-logo-and-title" id="header-logo-and-title">
            <img src={logo} alt="logo" />
            Netware Client
            <span className="release-version" id="release-version">
                v1.0.0
            </span>
        </nav>
    );
}

// Header component
const Header = () => {
    return(
        <header className="header-section" id="header-section">
            <Link to="/"><HeaderTitleWithLogo /></Link>
        </header>
    );
}

export default Header;