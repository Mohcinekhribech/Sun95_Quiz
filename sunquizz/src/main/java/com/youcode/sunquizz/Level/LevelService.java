package com.youcode.sunquizz.Level;

import com.youcode.sunquizz.Level.DTOs.LevelReqDTO;
import com.youcode.sunquizz.Level.DTOs.LevelRespDTO;
import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Level.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LevelService {
    LevelRepository levelRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    public LevelService(LevelRepository levelRepository)
    {
        this.levelRepository = levelRepository;
    }
    public LevelRespDTO getLevel(Integer id)
    {
        Optional<Level> level = levelRepository.findById(id);
        return modelMapper.map(level.orElse(null),LevelRespDTO.class);
    }
    public Page<LevelRespDTO> getLevels(Pageable pageable)
    {
        Page<Level> entityPage = levelRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, LevelRespDTO.class));
//        return levelRepository.findAll(pageable).stream().map(level -> modelMapper.map(level,LevelRespDTO.class))   ;
    }
    public LevelRespDTO createLevel(LevelReqDTO level)
    {
        return modelMapper.map(levelRepository.save(modelMapper.map(level,Level.class)),LevelRespDTO.class);
    }
    public LevelRespDTO updateLevel(LevelReqDTO level,Integer id)
    {
        Optional<Level> existLevel = levelRepository.findById(id);
        if(existLevel.isPresent()) {
            level.setId(existLevel.get().getId());
            return modelMapper.map(levelRepository.save(modelMapper.map(level, Level.class)),LevelRespDTO.class);
        }
        return null;
    }
    public Integer deleteLevel(Integer id)
    {
        Optional<Level> level = levelRepository.findById(id);
        if(level.isPresent()) {
            levelRepository.delete(level.get());
            return 1;
        }else return 0;
    }
}
