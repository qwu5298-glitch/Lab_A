// var http = require("http");
// console.log("Starting...");
// var host = "127.0.0.1";
// var port = 80; 
// server = http.createServer(function (request, response) {
//     console.log("Got a request: " + request.url);
//     // response.writeHead(200, {"Content-type": "text/plain"});
//     // response.writeHead(200, {"Content-type": "text/html"});
//     response.writeHead(200, { "Content-type": "application/xml" });
//     response.end("<book><title>OOO</title><price>500</price></book>");
// });

// server.listen(port, host, function () {
//     console.log("Listening...");
// });

var express = require("express");
var app = express();
app.listen(80);

app.use(function (request, res, next) {
    request.lab = Date();
    next();
})

app.use(express.static("./public"));

app.get("/", function (request, resonse) {
    resonse.send("Home page: " + request.lab);
})



app.get("/hello/:who", function (request, response) {
    response.send("Hello!" + request.params.who);
})

app.get("/prod/price/:min/:max", function (request, resonse) {
    resonse.send(`product list, price from ${request.params.min} to ${request.params.max}`);
})

