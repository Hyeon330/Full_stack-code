var http = require('http');
var fs = require('fs');

var server = http.createServer((req, res) => {
    if(req.url =='/room'){
        fs.readFile(__dirname+'/chatting_room.html', 'utf-8', (err, data) => {
            res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
            res.end(data);
        });
    }
}).listen(11001, () => {
    console.log("Server Start => http://localhost:11001/room");
});

var socketio = require('socket.io');

var io = socketio.listen(server);
// 접속대기
io.sockets.on('connection', (socket) => {
    // 방만들기
    var rName;
    socket.on('join', (roomName) => {
        console.log(roomName);
        socket.join(roomName);
        rName = roomName
        socket.emit('response', roomName+'방이 만들어 졌습니다.');
    });

    // 클라이언트가 메시지를 보내면 받을 이벤트
    socket.on('message', function(data) {
        // 같은 방에 있는 클라이언트에게 문자 보내기
        io.sockets.in(rName).emit('response', rName+"=> "+data);
    });
});