package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Level.LevelRepository;
import com.youcode.sunquizz.Media.Media;
import com.youcode.sunquizz.Media.MediaRepository;
import com.youcode.sunquizz.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.Question.DTOs.QuestionRespDTO;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Question.QuestionRepository;
import com.youcode.sunquizz.Subject.Subject;
import com.youcode.sunquizz.Subject.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService implements QuestionServiceInterface{
    QuestionRepository questionRepository;
    @Autowired
    ModelMapper modelMapper;
    LevelRepository levelRepository;
    SubjectRepository subjectRepository;
    MediaRepository mediaRepository;
    Optional<Level> level ;
    Optional<Subject> subject ;
    Optional<Media> media ;
    @Autowired
    public QuestionService(QuestionRepository questionRepository)
    {
        this.questionRepository = questionRepository;
    }

    public QuestionRespDTO getQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
        return modelMapper.map(question.orElse(null),QuestionRespDTO.class);
    }
    public  List<QuestionRespDTO> getQuestionByLevel(Integer id)
    {
        Level level = new Level();
        level.setId(id);
        return questionRepository.findAllByLevel(level).stream().map(question -> modelMapper.map(question,QuestionRespDTO.class)).collect(Collectors.toList());
    }
    public  List<QuestionRespDTO> getQuestionBySubject(Integer id)
    {
        Subject subject = new Subject();
        subject.setId(id);
        return questionRepository.findAllBySubject(subject).stream().map(question -> modelMapper.map(question,QuestionRespDTO.class)).collect(Collectors.toList());
    }
    public List<QuestionRespDTO> getQuestions()
    {
        return questionRepository.findAll().stream().map(question -> modelMapper.map(question,QuestionRespDTO.class)).collect(Collectors.toList());
    }
    public QuestionRespDTO createQuestion(QuestionReqDTO question)
    {
        Question questionE = modelMapper.map(question,Question.class);
        level = levelRepository.findById(question.getLevel_id());
        subject = subjectRepository.findById(question.getSubject_id());
        media = mediaRepository.findById(question.getMedia_id());

        if(level.isPresent() && subject.isPresent() && media.isPresent()){
            questionE.setLevel(level.get());
            questionE.setSubject(subject.get());
            questionE.setMedia(media.get());
        }

        questionE = questionRepository.save(questionE);
        return modelMapper.map(questionE,QuestionRespDTO.class);
    }
    public QuestionRespDTO updateQuestion(QuestionReqDTO question,Integer id)
    {
        Optional<Question> questionE = questionRepository.findById(id);

        if(questionE.isPresent()) {
            question.setId(questionE.get().getId());
            level = levelRepository.findById(question.getLevel_id());
            subject = subjectRepository.findById(question.getSubject_id());
            media = mediaRepository.findById(question.getMedia_id());

            if(level.isPresent() && subject.isPresent() && media.isPresent()){
                questionE.get().setLevel(level.get());
                questionE.get().setSubject(subject.get());
                questionE.get().setMedia(media.get());
            }

            return modelMapper.map(questionRepository.save(questionE.get()),QuestionRespDTO.class);
        }

        return null;
    }
    public Integer deleteQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            questionRepository.delete(question.get());
            return 1;
        }else return 0;
    }
}
