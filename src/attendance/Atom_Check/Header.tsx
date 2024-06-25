import styled from "styled-components";

const Head = styled.div`
  width: 100vw;
`;

const Header = () => {
  return (
    <div>
      <div>
        <input type="text" placeholder="이름으로 검색" />
        <button>검색</button>
      </div>
    </div>
  );
};

export default Header;
