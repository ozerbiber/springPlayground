package com.ozer.deneme.service;

import com.ozer.deneme.Repository.*;
import com.ozer.deneme.model.*;
import com.ozer.deneme.response.BadRequestException;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashSet;

import java.util.Set;

@Service
@Transactional
public class DeveloperService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private DeveloperBaseRepository developerBaseRepository;
    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private TestModelRepository testModelRepository;
    public Page<DeveloperBase> findAllDeveloperBase(Predicate predicate, Pageable pageable){
       return  developerBaseRepository.findAll(predicate,pageable);
    }
    public DeveloperProfile findDeveloperProfile(Long developerId){
        return  developerRepository.findProjectedById(developerId);
    }
    public Developer saveDeveloper(Developer developer){
        Developer developerPersisted=  developerRepository.saveAndFlush(developer);
        entityManager.refresh(developerPersisted);
        return  developerPersisted;
    }

    public Developer updateDeveloper(Developer developer){
        Developer existing = developerRepository.findById(developer.getId()).orElseThrow(()->new BadRequestException("No developer with id"));
        copyNonNullProperties(developer, existing);
        Developer developerPersisted=  developerRepository.saveAndFlush(existing);
        entityManager.refresh(developerPersisted);
        return  developerPersisted;
    }
    public TestModel saveTestModel(TestModel testModel){
        TestModel testModelPersisted=testModelRepository.saveAndFlush(testModel);
        entityManager.refresh(testModelPersisted);
        return  testModelPersisted;
    }
    public TestModel updateTestModel(TestModel testModel){
        TestModel existing = testModelRepository.findById(testModel.getId()).orElseThrow(()->new BadRequestException("No test model with id"));
        copyNonNullProperties(testModel, existing);
        TestModel testModelPersisted=testModelRepository.saveAndFlush(existing);
        entityManager.refresh(testModelPersisted);
        return  testModelPersisted;
    }
    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
