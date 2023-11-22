package com.youcode.sunquizz.Level;

import com.youcode.sunquizz.Level.DTOs.LevelReqDTO;
import com.youcode.sunquizz.Level.DTOs.LevelRespDTO;
import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    LevelService levelService;
    @PostMapping
    public ResponseEntity<LevelRespDTO> createLevel(@RequestBody LevelReqDTO level)
    {
        LevelRespDTO level1 = levelService.createLevel(level);
        if(level1 != null)
        {
              return ResponseEntity.ok().body(level1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LevelRespDTO> updateLevel(@PathVariable Integer id, @RequestBody LevelReqDTO level)
    {
        LevelRespDTO level1 = levelService.updateLevel(level,id);
        if(level1 != null)
        {
            return ResponseEntity.ok().body(level1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<Page<LevelRespDTO>> getLevels(Pageable pageable)
    {
        return ResponseEntity.ok().body(levelService.getLevels(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LevelRespDTO> getLevel(@PathVariable Integer id)
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
