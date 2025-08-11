package com.projectmania.journalApp.cache;

import com.projectmania.journalApp.entity.ConfigJournalAppEntity;
import com.projectmania.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> app_cache;

    @PostConstruct
    public void init(){
        app_cache = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for (ConfigJournalAppEntity configJournalAppEntity : all) {
            app_cache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }

}
