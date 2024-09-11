import React from 'react';

// Styles
import "./home.css";
import "./responsive.css";

// Components
import LeftContainer from './leftContainer';
import RightContainer from './rightContainer';

const HomePage = () => {
    return(
        <section className="home-page" id="home-page">
            <div className="home-section-half-left" id="home-section-half-left">
                <LeftContainer />
            </div>

            <div className="home-section-half-right" id="home-section-half-right">
                <RightContainer />
            </div>
        </section>
    );
}

export default HomePage;
