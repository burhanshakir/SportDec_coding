package com.burhan;

import com.google.gson.Gson;
import org.restlet.resource.ClientResource;

import java.io.IOException;

public class GithubAPIService {

    private  String query;

    public GithubModel getRepos() throws IOException{

        ClientResource resource = new ClientResource("https://api.github.com/search/repositories?q=Football&sort=stars&order=desc&count=10");
        String response = resource.get().getText();

        Gson gson = new Gson();
        GithubModel model = gson.fromJson(response, GithubModel.class);

        return model;
    }

}
