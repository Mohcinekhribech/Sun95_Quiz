//package com.youcode.sunquizz;
//
//import com.youcode.sunquizz.Answer.Answer;
//import com.youcode.sunquizz.Answer.AnswerRepository;
//import com.youcode.sunquizz.Answer.AnswerService;
//import com.youcode.sunquizz.Answer.DTOs.AnswerReqDTO;
//import com.youcode.sunquizz.Answer.DTOs.AnswerRespDTO;
//import org.junit.jupiter.api.Test;
//import org.modelmapper.ModelMapper;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class AnswerServiceTest {
//
//    @Mock
//    private AnswerRepository answerRepository;
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private AnswerService answerService;
//
//    @Test
//    public void testGetAnswer() {
//        Answer answer = new Answer();
//        answer.setId(1);
//        answer.setText("Some value");
//
//        AnswerRespDTO expectedResponse = new AnswerRespDTO();
//        expectedResponse.setId(answer.getId());
//        expectedResponse.setText(answer.getText());
//
//        when(answerRepository.findById(1)).thenReturn(Optional.of(answer));
//
//        AnswerRespDTO actualResponse = answerService.getAnswer(1);
//
//        assertEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void testGetAnswers() {
//        Answer answer1 = new Answer();
//        answer1.setId(1);
//        answer1.setText("Some value 1");
//
//        Answer answer2 = new Answer();
//        answer2.setId(2);
//        answer2.setText("Some value 2");
//
//        List<Answer> answers = Arrays.asList(answer1, answer2);
//
//        AnswerRespDTO expectedResponse1 = new AnswerRespDTO();
//        expectedResponse1.setId(answer1.getId());
//        expectedResponse1.setText(answer1.getText());
//
//        AnswerRespDTO expectedResponse2 = new AnswerRespDTO();
//        expectedResponse2.setId(answer2.getId());
//        expectedResponse2.setText(answer2.getText());
//
//        when(answerRepository.findAll()).thenReturn(answers);
//
//        List<AnswerRespDTO> actualResponses = answerService.getAnswers();
//
//        assertEquals(2, actualResponses.size());
//        assertEquals(expectedResponse1, actualResponses.get(0));
//        assertEquals(expectedResponse2, actualResponses.get(1));
//    }
//
//
//    @Test
//    public void testCreateAnswer() {
//        AnswerReqDTO requestDTO = new AnswerReqDTO();
//        requestDTO.setText("Some value");
//
//        Answer answer = new Answer();
//        answer.setId(1);
//        answer.setText("Some value");
//
//        AnswerRespDTO expectedResponse = new AnswerRespDTO();
//        expectedResponse.setId(answer.getId());
//        expectedResponse.setText(answer.getText());
//
//        when(answerRepository.save(answer)).thenReturn(answer);
//
//        when(modelMapper.map(requestDTO, Answer.class)).thenReturn(answer);
//        when(modelMapper.map(answer, AnswerRespDTO.class)).thenReturn(expectedResponse);
//
//        AnswerRespDTO actualResponse = answerService.createAnswer(requestDTO);
//
//        assertEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void testUpdateAnswer() {
//        AnswerReqDTO requestDTO = new AnswerReqDTO();
//        requestDTO.setText("Updated value");
//
//        Answer existingAnswer = new Answer();
//        existingAnswer.setId(1);
//        existingAnswer.setText("Original value");
//
//        AnswerRespDTO expectedResponse = new AnswerRespDTO();
//        expectedResponse.setId(existingAnswer.getId());
//        expectedResponse.setText(requestDTO.getText());
//
//        when(answerRepository.findById(1)).thenReturn(Optional.of(existingAnswer));
//        when(answerRepository.save(any(Answer.class))).thenReturn(existingAnswer);
//
//        when(modelMapper.map(requestDTO, Answer.class)).thenReturn(existingAnswer);
//        when(modelMapper.map(existingAnswer, AnswerRespDTO.class)).thenReturn(expectedResponse);
//
//        AnswerRespDTO actualResponse = answerService.updateAnswer(requestDTO, 1);
//
//        assertEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void testDeleteAnswer() {
//        Answer existingAnswer = new Answer();
//        existingAnswer.setId(1);
//
//        when(answerRepository.findById(1)).thenReturn(Optional.of(existingAnswer));
//
//        Integer result = answerService.deleteAnswer(1);
//
//        assertEquals(1, result);
//    }
//}
