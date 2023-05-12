# ruanxie
![ER3](https://github.com/AwakeningSail/ruanxie/blob/master/ER3.png)


第一阶段目标基于这张ER图，具体的数据有些许改动，数据库的设计是下面的方式,请学生端前端开发的同学在设计团队建立的时候，一起讨论接口问题
```mysql
create schema ruanxie;
use ruanxie;

CREATE TABLE Student (
  StudentID varchar(255) PRIMARY KEY,
  Name varchar(255),
  Password varchar(255),
  TeamID int,
  Telephone varchar(255),
  Email varchar(255)
);

drop Table Team;
CREATE TABLE Team (
  TeamID int PRIMARY KEY,
  TeamSize int,
  isBuild BOOLEAN,
  BuildTime TIME,
  Arrangement varchar(255),
  TeamDocumentID int,
  ReplyScore int,
  notice text
);

CREATE TABLE Teacher (
  TeacherID varchar(255) PRIMARY KEY,
  Name varchar(255),
  Password varchar(255),
  ClassID varchar(255),
  Telephone varchar(255),
  Email varchar(255)
);
drop Table Teamwork;
CREATE TABLE Teamwork (
  TeamID int PRIMARY KEY,
  WorkArrangement text,
  MeetingMinutes int,
  Assignmentresults text,
  Score int
);

CREATE TABLE Class (
  ClassID varchar(255),
  ClassSize int,
  ClassBeginningTime TIME
);

CREATE TABLE TestPaper (
  TeacherID varchar(255),
  TestPaperID int,
  DocumentID int,
  PRIMARY KEY (TeacherID, TestPaperID)
);

CREATE TABLE AnswerPaper (
  StudentID varchar(255),
  TestPaperID int,
  DocumentID int,
  PRIMARY KEY (StudentID, TestPaperID)
);

drop Table Score;
CREATE TABLE Score (
  StudentID varchar(255),
  TestPaperID int,
  TeamID int,
  WorkScore int,
  ReplyScore int,
  ExamScore int,
  IntragroupScore int,
  PRIMARY KEY (StudentID, TestPaperID, TeamID)
);

CREATE TABLE TeamDocument (
  TeamDocumentID int,
  DocumentID int,
  PRIMARY KEY (TeamDocumentID, DocumentID)
);

CREATE TABLE Document (
  DocumentID int PRIMARY KEY,
  address varchar(255)
);

```
	
