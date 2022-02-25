import './App.css';

// function App() { // jsx - javascript xml
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

function Hello() {
  const name = "홍길동";
  // 리엑트에서 함수 생성하기
  function myWelCome(){
    let hello = "하이!!!";
    if(true){
      let hello = "헬로우";
      console.log(hello);
    }
    return hello;
  }
  return (
    <div>
      <h1>바로반응한다.</h1>
      <p>Welcome Page : {name}</p>

      <ul>
        <li> name : {name}</li>
        <li> welCome : {myWelCome()}</li>
      </ul>
    </div>
  );
}

export default Hello;
