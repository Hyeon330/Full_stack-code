import {useState} from 'react';
import './App.css';

function App() {
  const [userInfo, setUserInfo] = useState({});

  const formData = (event) => {
    const fieldName = event.target.id // id의 정보
    const value = event.target.value // value

    setUserInfo(d => ({...d, [fieldName]:value}));
  }

  const submitHandler = (event) => {
    event.preventDefault();
    if((userInfo.pw===undefined || userInfo.pw === '') && (userInfo.id===undefined || userInfo.id === '')){
      alert("아이디와 비밀번호를 입력하세요")
    } else {
      if(userInfo.id===undefined || userInfo.id === '') alert("아이디를 입력하세요");
      if(userInfo.pw===undefined || userInfo.pw === '') alert("비밀번호를 입력하세요");
    }
  }

  return (
    <div>
      <h1>로그인</h1>
      <form onSubmit={submitHandler}>
        <ul>
          <li>
            <label>아이디</label><br/>
            <input type="text" id='id' value={userInfo.id || ''} onChange={formData}/>
          </li>
          <li>
            <label>비밀번호</label><br/>
            <input type="password" id='pw' value={userInfo.pw || ''} onChange={formData}/>
          </li>
          <input type="submit" value="로그인"/>
        </ul>
      </form>
    </div>
  );
}

export default App;
