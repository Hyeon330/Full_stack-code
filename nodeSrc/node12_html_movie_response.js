var http = require('http');
var fs = require('fs');
var mime = require('Mime');

var server = http.createServer(function(req, res) {
    var mapping = req.url;
    
    if(mapping=='/'){   // html 문서 보내기
        fs.readFile(__dirname + '/movie_play.html','utf-8',function(err, htmlData) {
            if(!err){
                res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                res.end(htmlData);
            }
        });
    }else if(mapping.indexOf('/img')==0) {  // img 보내기
        var mimeName = mime.getType(mapping.substring(1));
        console.log(mimeName);

        fs.readFile(__dirname+mapping, function(err, data) {
            if(!err){
                res.writeHead(200, {'Content-Type':mimeName});
                res.end(data);
            }
        });
    }else if(mapping.indexOf('/movie')==0) {    // video 보내기
        // 동영상은 파일이 크기 때문에 스트리밍 처리로 전송한다.(한번에 65535 byte 읽어옴)

        // 1. 스트리밍 처리를 위한 객체를 생성한다.
        var stream = fs.createReadStream(mapping.substring(1));

        // 2. 스트리밍 처리를 하기 위해선 여러번 데이터를 전송해야 하며,
        // event를 이용하여 처리한다.

        // data 이벤트 : 데이터가 read된 경우 호출되는 이벤트
        var cnt = 1;
        stream.on('data', function(data) {
            res.write(data);
            console.log(cnt++ + '번째 전송.' + data.length);
        });
        // end 이벤트 : 데이터가 read의 마지막일때 호출되는 이벤트
        stream.on('end', function() {
            res.end();
            console.log('stream end...');
        });
        // error 이벤트 : 데이터 read시 에러 발생할 경우 호출되는 이벤트
        stream.on('error', function() {
            res.end();
            console.log("error stream...");
        });
    }

}).listen(10008, function() {
    console.log('Server Start => http://localhost:10008/');
});