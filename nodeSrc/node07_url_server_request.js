var http = require('http');

var server = http.createServer(function(req, res){
    console.log(req.url);

    var pathName = req.url;

    res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
    if(pathName == '/username'){
        res.end("<h1>이름 : 홍길동</h1>");
    }else if(pathName == '/tel'){
        res.end("<h2 style='color:#0000FF'>연락처 : 010-4567-8901</h2>");
    }else if(pathName == '/address'){
        res.end("<h3>주소 : 서울시 강남구 역삼동 멀티캠퍼스</h3>");
    }else {
        res.end("<h1>404 Page Not Found...</h1>");
    }


}).listen(10005, function(){
    console.log("server start => http://127.0.0.1:10005");
    console.log("server start => http://127.0.0.1:10005/username");
    console.log("server start => http://127.0.0.1:10005/tel");
    console.log("server start => http://127.0.0.1:10005/address");
});