var express = require("express");
var app = express();
var path = require('path');

var bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));

app.get('/', function(req, res) {
    res.sendFile(path.join(__dirname + '/index.html'));
});

app.post('/contact', function(req,res){
   console.log(req.body.firstname);
  
   res.writeHead(200, {"Content-Type": "text/html"});
   res.write('<!DOCTYPE html>'+
   '<HTML><BODY>'+
   '<FORM method="post" ACTION="/contact">'+
   'nome:'+'<i>'+'<b>'+req.body.firstname+'</b>'+'</i>'+
   '<BR>'+
   'cognome: '+'<i>'+'<b>'+req.body.lastname+'</b>'+'</i>'+
    '<BR>'+
   'Country:'+'<i>'+'<b>'+req.body.country+'</b>'+'</i>'+
    '<BR>'+
    'Subject:'+'<i>'+'<b>'+req.body.subject+'</b>'+'</i>'+
   '</FORM>'+
   '</BODY></HTML>');
   res.end();
});

var port = process.env.PORT || 5000;

app.listen(port, function() {
    console.log("Listening on " + port);
});