import { useState } from 'react';
import './loginStyle.css';

function Login(){
    const divHeight = {
        height: '20px',
        color: '#f00'
    }
    // 아이디 유효성겁사 결과를 저장할 hook변수
    const [logIdErrorMessage, setLogIdErrorMessage] = useState('');
    // 비밀번호 유효성검사 결과를 저장할 hook변수
    const [logPwdErrorMessage, setLogPwdErrorMessage] = useState('');

    // form의 데이터(id, pwd)를 담을 hook변수
    const [logFormData, setLogFormData] = useState({
        userid: '',
        userpwd: ''
    });

    // 아이디와 비밀번호의 입력변경이 있을 경우 hook의 값을 변경할 함수
    //                      방금 이벤트가 발생한 객체
    const loginDataChange = (e) => {
        // 기존의 에러메세지를 지우기
        setLogIdErrorMessage('');
        setLogPwdErrorMessage('');

        // 이벤트가 발생한 객체에서 name속성의 값 가져오기
        const name = e.target.name; // userid, userpwd -> key로 사용
        const value = e.target.value // 입력 데이터     -> value로 사용

        setLogFormData(logValue=>({...logValue, [name]:value}));
        console.log(logFormData);
    }
    // form이 submit이 발생 하면 유효성검사하기
    const loginSubmit = (e) => {
        // form의 기본 이벤트를 해제... action에 표기한 곳으로 이동하는 것을 막는다.
        e.preventDefault();

        // 아이디 입력유무 확인
        if(logFormData.userid.length===0){
            setLogIdErrorMessage('아이디를 입력하세요.');
            return false;
        }

        // 아이디 - 정규표현식 유효성검사하기
        // 아이디 : 영문 대소문자, _, 6~12까지 허용
        const useridReg = /^[a-zA-Z0-9_]{6,12}$/;   // /^\w[6,12]$/
        if(!useridReg.test(logFormData.userid)){
            setLogIdErrorMessage('영문 대소문자, _, 글자수는 6~12글자까지 가능합니다.');
            return false
        }

        // 비밀번호 입력유무 확인
        if(logFormData.userpwd.length===0){
            setLogPwdErrorMessage('비밀번호를 입력하세요.');
            return false;
        }

        // 백엔드...
    }
    return(
        <div className='loginFormCenter'>
            <h1>로그인</h1>
            <form onSubmit={loginSubmit}>
                <div className='form-group'>
                    <label>아이디</label>
                    <input type="text" name="userid" id="userid" placeholder="아이디입력" className='form-control' onChange={loginDataChange}/>
                    <div style={divHeight}>{logIdErrorMessage}</div>
                </div>
                <div className='form-group'>
                    <label>비밀번호</label>
                    <input type="password" name="userpw" id="userpw" placeholder="비밀번호입력" className='form-control' onChange={loginDataChange}/>
                    <div style={divHeight}>{logPwdErrorMessage}</div>
                </div>
                <input type="submit" value="로그인" className="form-control btn btn-secondary"/>
            </form>
        </div>
    );
}

export default Login;