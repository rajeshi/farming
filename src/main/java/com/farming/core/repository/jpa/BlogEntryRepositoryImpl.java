package com.farming.core.repository.jpa;

import com.farming.core.models.BlogEntry;
import com.farming.core.repository.BlogEntryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BlogEntryRepositoryImpl implements BlogEntryRepository{

    @PersistenceContext
    private EntityManager em;


    @Override
    public BlogEntry getBlogEntry(Long id) {
        return em.find(BlogEntry.class,id);
    }

    @Override
    public Long createBlogEntry(BlogEntry entry) {
        em.persist(entry);
        return entry.getId();
    }

    @Override
    public void updateBlogEntry(Long id, BlogEntry entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBlogEntry(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
