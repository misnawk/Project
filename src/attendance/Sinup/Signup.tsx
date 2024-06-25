import React, { useState, useEffect } from "react";
import styled from "styled-components";
import axios from "axios";
import NameInput from "../Atom_Sinup/NameInput";
import GradeInput from "../Atom_Sinup/ClassInput";

const Button = styled.button`
  background-color: #3b82f6;
  color: white;
  padding: 0.5rem;
  border: none;
  border-radius: 0.375rem;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
  cursor: pointer;
  transition: background-color 0.3s;
  margin-top: 1rem;

  &:hover {
    background-color: #2563eb;
  }
`;

const Signup: React.FC = () => {
  const [name, setName] = useState("");
  const [classNum, setClassNum] = useState("");
  const [classes, setClasses] = useState([]);

  useEffect(() => {
    // 반 정보를 가져오기 위한 API 호출
    axios
      .get("http://localhost:3001/api/classes")
      .then((response) => setClasses(response.data))
      .catch((error) => console.error("Error fetching classes:", error));
  }, []);

  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:3001/api/students", {
        studentName: name,
        classNum: parseInt(classNum),
      });
      console.log(response.data);
      alert("등록이 완료되었습니다");
    } catch (error) {
      console.error("Error submitting data:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <NameInput name={name} setName={setName} />
      <GradeInput grade={classNum} setGrade={setClassNum} classes={classes} />
      <Button type="submit">등록</Button>
    </form>
  );
};

export default Signup;
