import React from "react";
import styled from "styled-components";

const Button = styled.button`
  background-color: #6b7280;
  color: white;
  padding: 0.5rem;
  border: none;
  border-radius: 0.375rem;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
  cursor: pointer;
  transition: background-color 0.3s;

  &:hover {
    background-color: #4b5563;
  }
`;

const SignupButton: React.FC = () => {
  return (
    <div className="mt-2">
      <Button>회원가입</Button>
    </div>
  );
};

export default SignupButton;
