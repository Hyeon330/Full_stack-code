import {useState} from 'react';
import './App.css';

function MemberForm() {
  // 폼에 입력된 데이터는 hook에 저장할 변수
  const [member, setMember] = useState({});
  
  // 폼의 데이터가 변경되면 호출하여 hook에 정보를 저장하는 함수
  const formData = (event) => {
    const fieldName = event.target.name // name의 정보
    const value = event.target.value // value

    // [key] : 문자열의 json의 키값으로 사용할 때     fieldName:value   "username": 홍길동
    setMember(data=>({...data, [fieldName]:value}));
    // console.log(member);
  }
  const submitHandler = (event) => {
    event.preventDefault();
    console.log(member);
    alert(member.username);
  }
  return (
    <div>
      <h1>react에서 폼만들기</h1>
      <form onSubmit={submitHandler}>
        <label>이름 : <input type="text" name="username"
                      value={member.username || ''} onChange={formData}/></label><br/>
        <label>연락처 : <input type="text" name="tel"
                        value={member.tel || ''} onChange={formData}/></label><br/>
        <label>주소 : <input type="text" name="addr"
                      value={member.addr || ''} onChange={formData}/></label><br/>
        <input type="submit" value="등록"/>
      </form>
    </div>
  );
}

export default MemberForm;
