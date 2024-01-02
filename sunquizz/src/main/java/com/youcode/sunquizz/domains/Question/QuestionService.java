package com.youcode.sunquizz.domains.Question;

import com.youcode.sunquizz.domains.Level.Level;
import com.youcode.sunquizz.domains.Level.LevelRepository;
import com.youcode.sunquizz.domains.Media.Media;
import com.youcode.sunquizz.domains.Media.MediaRepository;
import com.youcode.sunquizz.domains.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.domains.Question.DTOs.QuestionRespDTO;
import com.youcode.sunquizz.domains.Subject.Subject;
import com.youcode.sunquizz.domains.Subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionService implements QuestionServiceInterface{
    QuestionRepository questionRepository;
    ModelMapper modelMapper;
    LevelRepository levelRepository;
    SubjectRepository subjectRepository;
    MediaRepository mediaRepository;
    Optional<Level> level ;
    Optional<Subject> subject ;
    Optional<Media> media ;

    //get one question
    public QuestionRespDTO getQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
        return modelMapper.map(question.orElse(null),QuestionRespDTO.class);
    }

    // get all question by his level
    public  List<QuestionRespDTO> getQuestionByLevel(Integer id)
    {
        Level level = new Level();
        level.setId(id);
        return questionRepository.findAllByLevel(level).stream().map(question -> modelMapper.map(question,QuestionRespDTO.class)).collect(Collectors.toList());
    }

    // get all question by his subject
    public  List<QuestionRespDTO> getQuestionBySubject(Integer id)
    {
        Subject subject = new Subject();
        subject.setId(id);
        return questionRepository.findAllBySubject(subject).stream().map(question -> modelMapper.map(question,QuestionRespDTO.class)).collect(Collectors.toList());
    }

    // get all question
    public Page<QuestionRespDTO> getQuestions(Pageable pageable)
    {
        Page<Question> entityPage = questionRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, QuestionRespDTO.class));
    }

    //create question
    public QuestionRespDTO createQuestion(QuestionReqDTO question)
    {
        Question questionE = modelMapper.map(question,Question.class);
        level = levelRepository.findById(question.getLevel_id());
        subject = subjectRepository.findById(question.getSubject_id());
        media = mediaRepository.findById(question.getMedia_id());

        // check if the level , subject and media exist
        if(level.isPresent() && subject.isPresent() && media.isPresent()){
            questionE.setLevel(level.get());
            questionE.setSubject(subject.get());
            questionE.setMedia(media.get());
        }

        questionE = questionRepository.save(questionE);
        return modelMapper.map(questionE,QuestionRespDTO.class);
    }

    // update question
    public QuestionRespDTO updateQuestion(QuestionReqDTO question,Integer id)
    {
        Optional<Question> questionE = questionRepository.findById(id);
        return questionE.map(question1 -> {
            question.setId(questionE.get().getId());
            level = levelRepository.findById(question.getLevel_id());
            subject = subjectRepository.findById(question.getSubject_id());
            media = mediaRepository.findById(question.getMedia_id());

            if(level.isPresent() && subject.isPresent() && media.isPresent()) {
                questionE.get().setLevel(level.get());
                questionE.get().setSubject(subject.get());
                questionE.get().setMedia(media.get());
                return modelMapper.map(questionRepository.save(questionE.get()), QuestionRespDTO.class);
            }
            return null;
        }).orElse(null);
    }

    // delete a question
    public Integer deleteQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
        return question.map(question1 -> {
            questionRepository.delete(question.get());
            return 1;
        }).orElse(0);
    }
}
