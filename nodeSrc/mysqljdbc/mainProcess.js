// npm install express
// npm install request-ip : 접속자 ip 구하는 모듈
// npm install mysql2 : DB연동 모듈
// npm install ejs : ejs 모듈

var http = require('http');
var express = require('express');
var fs = require('fs');
var ejs = require('ejs');

// 서버 생성
var app = express();
var server = http.createServer(app);

// Mysql Connection
var mysql = require('mysql2');
// mysql.autoCommit() // 자동커밋

// DB연결
var connection = mysql.createConnection({
    host : "127.0.0.1",
    port : 3306,
    user : 'root',
    password : '1234',
    database : 'campusdb'
});
connection.connect();

// get(), post()
// 홈페이지로 이동하기 : http://localhost:10010/index
app.get('/index', function(req, res) {
    console.log(__dirname)
    fs.readFile(__dirname + '/index.html', 'utf-8', function(err, indexData) {
        res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        res.end(indexData);
    });
});
// 게시판 리스트
app.get('/list', function(req, res) {
    var sql = 'select no, subject, userid, hit, date_format(writedate,"%m-%d %H:%i") writedate';
    sql += " from board order by no desc";

    // 쿼리문 실행하기
    connection.execute(sql, (err, result) => {
        // 선택한 레코드 수
        console.log(result);
        var totalRecord = result.length;
        if(totalRecord > 0){    // 선택한 레코드 존재할 시 list페이지로 보내기
            fs.readFile(__dirname + '/list.ejs', 'utf-8', (err2, listData) => {
                console.log(typeof listData);
                res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                res.end(
                    ejs.render(listData,{
                        results: result,
                        parsing: {
                            totalRecord : totalRecord,
                            nowPage: 3,
                            startPage: 1,
                            onePageRecord: 5
                        }
                    })
                );
            });
        }
    });
});


server.listen(10010, function(){
    console.log('Server Start => http://localhost:10010/index');
});