package com.farming.core.repository.tests;

import com.farming.core.models.BlogEntry;
import com.farming.core.repository.BlogEntryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class BlogEntryRepositoryTests {

    @Autowired
    private BlogEntryRepository repo;
    private BlogEntry entry;

    @Before
    @Transactional
    @Rollback(false)
    public void setup(){
        entry = new BlogEntry();
        entry.setTitle("This is test entry");
        repo.createBlogEntry(entry);
    }

    @Test
    @Transactional
    public void testRepository() {
        assertNotNull(repo.getBlogEntry(entry.getId()));
    }
}
