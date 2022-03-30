var fs = require('fs');

// 1. 비동기식으로 파일 쓰기
var writeDate = "비동기식으로 파일 쓰기 연습 중...\r\n줄바꿈 확인...";

//           파일명,                     , 쓰기할 내용, 인코딩, 콜백함수
fs.writeFile(__dirname+'/file_write.txt', writeDate, 'utf-8', function(err) {
    if(err){
        console.log("비동기식으로 쓰기 실패\n"+err);
    }else {
        console.log("비동기식으로 파일 쓰기 성공!");
    }
});

// 2. 동기식으로 파일 쓰기
var writeDataSync = "동기식으로 파일 쓰기 연습 중...";
try {
    fs.writeFileSync(__dirname+"/file_writeSync.txt", writeDataSync, 'utf-8');
    console.log("동기식 쓰기 완료!!");
} catch (error) {
    console.log(error);
}