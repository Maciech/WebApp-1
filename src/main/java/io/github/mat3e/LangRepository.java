package io.github.mat3e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

 class LangRepository {
     private final Logger logger = LoggerFactory.getLogger(LangRepository.class);
    Optional<Lang> findById(Integer id){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        logger.info(""+id);
        var result = session.get(Lang.class, id);

        //logger.info(result1.toString());
        try{
            logger.info(result.getWelcomeMsg());
        } catch (Exception e){
            logger.info("cannot read from db");
        }
        transaction.commit();
        session.close();
        return Optional.ofNullable(result);
    }
}
