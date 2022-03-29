//강사님 require앞에 new 붙여야 하는거 아닌가요?
var http = require("http");

var server = http.createServer(function(req, res){
    console.log(req.url);
    
    // request에서 서버로 전송받은  파라미터의 값을 얻기 위해서는 URLSearchParams() 객체를 생성해야함
    var params = new URLSearchParams(req.url.substring(2));
    console.log(params);

    res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
    res.write("<p>번호=" + params.get("num") + "<br>");
    res.write("이름=" + params.get("name") + "<br>");
    res.write("연락처=" + params.get("tel") + "</p>");

    res.write("<form method='post' action='http://127.0.0.1:10002'>");
    res.write("아이디 <input type='text' name='userid'><br>");
    res.write("비밀번호 <input type='password' name='userpwd'><br>");
    res.write("이름 <input type='text' name='username'><br>");
    res.write("<input type='submit' value='post 전송'>");
    res.end("</form>");
});

server.listen(10001, function() {
    console.log('server start...    http://127.0.0.1:10001/?num=1234&name=홍길동&tel=010-1234-5678');
});
