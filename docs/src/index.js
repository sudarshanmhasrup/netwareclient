// React imports
import React from "react";
import ReactDOM from "react-dom/client";

// Import app
import App from "./App";

// React root configuration
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);