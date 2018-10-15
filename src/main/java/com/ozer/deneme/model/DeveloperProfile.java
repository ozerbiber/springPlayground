package com.ozer.deneme.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.Set;

public interface DeveloperProfile {
    public Long getId();
    public String getName();
    public Double getRateAvg();
    public LocalDateTime getCreated();
    public LocalDateTime getUpdated();
    public Set<Education> getEducations();
}
