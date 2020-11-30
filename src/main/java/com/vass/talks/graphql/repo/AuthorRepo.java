package com.vass.talks.graphql.repo;

import com.vass.talks.graphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,String> {
}
