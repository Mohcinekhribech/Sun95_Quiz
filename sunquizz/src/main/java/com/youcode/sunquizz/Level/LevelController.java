package com.youcode.sunquizz.Level;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    LevelService levelService;
    @PostMapping
    public ResponseEntity<Level> createLevel(@RequestBody Level level)
    {
        Level level1 = levelService.createLevel(level);
        if(level1 != null)
        {
              return ResponseEntity.ok().body(level1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Level> updateLevel(@PathVariable Integer id, @RequestBody Level level)
    {
        Level level1 = levelService.updateLevel(level,id);
        if(level1 != null)
        {
            return ResponseEntity.ok().body(level1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<Level>> getLevels(@RequestBody Level level)
    {
        return ResponseEntity.ok().body(levelService.getLevels());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Level> getLevel(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(levelService.getLevel(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteLevel(@PathVariable Integer id)
    {
        Integer deleted = levelService.deleteLevel(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("level deleted");
        }
        return ResponseEntity.badRequest().body("level not deleted");
    }
}
