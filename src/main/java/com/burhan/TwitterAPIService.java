package com.burhan;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;


public class TwitterAPIService {

    public static List<Status> main(String searchQuery) {

        List<Status> tweets = new ArrayList();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(Utils.TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(Utils.TWITTER_CONSUMER_SECRET)
                .setOAuthAccessToken(Utils.TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(Utils.TWITTER_ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Query query = new Query(searchQuery);
            query.setCount(10);
            QueryResult result;
            result = twitter.search(query);
            tweets = result.getTweets();


        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }

        return  tweets;
    }


}
