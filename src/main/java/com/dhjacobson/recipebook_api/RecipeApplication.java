package com.dhjacobson.recipebook_api;

import com.dhjacobson.recipebook_api.db.DummyRecipeRepository;
import com.dhjacobson.recipebook_api.db.RecipeRepository;
import com.dhjacobson.recipebook_api.resources.RecipeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RecipeApplication extends Application<RecipeConfiguration> {
    public static void main(String[] args) throws Exception {
        new RecipeApplication().run(args);
    }

    @Override
    public String getName() {
        return "recipes";
    }

    @Override
    public void initialize(Bootstrap<RecipeConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(RecipeConfiguration configuration, Environment environment) {
        // Todo: set up health check

        // get dummy data repository
        RecipeRepository repository = new DummyRecipeRepository();

        // set up primary resource
        final RecipeResource resource = new RecipeResource(repository);
        environment.jersey().register(resource);
    }
}
