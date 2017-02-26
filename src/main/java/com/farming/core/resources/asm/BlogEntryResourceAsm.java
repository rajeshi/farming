package com.farming.core.resources.asm;

import com.farming.core.controllers.BlogEntryController;
import com.farming.core.models.BlogEntry;
import com.farming.core.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

    public BlogEntryResourceAsm() {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry entry) {
        BlogEntryResource resource = new BlogEntryResource();
        resource.setTitle(entry.getTitle());
        Link link = linkTo(methodOn(BlogEntryController.class).get(entry.getId())).withSelfRel();
        resource.add(link.withSelfRel());
        return resource;
    }

}
