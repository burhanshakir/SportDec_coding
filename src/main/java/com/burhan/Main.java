package com.burhan;

import twitter4j.Status;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String args[]) throws IOException {


        GithubAPIService github = new GithubAPIService();
        GithubModel repos = github.getRepos();

        for(int i = 0; i < 10; i++){

            GithubRepo repo = repos.items.get(i);

            System.out.println("\n");
            System.out.println("Repository:" + repo.full_name);
            System.out.println("Summary:" + repo.description);
            System.out.println("TWEETS:");

            List<Status> tweets =  TwitterAPIService.main(repo.full_name);

            if(tweets.size() > 0){
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            }

            else
                System.out.println("No tweets found for this repo");




        }



    }
}
