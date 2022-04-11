// npm install express
// npm install request-ip : 접속자 ip 구하는 모듈
// npm install mysql2 : DB연동 모듈
// npm install ejs : ejs 모듈
// npm install express-session : 세션모듈

var http = require('http');
var express = require('express');
var fs = require('fs');
var ejs = require('ejs');
var requestip = require('request-ip');
var session = require('express-session');

// 서버 생성
var app = express();
var server = http.createServer(app);

// POST방식 접속시 데이터 request를 위한 설정
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:true})); // 한글인코딩

// Mysql Connection
var mysql = require('mysql2');
const res = require('express/lib/response');
const { url } = require('inspector');
const { redirect } = require('express/lib/response');

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
    fs.readFile(__dirname + '/index.ejs', 'utf-8', function(err, indexData) {
        res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        res.end(ejs.render(indexData, {logStatus: 'N'}));
    });
});
// 로그인 
app.get("/login", function(req, res){
    fs.readFile(__dirname+"/login.html", 'utf-8', (err, loginData) => {
        res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        res.end(loginData);
    });
});

// 로그인 DB
app.post('/loginOk', (req, res) => {
    var userid = req.body.userid;
    var userpwd = req.body.userpwd;

    console.log('id='+userid+', pw='+userpwd);

    var sql = 'select userid, username from member where userid=? and userpwd=?'

    connection.execute(sql, [userid, userpwd], (err, result) => {
        console.log(result);
        if(err || result.length == 0){
            res.redirect('/login');
        }else {
            session.user = {
                userid: result[0].userid,
                username: result[0].username,
                autorized: true // 인증받은, 검정필
            }
            fs.readFile(__dirname+'/index.ejs', 'utf-8', (e, d) => {
                res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
                if(e) {
                    res.end("404 Page...");
                }else {
                    res.end(ejs.render(d, {
                        user : session.user,
                        logStatus: 'Y'
                    })); 
                }
            });
        }
    });
});

// 로그아웃 
app.get('/logout', (req, res) => {
    if(session.user){
        session.user = null; // 세션정보 지우기
        fs.readFile(__dirname+'/index.ejs', 'utf-8', (e, d) => {
            res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
            res.end(ejs.render(d, {logStatus: 'N'}));
        });
    }else{
        console.log('로그아웃 상태');
    }
});

// 게시판 리스트 select
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

// 글쓰기 폼
app.get('/write',(req,res) => {
    fs.readFile(__dirname + '/write.html','utf-8',(err, data) => {
        if(!err){
            res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
            res.end(data);
        }
    });
});
// 글쓰기 DB등록 insert
app.post('/writeOk',(req, res) => {
    var userid = req.body.userid;
    var subject = req.body.subject;
    var content = req.body.content;

    var ip = requestip.getClientIp(req).substring(7); // 접속자 ip구하기     ::ffff:127.0.0.1

    var sql = "insert into board (userid, subject, content, ip)";
    sql += "values (?,?,?,?)";
    var bindData = [userid, subject, content, ip];

    connection.execute(sql, bindData, (err, result) => {
        console.log(result);
        if(err || result.affectedRows<1) { // 글쓰기 실패시  affectedRows : insert 처리한 개수
            res.redirect('/write');
        }else { // 글쓰기 성공시
            res.redirect('/list');
        }
    });
});

// 글내용 보기select
app.get('/view',(req, res)=>{
    // get방식 접속 데이터
    let url = req.url;  //  /view?no=111;
    let params = url.split('?')[1];
    let noObj = new URLSearchParams(params);
    var bindData = [noObj.get("no")];
    // 조회수 증가
    var sql = "update board set hit=hit+1 where no=?"
    connection.execute(sql, bindData, (e, r) => {
        console.log(r);
    });
    // 글 선택
    sql = "select no, userid, subject, content, hit, writedate ";
    sql += "from board ";
    sql += "where no=?";

    connection.execute(sql, bindData, (e, r) => {
        if(e){
            res.redirect('/list');
        }else {
            console.log(r);
            fs.readFile(__dirname+'/view.ejs', 'utf-8', (e2, tag) => {
                res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                res.end(
                    ejs.render(tag, {result: r})
                );
            });
        }
    });
});

// 글수정select
app.get('/edit', (req, res) => {
    var params = new URLSearchParams(req.url.split('?')[1]);

    var sql = "select subject, content, no from board where no=?";

    connection.execute(sql, [params.get('no')], (err, r) =>{
        console.log(r);
        if(err, r==null){
            res.redirect('/view?no='+params.get('no'));
        }else {
            
            fs.readFile(__dirname+'/edit.ejs', 'utf-8', (e, tag) => {
                res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                res.end(ejs.render(tag, {record:r}));
            });

        }
    })
});
// 글수정 DB indsert
app.post('/editOk',(req, res) => {
    var no = req.body.no;
    var subject = req.body.subject;
    var content = req.body.content;

    var sql = 'update board set subject=?, content=? where no=?';
    var bindData = [subject, content, no];

    connection.execute(sql, bindData, (err, r) => {
        // console.log(r);
        if(err || r.changedRows<1){ // 수정안됨
            res.redirect('/edit?no='+no);
        }else {
            res.redirect('/view?no='+no);
        }
    });
});

// 삭제
app.get('/del', (req, res) => {
    var params = new URLSearchParams(req.url.split('?')[1]);

    var sql = "delete from board where no=?";
    connection.execute(sql, [params.get('no')], (err, result) => {
        if(err){
            res.redirect('/view?no='+params.get('no'));
        }else {
            res.redirect('/list');
        }
    });
});

server.listen(10010, function(){
    console.log('Server Start => http://localhost:10010/index');
});