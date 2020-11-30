package com.vass.talks.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.vass.talks.graphql.model.Author;
import com.vass.talks.graphql.model.Post;
import com.vass.talks.graphql.repo.AuthorRepo;

public class PostResolver implements GraphQLResolver<Post> {
    private final AuthorRepo authorRepo;

    public PostResolver(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author getAuthor(Post post) {
        return authorRepo.findById(post.getAuthorId()).get();
    }
}
