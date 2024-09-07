// Get route test
const express = require("express");
const app = express.Router();

// GET route
app.get("/get/hello-world", (req, res) => {
    res.status(200).json({
        message: "Hello World!",
        status: 200
    });
});

module.exports = app;