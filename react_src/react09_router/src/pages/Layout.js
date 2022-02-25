import { Outlet, Link } from "react-router-dom";
import './style.css';
import styled from 'styled-components';

// styled-components설치 - npm install styled-components
//          => Link태그를 이용하여 원하는 스타일이 있는 태그로 생성하여 사용하기
// 스타일이 적용된 태그를 만들어 태그로사용하기
const StyledLink = styled(Link)`
    text-decoration: none;

    &:link, &:visited, &:active{
        color: yellow;
    }
    &:hover{
        color: cyan;
    }
`;

const Layout = () => {
    return(
        <div>
            {/* 메뉴 */}
            <nav>
                <ul className="Menu-layout">
                    {/* <li><Link to="/">홈페이지</Link></li>
                    <li><Link to="/customer">고객센터</Link></li>
                    <li><Link to="/notice">공지사항</Link></li>
                    <li><Link to="/login">로그인</Link></li> */}
                    <li><StyledLink to="/">홈페이지</StyledLink></li>
                    <li><StyledLink to="/customer">고객센터</StyledLink></li>
                    <li><StyledLink to="/notice">공지사항</StyledLink></li>
                    <li><StyledLink to="/login">로그인</StyledLink></li>
                </ul>
            </nav>
            {/* 링크에 의해 접속되는 페이지를 표시하는 곳 */}
            <Outlet/>
        </div>
    );
}

export default Layout