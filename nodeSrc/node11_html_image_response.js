var http = require('http');
var fs = require('fs');

// mime모듈 추가하는 방법
// npm 명령어를 이용하여 추가
// > npm install mime@2
var mime = require('mime');

var server = http.createServer(function(req, res){
    var addr = req.url;
    console.log(addr);
    console.log(__dirname);
    console.log(addr.indexOf('/img')==0)
    
    if(addr=='/home') {
        // home.html파일의 내용을 읽어서 response에 쓰기를 한다.
        fs.readFile(__dirname+'/home.html', 'utf-8', function(error, data){
            if(error){
                console.log("파일 읽기 실패... home.html");
            }else {
                res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                res.end(data);
            }
        });
    } else if(addr=='/subpage') {
        fs.readFile(__dirname + "/subpage.html", 'utf-8', function(err, data) {
            if(!err){
                res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                res.end(data);
            }
        });
    }else if(addr.indexOf('/img') == 0){ // 이미지일 경우
        // 마임 구하기
        var mimeType = mime.getType(addr.substring(1));
        console.log(mimeType);

        fs.readFile(__dirname+addr, function(err, imgData) {
            if(!err){
                res.writeHead(200, {'Content-Type':mimeType});
                res.end(imgData);
            }
        });
    }
}).listen(10007, function(){
    console.log('Server Start => http://127.0.0.1:10007/home');
});