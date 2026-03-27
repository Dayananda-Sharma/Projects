package com.xworkz.pcfile.repo;

import com.xworkz.pcfile.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class FileRepoImpl implements FileRepo{
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean uploadFileRepo(FileEntity fileEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(fileEntity);
            transaction.commit();
            return true;

        }catch (Exception m){
            m.printStackTrace();

            return false;
        }
        finally {
            entityManager.close();
        }
    }
}
