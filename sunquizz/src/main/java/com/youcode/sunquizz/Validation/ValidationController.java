package com.youcode.sunquizz.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/validation")
public class ValidationController {
    @Autowired
    ValidationService validationService;
    @PostMapping
    public Validation createValidation(@RequestBody Validation validation)
    {
        return validationService.createValidation(validation);
    }
    @GetMapping("/question/{id}")
    public List<Validation> getAllByQuestion(@PathVariable Integer id)
    {
        return validationService.getAnswersByQuestion(id);
    }

    @GetMapping
    public List<Validation> getValidations(@RequestBody Validation validation)
    {
        return validationService.getValidations();
    }
    @GetMapping("/{id}")
    public Validation getValidation(@PathVariable Integer id)
    {
        return validationService.getValidation(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteValidation(@PathVariable Integer id)
    {
        return validationService.deleteValidation(id);
    }
}
