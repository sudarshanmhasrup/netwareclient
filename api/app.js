const express = require("express");
const app = express();

// API middleware
const apiMiddleware = require("./middleware/api-middleware");
app.use(apiMiddleware);

// Message to be sent when API connection is successful
app.get("/", (req, res) => {
    res.status(200).json({
        message: "API connection established successful!",
        status: 200
    });
});

module.exports = app;
