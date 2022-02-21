import './App.css';

function App() {
  /*스타일시트를 json으로 작성하여 적용하기*/
  const style1 = {
    backgroundColor: '#000',
    padding: '20px',
    color: '#fff',
    marginTop: '10px',
    textAlign: 'center'
  };
  return (
    <div>
      {/*json스타일 적용하기*/}
      <div style={style1}>json스타일 적용하기</div>
      <div>
        {
          1+1==2
          ? (<h1>맞습니다...</h1>)
          : (<h1>틀립니다...</h1>)
        }
      </div>
      <div>
        <div>참일 때 실행문장만 있을 때</div>
        {
          1+1==2 && (<h1>맞아요~~~~</h1>)
        }
      </div>
      <div>
        <div>함수를 이용한 실행</div>
        {
          (
            function(){
              let v="";
              for(let i=1; i<=10; i++){
                v += i;
              }
              return (<h2>{v}</h2>);
            }
          )()
        }
      </div>
      <div>
        {
          (
            ()=>{
              let value = 1234;
              if(value === 1234) return (<p>람다식 함수 생성하여 실행됨</p>)
            }
          )()
        }
      </div>
    </div>
  );
}

export default App;
