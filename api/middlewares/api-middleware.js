const express = require("express");
const app = express();
require("dotenv").config();

// Check for API key in request headers
app.use((req, res, next) => {
    
    const requestApiKey = req.headers["x-api-key"];
    const apiKey = process.env.API_KEY;

    if (requestApiKey === apiKey) {
        next();
    } else {   
        res.status(401).json({
            message: "Access denied! Invalid API key.",
            status: 401
        })   
    }   
});

module.exports = app;