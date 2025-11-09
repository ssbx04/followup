package com.csroot.followup.questionnaire;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaire/api")
public class QuestionnaireController {
    private  final QuestionnaireService questionnaireService;
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }
    @PostMapping
    public ResponseEntity<QuestionnaireDTO> save(@RequestBody QuestionnaireDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionnaireService.save(dto));
    }
    @GetMapping
    public ResponseEntity<List<QuestionnaireDTO>> findAll() {
        return ResponseEntity.ok(questionnaireService.findAll());
    }
}
