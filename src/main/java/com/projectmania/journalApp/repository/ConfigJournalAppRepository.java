package com.projectmania.journalApp.repository;

import com.projectmania.journalApp.entity.ConfigJournalAppEntity;
import com.projectmania.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
