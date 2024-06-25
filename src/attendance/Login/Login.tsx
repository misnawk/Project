import React from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import LoginText from "../Atom_login/Login_Text";
import Login_Input from "../Atom_login/Login_Input";
import LoginButton from "../Atom_login/Login_button";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f3f4f6;
`;

const Form = styled.div`
  background-color: white;
  padding: 2rem;
  border-radius: 0.5rem;
  box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1);
  max-width: 400px;
  width: 100%;
`;

const ButtonBox = styled.div`
  display: flex;
  justify-content: center;
  gap: 25px;
  padding: 20px;
  margin-top: 1rem;
`;

const SignupButton = styled.button`
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

const Login: React.FC = () => {
  const navigate = useNavigate();

  const handleSignup = () => {
    navigate("/signup");
  };


  return (
    <Container>
      <Form>
        <LoginText Text="" />
        <Login_Input />
        <ButtonBox>
          <LoginButton />
          <SignupButton onClick={handleSignup}>학생등록</SignupButton>
        </ButtonBox>
      </Form>
    </Container>
  );
};

export default Login;
