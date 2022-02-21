import logo from './logo.svg';
import './App.css';

function App() {
  const style = {
    padding: "10px",
    backgroundColor: "gray",
    color: "white",
    margin: "5px"
  };
  // 이벤트 발생시 처리할 함수
  const eventTest = ()=>{
    alert("이벤트가 발생함~~~~");
  }
  const eventTest2 = (event) => {
    alert("이벤트가 발생함!!!! -> " + event);
  }
  const eventTest3 = (e, m) => {
    console.log(e);
    alert(m +" : "+ e._reactName);
  }
  return (
    /* javascript jquery  react(대소문자 구별됨) */
    /* onclick    click   onClick, onMouseover */
    <div className="App">
      {/* 이벤트 발생시 함수 호출 */}
      <button style={style} onClick={eventTest}>클릭이벤트처리하기</button>
      {/* 이벤트 발생시 매개변수에 데이터 전달하여 함수 호출 */}
      <button style={style} onClick={()=>eventTest2('click')}>클릭(매개변수함수호출)</button>
      <button style={style} onClick={(event)=>eventTest3(event, 'event종류알아보기')}>클릭(이벤트종류) </button>
    </div>
  );
}

export default App;
