const fs=require('fs');
var http = require('http');
var url = require('url');
var express = require("express");
var app = express();
var path = require('path');
var bodyParser = require("body-parser");
var utils=require('./utils.js');
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(__dirname + '/public'));
app.set("view engine","ejs");
app.get("/", function(req, res) {
    res.sendFile(path.join(__dirname + '/index.html'));
});
app.post("/risposta", function(req,res){
  utils.memorizzaPostIt(req.body.a, req.body.d);
  res.write(utils.LeggiPostIt());
  res.end();
});
var port = process.env.PORT || 5000;
app.listen(port, function() {
    console.log("Listening on " + port);
});