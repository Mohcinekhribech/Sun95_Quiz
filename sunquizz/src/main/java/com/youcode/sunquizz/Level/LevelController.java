package com.youcode.sunquizz.Level;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    LevelService levelService;
    @PostMapping
    public Level createLevel(@RequestBody Level level)
    {
        return levelService.createLevel(level);
    }
    @PutMapping("/{id}")
    public Level updateLevel(@PathVariable Integer id, @RequestBody Level level)
    {
        return levelService.updateLevel(level,id);
    }
    @GetMapping
    public List<Level> getLevels(@RequestBody Level level)
    {
        return levelService.getLevels();
    }
    @GetMapping("/{id}")
    public Level getLevel(@PathVariable Integer id)
    {
        return levelService.getLevel(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteLevel(@PathVariable Integer id)
    {
        return levelService.deleteLevel(id);
    }
}
