import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// Styles
import './css/style.css';

// Components
import Header from './components/header/header';
import HomePage from './pages/homePage/homePage';

// App component
const App = () => {
    return (
        <>
            <Router>
                <Header />
                <main className="main-section" id="main-section">
                    <Routes>
                        <Route path="/" element={<HomePage />} />
                    </Routes>
                </main>
            </Router>
        </>
    );
}

export default App;