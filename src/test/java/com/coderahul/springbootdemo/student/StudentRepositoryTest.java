package com.coderahul.springbootdemo.student;


import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class StudentRepositoryTest {

//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Test
//    public void StudentRepository_Save_ReturnStudent(){
//        //Arrange
//        Student student = new Student("Akash", "Anand", "akashanand@gmail.com", 30);
//
//        //Act
//        Student savedStudent = studentRepository.save(student);
//
//        //Assert
//        assertNotNull(savedStudent);
//        assertEquals(savedStudent.getFirstName(), "Akash");
//
//    }


}