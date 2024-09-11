import React from 'react';
import YouTube from 'react-youtube';

// Assets
import codeImage from "../../assets/home-code-image.png";
import { Link } from 'react-router-dom';

// HomeSectionHeadings Component
const HomeSectionHeadings = () => {
    return (
        <div className="home-section-headings" id="home-section-headings">
            <h1>Netware Client</h1>
            <h2>An easy to use and efficient HTTP library for Kotlin and Java.</h2>
            <p>
                Netware Client is a straightforward networking library to simplify networking in Kotlin and Java.
                Start using Netware Client and make your daily life in Kotlin and Java easier.
            </p>
        </div>
    );
};

// HomeSectionButtons Component
const HomeSectionButtons = () => {
    return (
        <div className="home-section-buttons-container" id="home-section-buttons-container">
            <button className="quick-start-button" id="quick-start-button">
                <Link to="/documentation/add-to-project">Add to project</Link>
            </button>
            <button className="learn-button" id="learn-button">
                <Link to="/documentation">Learn</Link>
            </button>
        </div>
    );
};

// HomeCodeImageContainer Component with Responsive YouTube Video
const HomeCodeImageContainer = () => {
    return (
        <div className="home-code-image-container-mobile" id="home-code-image-container-mobile">
            <img src={codeImage}></img>
        </div>
    );
};

// Main HomeSection Component
const LeftContainer = () => {
    return (
        <div className="home-section-half-left-container" id="home-section-half-left-container">
            <HomeSectionHeadings />
            <HomeSectionButtons />
            <HomeCodeImageContainer />
        </div>
    );
};

export default LeftContainer;
