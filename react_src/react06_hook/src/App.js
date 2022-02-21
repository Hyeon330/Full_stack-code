import React, {useState} from 'react';
import Test from './Test.js'; // js파일을 사용하기 위해 import해야 한다.
import './App.css';

function App() {
  const name = "홍길동";
  // React의 useState 훅을 사용하면 함수의 데이터 상태를 추적할 수 있다.
  const [color, setColor] = useState("RED");
  const [tel, setTel] = useState("010-1234-5678");

  const arr = ["111", "222", "333", "444", "555", "666"];
  function ArrList(props){
    return <li>{props.arrName}</li>
  }

  return (
    <div>
      <h1>Color : {color}, tel : {tel}</h1>
      <button onClick={()=>setColor("Green")}>컬러변경(Green)</button>
      <button onClick={()=>setTel("010-1212-3434")}>연락처변경</button>
      <hr/>
      {<Test/>}
      <div>배열을 반복문처리</div>
      <ol>
        {/* map()함수를 이용해 배열의 반복처리를 한다. */}
        {/* 배열명.map() */}
        {arr.map((a)=><ArrList arrName={a}/>)}
      </ol>
    </div>
  );
}

export default App;
