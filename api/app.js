const express = require("express");
const app = express();

// Message to be sent when API connection is successful
app.get("/", (req, res) => {
    res.status(200).json({
        message: "API connection successful!",
        status: 200
    });
});

module.exports = app;