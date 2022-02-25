import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Layout from './pages/Layout';
import Home from './pages/Home';
import Customer from './pages/Customer';
import Notice from './pages/Notice';
import Login from './pages/member/Login';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout/>}>
          <Route index element={<Home/>}/>
          <Route path='/customer' element={<Customer/>}/>
          <Route path='/notice' element={<Notice/>}/>
          <Route path='/login' element={<Login/>}/>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
