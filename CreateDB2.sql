CREATE TABLE `admins` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ;

CREATE TABLE `assignment_submissions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `assignment_id` int DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (student_id) REFERENCES students(student_id),
  FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id)
);

CREATE TABLE `assignments` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  FOREIGN KEY (course_id) REFERENCES courses(course_id)
) ;

CREATE TABLE `course_attendances` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
) ;

CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ;

CREATE TABLE `courses_students` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
) ;

CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ;

CREATE TABLE `teachers` (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ;
