package com.vass.talks.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.vass.talks.graphql.model.Author;
import com.vass.talks.graphql.model.Post;
import com.vass.talks.graphql.repo.PostRepo;

import java.util.List;

public class AuthorResolver implements GraphQLResolver<Author> {

    private PostRepo postRepo;

    public AuthorResolver(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getPosts(Author author) {

        return postRepo.findByAuthorId(author.getId());
    }
}
