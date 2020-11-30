package com.vass.talks.graphql.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.vass.talks.graphql.model.CounterEvent;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class Subscription implements GraphQLSubscriptionResolver {

    public Publisher<CounterEvent> getPostLikeCount(Integer duration) {
        Random random = new Random();
        return Flux.interval(Duration.ofSeconds(duration))
                .map(num -> new CounterEvent("post-like-counter",random.nextInt(100000)));
    }

}
