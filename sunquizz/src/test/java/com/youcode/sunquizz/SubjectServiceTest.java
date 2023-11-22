//package com.youcode.sunquizz.Subject;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class SubjectServiceTest {
//
//    @Mock
//    private SubjectRepository subjectRepository;
//
//    @InjectMocks
//    private SubjectService subjectService;
//
//    @Test
//    public void testGetSubjectByTitle_WhenSubjectExists_ShouldReturnSubject() {
//        // Arrange
//        String title = "Math";
//        Subject expectedSubject = new Subject();
//        when(subjectRepository.findByTitle(title)).thenReturn(Optional.of(expectedSubject));
//
//        // Act
//        Subject resultSubject = subjectService.getSubjectByTitle(title);
//
//        // Assert
//        assertEquals(expectedSubject, resultSubject);
//    }
//
//    @Test
//    public void testGetSubjectByTitle_WhenSubjectDoesNotExist_ShouldThrowException() {
//        // Arrange
//        String title = "NonexistentSubject";
//        when(subjectRepository.findByTitle(title)).thenReturn(Optional.empty());
//
//        // Act and Assert
//        assertThrows(NoSuchElementException.class, () -> subjectService.getSubjectByTitle(title));
//    }
//
//    @Test
//    public void testGetSubject_WhenSubjectExists_ShouldReturnSubject() {
//        // Arrange
//        int subjectId = 1;
//        Subject expectedSubject = new Subject();
//        expectedSubject.setId(subjectId);
//        when(subjectRepository.findById(subjectId)).thenReturn(Optional.of(expectedSubject));
//
//        // Act
//        Subject resultSubject = subjectService.getSubject(subjectId);
//
//        // Assert
//        assertEquals(expectedSubject, resultSubject);
//    }
//
//    @Test
//    public void testGetSubject_WhenSubjectDoesNotExist_ShouldThrowException() {
//        // Arrange
//        int subjectId = 1;
//        when(subjectRepository.findById(subjectId)).thenReturn(Optional.empty());
//
//        // Act and Assert
//        assertThrows(NoSuchElementException.class, () -> subjectService.getSubject(subjectId));
//    }
//
//    @Test
//    public void testGetSubjects_ShouldReturnListOfSubjects() {
//        // Arrange
//        Subject subject1 = new Subject();
//        Subject subject2 = new Subject();
//        when(subjectRepository.findAll()).thenReturn(Arrays.asList(subject1, subject2));
//
//        // Act
//        List<Subject> resultSubjects = subjectService.getSubjects();
//
//        // Assert
//        assertEquals(Arrays.asList(subject1, subject2), resultSubjects);
//    }
//
//    @Test
//    public void testGetSubSubjects_ShouldReturnListOfSubjects() {
//        // Arrange
//        Subject parentSubject = new Subject();
//        Subject subSubject1 = new Subject();
//        Subject subSubject2 = new Subject();
//        when(subjectRepository.findAllByParentSubject(parentSubject)).thenReturn(Arrays.asList(subSubject1, subSubject2));
//
//        // Act
//        List<Subject> resultSubSubjects = subjectService.getSubSubject(parentSubject);
//
//        // Assert
//        assertEquals(Arrays.asList(subSubject1, subSubject2), resultSubSubjects);
//    }
//
//    @Test
//    public void testCreateSubject_ShouldReturnCreatedSubject() {
//        // Arrange
//        Subject inputSubject = new Subject();
//        when(subjectRepository.save(inputSubject)).thenReturn(inputSubject);
//
//        // Act
//        Subject createdSubject = subjectService.createSubject(inputSubject);
//
//        // Assert
//        assertEquals(inputSubject, createdSubject);
//    }
//
//    @Test
//    public void testUpdateSubject_WhenSubjectExists_ShouldReturnUpdatedSubject() {
//        // Arrange
//        Subject inputSubject = new Subject();
//        inputSubject.setId(1);
//        Subject existingSubject = new Subject();
//        when(subjectRepository.findById(1)).thenReturn(Optional.of(existingSubject));
//        when(subjectRepository.save(inputSubject)).thenReturn(inputSubject);
//
//        // Act
//        Subject updatedSubject = subjectService.updateSubject(inputSubject, 1);
//
//        // Assert
//        assertEquals(inputSubject, updatedSubject);
//    }
//
//    @Test
//    public void testUpdateSubject_WhenSubjectDoesNotExist_ShouldReturnNull() {
//        // Arrange
//        Subject inputSubject = new Subject();
//        inputSubject.setId(1);
//        when(subjectRepository.findById(1)).thenReturn(Optional.empty());
//
//        // Act
//        Subject updatedSubject = subjectService.updateSubject(inputSubject, 1);
//
//        // Assert
//        assertNull(updatedSubject);
//    }
//
//    @Test
//    public void testDeleteSubject_WhenSubjectExists_ShouldReturnTrue() {
//        // Arrange
//        Subject existingSubject = new Subject();
//        existingSubject.setId(1);
//        when(subjectRepository.findById(1)).thenReturn(Optional.of(existingSubject));
//
//        // Act
//        boolean result = subjectService.deleteSubject(1)==1;
//
//        // Assert
//        assertTrue(result);
//        verify(subjectRepository, times(1)).delete(existingSubject);
//    }
//
//    @Test
//    public void testDeleteSubject_WhenSubjectDoesNotExist_ShouldReturnFalse() {
//        // Arrange
//        when(subjectRepository.findById(1)).thenReturn(Optional.empty());
//
//        // Act
//        boolean result = subjectService.deleteSubject(1)==1;
//
//        // Assert
//        assertFalse(result);
//        verify(subjectRepository, never()).delete(any());
//    }
//}