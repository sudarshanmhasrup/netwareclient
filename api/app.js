const express = require("express");
const app = express();

// API middleware
const apiMiddleware = require("./middlewares/api-middleware");
app.use(apiMiddleware);

// Test routes
const get = require("./test/get");
app.use(get);

// Message to be sent when API connection is successful
app.get("/", (req, res) => {
    res.status(200).json({
        message: "API connection established successfully!",
        status: 200
    });
});

module.exports = app;
