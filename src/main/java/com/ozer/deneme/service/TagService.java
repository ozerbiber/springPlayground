package com.ozer.deneme.service;

import com.ozer.deneme.Repository.TagRepository;
import com.ozer.deneme.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag saveTag(Tag tag){

       return tagRepository.saveAndFlush(tag);

    }
    public List<Tag> allTag(){
        return  tagRepository.findAll();
    }
}
