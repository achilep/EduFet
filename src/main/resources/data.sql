INSERT INTO student_tbl(regno, address, city, class, dob, dor, fname, mname, name, phone, pin, rollno)
	VALUES (1, 'bomaka', 'buea', '2', '2004-05-15', '2020-10-04', 'Hannah', 'Kelly', 'Ntem', '68459413', '6482', 2);
INSERT INTO student_tbl(regno, address, city, class, dob, dor, fname, mname, name, phone, pin, rollno)
	VALUES (2, 'bomaka', 'buea', '3', '2006-06-10', '2020-10-04', 'Jack', 'Collin', 'Song', '68486416', '8945', 3);
INSERT INTO staff_tbl(
	empno, address, basic_pay, city, dept, dob, doj, email, empname, mobile, m_status, nature_of_job, phone, pin, sex, state)
	VALUES (1, 'malingo', 14000, 'buea', 'physics', '1989-05-09',  '2006-09-09', 'mark@mail', 'mark', '6547921', 'Y', 'part time', '6879542', '1354', 'M', 'active');
INSERT INTO staff_tbl(
	empno, address, basic_pay, city, dept, dob, doj, email, empname, mobile, m_status, nature_of_job, phone, pin, sex, state)
	VALUES (2, 'soppo', 12600, 'buea', 'chemistry', '1989-05-09',  '2009-10-10', 'john@mail', 'john', '6421868', 'N', 'permanent', '6482135', '1234', 'T', 'on-leave');
INSERT INTO user_tbl(user_id, password, username)
	VALUES (1, 'password', 'admin');
