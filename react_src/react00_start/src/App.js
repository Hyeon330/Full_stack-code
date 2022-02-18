import logo from './logo.svg';
import './App.css';
import img from './img/5.png';

function App() { // jsx - javascript xml
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      <div className='Text-left'>
        {/* 따옴표사용하면 안됨 */}
        <img src={img} className="App-logo"/>
        <ul>
          <li>리엑트는 프론트엔드 자바스크립트 라이브러리이다</li>
          <li>유저의 행동흐름에 따라서 동적으로 화면을 보여줄 수 있다.</li>
          <li>
            <ol>
              <li>Node.js설치: nodejs.org에서 LTS버전 설치(무지성 next)</li>
              <li>리엑트 프로젝트를 생성 해주는 npm install -g create-react-app 한다.
                <p>
                  npm install -g create-react-app
                </p>
              </li>
              <li>해당 폴더에서 프로젝트 생성
                <p>
                  create-react-app (프로젝트 명)
                </p>
              </li>
              <li>
                프로젝트 실행: 프로젝트 폴더로 이동 후
                <p>
                  npm start
                </p>
              </li>
            </ol>
          </li>
        </ul>
      </div>
    </div>
  );
}
//            함수 이름
export default App; // 파일 내보냄
