//package com.youcode.sunquizz;
//
//import com.youcode.sunquizz.Level.Level;
//import com.youcode.sunquizz.Question.Question;
//import com.youcode.sunquizz.Question.QuestionRepository;
//import com.youcode.sunquizz.Question.QuestionService;
//import com.youcode.sunquizz.Subject.Subject;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class QuestionServiceTest {
//
//    @Mock
//    private QuestionRepository questionRepository;
//
//    @InjectMocks
//    private QuestionService questionService;
//
//    @Test
//    public void testGetQuestion_WhenQuestionExists_ShouldReturnQuestion() {
//        // Arrange
//        Question expectedQuestion = new Question();
//        expectedQuestion.setId(1);
//        when(questionRepository.findById(1)).thenReturn(Optional.of(expectedQuestion));
//
//        // Act
//        Question resultQuestion = questionService.getQuestion(1);
//
//        // Assert
//        assertEquals(expectedQuestion, resultQuestion);
//    }
//
//    @Test
//    public void testGetQuestion_WhenQuestionDoesNotExist_ShouldReturnNull() {
//        // Arrange
//        when(questionRepository.findById(1)).thenReturn(Optional.empty());
//
//        // Act
//        Question resultQuestion = questionService.getQuestion(1);
//
//        // Assert
//        assertNull(resultQuestion);
//    }
//
//    @Test
//    public void testGetQuestionByLevel_ShouldReturnListOfQuestions() {
//        // Arrange
//        int levelId = 1;
//        Level level = new Level();
//        level.setId(levelId);
//        Question question1 = new Question();
//        Question question2 = new Question();
//        when(questionRepository.findAllByLevel(level)).thenReturn(Arrays.asList(question1, question2));
//
//        // Act
//        List<Question> resultQuestions = questionService.getQuestionByLevel(levelId);
//
//        // Assert
//        assertEquals(Arrays.asList(question1, question2), resultQuestions);
//    }
//
//    @Test
//    public void testGetQuestionBySubject_ShouldReturnListOfQuestions() {
//        // Arrange
//        int subjectId = 1;
//        Subject subject = new Subject();
//        subject.setId(subjectId);
//        Question question1 = new Question();
//        Question question2 = new Question();
//        when(questionRepository.findAllBySubject(subject)).thenReturn(Arrays.asList(question1, question2));
//
//        // Act
//        List<Question> resultQuestions = questionService.getQuestionBySubject(subjectId);
//
//        // Assert
//        assertEquals(Arrays.asList(question1, question2), resultQuestions);
//    }
//
//    @Test
//    public void testGetQuestions_ShouldReturnListOfQuestions() {
//        // Arrange
//        Question question1 = new Question();
//        Question question2 = new Question();
//        when(questionRepository.findAll()).thenReturn(Arrays.asList(question1, question2));
//
//        // Act
//        List<Question> resultQuestions = questionService.getQuestions();
//
//        // Assert
//        assertEquals(Arrays.asList(question1, question2), resultQuestions);
//    }
//
//    @Test
//    public void testCreateQuestion_ShouldReturnCreatedQuestion() {
//        // Arrange
//        Question inputQuestion = new Question();
//        when(questionRepository.save(inputQuestion)).thenReturn(inputQuestion);
//
//        // Act
//        Question createdQuestion = questionService.createQuestion(inputQuestion);
//
//        // Assert
//        assertEquals(inputQuestion, createdQuestion);
//    }
//
//    @Test
//    public void testUpdateQuestion_WhenQuestionExists_ShouldReturnUpdatedQuestion() {
//        // Arrange
//        Question inputQuestion = new Question();
//        inputQuestion.setId(1);
//        Question existingQuestion = new Question();
//        when(questionRepository.findById(1)).thenReturn(Optional.of(existingQuestion));
//        when(questionRepository.save(inputQuestion)).thenReturn(inputQuestion);
//
//        // Act
//        Question updatedQuestion = questionService.updateQuestion(inputQuestion, 1);
//
//        // Assert
//        assertEquals(inputQuestion, updatedQuestion);
//    }
//
//    @Test
//    public void testUpdateQuestion_WhenQuestionDoesNotExist_ShouldReturnNull() {
//        // Arrange
//        Question inputQuestion = new Question();
//        inputQuestion.setId(1);
//        when(questionRepository.findById(1)).thenReturn(Optional.empty());
//
//        // Act
//        Question updatedQuestion = questionService.updateQuestion(inputQuestion, 1);
//
//        // Assert
//        assertNull(updatedQuestion);
//    }
//
//    @Test
//    public void testDeleteQuestion_WhenQuestionExists_ShouldReturnTrue() {
//        // Arrange
//        Question existingQuestion = new Question();
//        existingQuestion.setId(1);
//        when(questionRepository.findById(1)).thenReturn(Optional.of(existingQuestion));
//
//        // Act
//        boolean result = questionService.deleteQuestion(1)==1;
//
//        // Assert
//        assertTrue(result);
//        verify(questionRepository, times(1)).delete(existingQuestion);
//    }
//
//    @Test
//    public void testDeleteQuestion_WhenQuestionDoesNotExist_ShouldReturnFalse() {
//        // Arrange
//        when(questionRepository.findById(1)).thenReturn(Optional.empty());
//
//        // Act
//        boolean result = questionService.deleteQuestion(1)==1;
//
//        // Assert
//        assertFalse(result);
//        verify(questionRepository, never()).delete(any());
//    }
//}
