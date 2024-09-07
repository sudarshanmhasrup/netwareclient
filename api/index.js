const http = require("http");
const app = require("./app");

// Server setup
const server = http.createServer(app);
const port = process.env.PORT || 3000;

// listen server
server.listen(port, () => {
    console.log(`The API is live at: http://localhost:${port}`);
});