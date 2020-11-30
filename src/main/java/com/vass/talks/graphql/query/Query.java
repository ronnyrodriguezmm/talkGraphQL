package com.vass.talks.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vass.talks.graphql.model.Post;
import com.vass.talks.graphql.repo.PostRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private PostRepo postRepo;

    public Query(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        Pageable pageable = PageRequest.of(offset,count);
        return postRepo.findAll(pageable).getContent();
    }
}
