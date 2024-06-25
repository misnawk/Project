import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Signup from "./attendance/Sinup/Signup";
import Login from "./attendance/Login/Login";
import AttendanceCheck from "./attendance/Cheak/attendanceCheck";

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/AttendanceCheck" element={<AttendanceCheck />} />
      </Routes>
    </Router>
  );
};

export default App;
