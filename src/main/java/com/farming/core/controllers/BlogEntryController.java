package com.farming.core.controllers;

import com.farming.core.models.BlogEntry;
import com.farming.core.resources.BlogEntryResource;
import com.farming.core.resources.asm.BlogEntryResourceAsm;
import com.farming.core.services.BlogEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 2/26/2017.
 */
@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {

    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{blogEntryId}")
    public ResponseEntity<BlogEntryResource> get(@PathVariable Long blogEntryId) {
        BlogEntry entry = service.getBlogEntry(blogEntryId);
        if (entry == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            BlogEntryResourceAsm asm = new BlogEntryResourceAsm();
            return new ResponseEntity(asm.toResource(entry), HttpStatus.OK);
        }
    }
}
