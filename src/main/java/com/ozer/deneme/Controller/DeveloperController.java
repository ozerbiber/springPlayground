package com.ozer.deneme.Controller;

import com.ozer.deneme.Repository.*;
import com.ozer.deneme.model.*;
import com.ozer.deneme.service.DeveloperService;
import com.ozer.deneme.service.TagService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private TagService tagService;


    @GetMapping(path = "/developer-base")
    public Page<DeveloperBase> getAllDeveloperBase(@QuerydslPredicate(root = DeveloperBase.class) Predicate predicate, Pageable pageable){
        return developerService.findAllDeveloperBase(predicate,pageable);
    }
    @GetMapping(path = "/developer/{developerId}")
    public DeveloperProfile getDeveloperProfile(@Valid @PathVariable Long developerId){
        return developerService.findDeveloperProfile(developerId);
    }
    @PostMapping(path = "/developer")
    public Developer saveDeveloper(@RequestBody Developer developer){
        return developerService.saveDeveloper(developer);
    }
    @PutMapping(path = "/developer")
    public Developer updateDeveloper(@RequestBody Developer developer){
        return developerService.updateDeveloper(developer);
    }
    @GetMapping(path = "/tag")
    public List<Tag> getAllTag(){
        return tagService.allTag();
    }
    @PostMapping(path = "/tag")
    public Tag saveDeveloper(@RequestBody Tag tag){
        return tagService.saveTag(tag);
    }
    @PostMapping(path = "/test-model")
    public TestModel saveTestModel(@RequestBody TestModel testModel){
        return developerService.saveTestModel(testModel);
    }
    @PutMapping(path = "/test-model")
    public TestModel updateTestModel(@RequestBody TestModel testModel){
        return developerService.updateTestModel(testModel);
    }


}
