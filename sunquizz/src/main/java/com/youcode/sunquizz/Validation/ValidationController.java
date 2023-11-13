package com.youcode.sunquizz.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/validation")
public class ValidationController {
    @Autowired
    ValidationService validationService;
    @PostMapping
    public ResponseEntity<Validation> createValidation(@RequestBody Validation validation)
    {
        Validation validation1 = validationService.createValidation(validation);
        if(validation1 != null)
        {
            return ResponseEntity.ok().body(validation1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/question/{id}")
    public ResponseEntity<List<Validation>> getAllByQuestion(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(validationService.getAnswersByQuestion(id));
    }

    @GetMapping
    public ResponseEntity<List<Validation>> getValidations(@RequestBody Validation validation)
    {
        return ResponseEntity.ok().body(validationService.getValidations());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Validation> getValidation(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(validationService.getValidation(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteValidation(@PathVariable Integer id)
    {
        Integer deleted = validationService.deleteValidation(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("Answer is removed from question");
        }
        return ResponseEntity.badRequest().body("Answer is not removed from question");

    }
}
