import React from "react";
import styled from "styled-components";

const StyledSelect = styled.select`
  border: 1px solid #d1d5db;
  padding: 0.5rem;
  width: 100%;
  border-radius: 0.375rem;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
  margin-top: 0.5rem;
`;

interface GradeInputProps {
  grade: string;
  setGrade: (grade: string) => void;
  classes: { classNum: number; className: string }[];
}

const GradeInput: React.FC<GradeInputProps> = ({
  grade,
  setGrade,
  classes,
}) => {
  return (
    <StyledSelect value={grade} onChange={(e) => setGrade(e.target.value)}>
      <option value="">반 선택</option>
      <option value="1">오전반</option>
      <option value="2">점심반</option>
      <option value="3">저녁반</option>

      {classes.map((cls) => (
        <option key={cls.classNum} value={cls.classNum}>
          {cls.className}
        </option>
      ))}
    </StyledSelect>
  );
};

export default GradeInput;
