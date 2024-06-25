// src/server.ts
import express, { Request, Response } from "express";
import bodyParser from "body-parser";
import cors from "cors";
import mysql, { Connection, QueryError, RowDataPacket } from "mysql2";

const app = express();
const port = 3001;

app.use(cors());
app.use(bodyParser.json());

const connection: Connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "0000", // 비밀번호 각자 설정한 것으로 수정
  database: "attendance", // DB 이름 각자 설정한 것에 맞춰서 수정
});

connection.connect((err: QueryError | null) => {
  if (err) {
    console.error("Error connecting to the database:", err);
    return;
  }
  console.log("Connected to the MySQL server.");
});

// 반 정보 가져오기
app.get("/api/classes", (req: Request, res: Response) => {
  const sql = "SELECT * FROM class";
  connection.query(sql, (err, results) => {
    if (err) {
      console.error("Error fetching classes:", err);
      res.status(500).send("Error fetching classes: " + err.message);
      return;
    }
    res.status(200).send(results);
  });
});

// 학생 등록
app.post("/api/students", (req: Request, res: Response) => {
  const { studentName, classNum } = req.body;
  if (!studentName || !classNum) {
    res.status(400).send("All fields are required.");
    return;
  }

  const sql = "INSERT INTO students (studentName, classNum) VALUES (?, ?)";
  connection.query(sql, [studentName, classNum], (err, results) => {
    if (err) {
      console.error("Error inserting data:", err);
      res.status(500).send("Error registering user: " + err.message);
      return;
    }
    res.status(200).send("User registered successfully");
  });
});

// 로그인
app.post("/api/login", (req: Request, res: Response) => {
  const { studentName, classNum } = req.body;
  if (!studentName || !classNum) {
    res.status(400).send("All fields are required.");
    return;
  }

  const sql = "SELECT * FROM students WHERE studentName = ? AND classNum = ?";
  connection.query(sql, [studentName, classNum], (err, results) => {
    if (err) {
      console.error("Error executing query:", err);
      res.status(500).send("Error logging in: " + err.message);
      return;
    }
    if ((results as RowDataPacket[]).length > 0) {
      res.status(200).send("Login successful");
    } else {
      res.status(401).send("Invalid credentials");
    }
  });
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
