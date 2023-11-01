package com.youcode.sunquizz.Level;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Level.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService {
    LevelRepository levelRepository;
    @Autowired
    public LevelService(LevelRepository levelRepository)
    {
        this.levelRepository = levelRepository;
    }
    public Level getLevel(Integer id)
    {
        Optional<Level> level = levelRepository.findById(id);
        if (level.isPresent()) {
            return level.get();
        }
        return null;
    }
    public List<Level> getLevels()
    {
        return levelRepository.findAll();
    }
    public Level createLevel(Level level)
    {
        return levelRepository.save(level);
    }
    public Level updateLevel(Level level,Integer id)
    {
        Optional<Level> existLevel = levelRepository.findById(id);
        if(existLevel.isPresent()) {
            level.setId(existLevel.get().getId());
            return levelRepository.save(level);
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
