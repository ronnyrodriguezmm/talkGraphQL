package com.vass.talks.graphql.config;

import com.vass.talks.graphql.model.Author;
import com.vass.talks.graphql.model.Post;
import com.vass.talks.graphql.mutation.Mutation;
import com.vass.talks.graphql.query.Query;
import com.vass.talks.graphql.repo.AuthorRepo;
import com.vass.talks.graphql.repo.PostRepo;
import com.vass.talks.graphql.resolver.AuthorResolver;
import com.vass.talks.graphql.resolver.PostResolver;
import com.vass.talks.graphql.subscription.Subscription;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfig {

    @Bean
    public Object dataTrick(PostRepo postRepo, AuthorRepo authorRepo) {
        Author author = new Author();
        author.setId("1");
        author.setName("Author 1");
        author.setThumbnail("Thumbnail.png");
        authorRepo.save(author);
        authorRepo.flush();
        Post post = new Post();
        post.setId("1");
        post.setAuthorId("1");
        post.setCategory("Category-0");
        post.setTitle("Title 0");
        post.setText("Text for every one");
        postRepo.save(post);
        return null;
    }

    @Bean
    public Query query(PostRepo postRepo) {
        return new Query(postRepo);
    }

    @Bean
    public AuthorResolver authorResolver(PostRepo postRepo) {
        return new AuthorResolver(postRepo);
    }
    @Bean
    public PostResolver postResolver(AuthorRepo authorRepo) {
        return new PostResolver(authorRepo);
    }
    @Bean
    public Mutation mutation(PostRepo postRepo) {
        return new Mutation(postRepo);
    }
    @Bean
    public Subscription subscription() {
        return new Subscription();
    }
}
