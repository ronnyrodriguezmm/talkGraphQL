package com.vass.talks.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.vass.talks.graphql.model.Post;
import com.vass.talks.graphql.repo.PostRepo;

import java.util.Random;

public class Mutation implements GraphQLMutationResolver {
    private PostRepo postRepo;

    public Mutation(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Post writePost(String title, String text, String category) {
        Post post = new Post();
        post.setId(new Random().nextInt()+"");
        post.setText(text);
        post.setTitle(title);
        post.setCategory(category);
        postRepo.save(post);
        return post;
    }
}
