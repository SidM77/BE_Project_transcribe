package dev.sid.sidspringbackend.Repository;

import dev.sid.sidspringbackend.Model.Mail;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MailRepository extends MongoRepository<Mail, ObjectId> {

    @Query("{ 'sender_email' : ?0 }")
    Optional<Mail> findBySenderEmail(String senderEmail);

    Optional<Mail> findMailBySenderEmail(String senderEmail);

//    @Query("{}")

}

