// NameInput.tsx
import React from "react";
import styled from "styled-components";

const StyledInput = styled.input`
  border: 1px solid #d1d5db;
  padding: 0.5rem;
  width: 100%;
  border-radius: 0.375rem;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
`;

interface NameInputProps {
  name: string;
  setName: (name: string) => void;
}

const NameInput: React.FC<NameInputProps> = ({ name, setName }) => {
  return (
    <StyledInput
      type="text"
      name="name"
      placeholder="이름"
      value={name}
      onChange={(e) => setName(e.target.value)}
    />
  );
};

export default NameInput;
