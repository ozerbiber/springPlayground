package com.ozer.deneme.Controller;

import com.ozer.deneme.Repository.*;
import com.ozer.deneme.model.*;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class DeveloperController {
    @Autowired
    private DeveloperBaseRepository developerBaseRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private AvailabilityRepository availabilityRepository;
    @Autowired
    private ProficiencyRepository proficiencyRepository;
    @Autowired
    private TagRepository tagRepository;
    @GetMapping(path = "/developer-base")
    public Page<DeveloperBase> getAllDeveloperBase(@QuerydslPredicate(root = DeveloperBase.class) Predicate predicate, Pageable pageable){
        return developerBaseRepository.findAll(predicate,pageable);
    }
    public Page<Developer> getAllDeveloper(Pageable pageable){
        return developerRepository.findAll(pageable);
    }
    @PostMapping(path = "/developer")
    public Developer saveDeveloper(@RequestBody Developer developer){
        return developerRepository.save(developer);
    }
    @PostMapping(path = "/developer-base")
    public DeveloperBase saveDeveloperBase(@RequestBody DeveloperBase developerBase){
        return developerBaseRepository.save(developerBase);
    }
    @PostMapping(path = "/tag")
    public Tag saveDeveloper(@RequestBody Tag tag){
        return tagRepository.save(tag);
    }
    @PostMapping(path = "/proficiency")
    public Proficiency saveProficiency(@RequestBody Proficiency proficiency){
        return proficiencyRepository.save(proficiency);
    }
    @PostMapping(path = "/availability")
    public Availability saveDeveloper(@RequestBody Availability availability){
        return availabilityRepository.save(availability);
    }

}
