import React from "react";
import styled from "styled-components";

type LoginTextProps = {
  Text: string;
};

const Title = styled.div`
  margin-bottom: 2rem;
  font-size: 1.5rem;
  font-weight: bold;
`;

const LoginText: React.FC<LoginTextProps> = ({ Text }) => {
  return <Title>{Text}</Title>;
};

export default LoginText;
