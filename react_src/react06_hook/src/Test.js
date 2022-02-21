import {useState} from 'react';
function Test() {
    const [myInfo, setMyInfo] = useState({
        username: "홍길동",
        tel: "010-4567-8956",
        addr: "서울시 강남구",
        email: "abcd@gmail.com"
    });
    console.log(myInfo);

    // 나머지 데이터를 보존하면서 수정되는 함수
    const updateInfos = () => {
        setMyInfo( prevState/* 이전 상태 */ =>{
            return {...prevState, addr:"서울시 영등포구", email:"aaa@naver.com"};
        });
    }

    const updateInfo = (v) => {
        if(v==="name"){
            setMyInfo( prevState/* 이전 상태 */ =>{
                return {...prevState, username:"Hyeon330"};
            });
        } else if(v==="tel"){
            setMyInfo( prevState/* 이전 상태 */ =>{
                return {...prevState, tel:"010-4848-5959"};
            });
        } else if(v==="addr"){
            setMyInfo( prevState/* 이전 상태 */ =>{
                return {...prevState, addr:"서울시 성남구"};
            });
        } else if(v==="email"){
            setMyInfo( prevState/* 이전 상태 */ =>{
                return {...prevState, email:"abc@daum.net"};
            });
        }
    }

    const updateInfo2 = (part, data) => {
        setMyInfo(p=>{
            if(part === 1) return {...p, username:data};
            if(part === 2) return {...p, tel:data};
            if(part === 3) return {...p, addr:data};
            if(part === 4) return {...p, email:data};
        });
    }

    const divStyle = {
        margin:"10px"
    };
    const buttonStyle = {
        marginRight: "10px"
    }
    return(
        <div>
            <ol>
            <li>이름 : {myInfo.username}</li>
            <li>전화번호 : {myInfo.tel}</li>
            <li>주소 : {myInfo.addr}</li>
            <li>이메일 : {myInfo.email}</li>
            </ol>
            {/* 터이터중 1개만 수정할 시 나머지 데이터는 초기화 된다. */}
            <button onClick={() => setMyInfo({tel:'010-7777-8888'})}>연락처 변경</button>
            {/* 기존 데이터를 보존 하면서 새로운 데이터가 수정되는 함수를 생성 */}
            <button onClick={updateInfos}>일부정보변경</button>
            <div style={divStyle}>
                {/* 내 코드 */}
                <button style={buttonStyle} onClick={() => updateInfo("name")}>이름변경</button>
                <button style={buttonStyle} onClick={() => updateInfo("tel")}>연락처</button>
                <button style={buttonStyle} onClick={() => updateInfo("addr")}>주소</button>
                <button onClick={() => updateInfo("email")}>이메일</button>
            </div>
            <hr/>
            <div style={divStyle}>
                {/* 강사님 코드 */}
                <button style={buttonStyle} onClick={() => updateInfo2(1, "HHH")}>이름변경</button>
                <button style={buttonStyle} onClick={() => updateInfo2(2, "010-0000-0000")}>연락처</button>
                <button style={buttonStyle} onClick={() => updateInfo2(3, "청주시 흥덕구")}>주소</button>
                <button onClick={() => updateInfo2(4, "ddd@nate.com")}>이메일</button>
            </div>
        </div>
    );
}

export default Test;