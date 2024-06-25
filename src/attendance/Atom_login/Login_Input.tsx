import React from "react";
import styled from "styled-components";

const InputContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1rem;
`;

const StyledInput = styled.input`
  border: 1px solid #d1d5db;
  padding: 0.5rem;
  width: 100%;
  border-radius: 0.375rem;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
`;

const Login_Input: React.FC = () => {
  return (
    <InputContainer>
      <div>
        <StyledInput type="text" placeholder="아이디를 입력하세요" />
      </div>
      <div>
        <StyledInput type="password" placeholder="비밀번호를 입력하세요" />
      </div>
    </InputContainer>
  );
};

export default Login_Input;
