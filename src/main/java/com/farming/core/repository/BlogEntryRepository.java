package com.farming.core.repository;

import com.farming.core.models.BlogEntry;

public interface BlogEntryRepository {

    public BlogEntry getBlogEntry(Long id);

    public Long createBlogEntry(BlogEntry entry);

    public void updateBlogEntry(Long id, BlogEntry entry);

    public void deleteBlogEntry(Long id);
}
