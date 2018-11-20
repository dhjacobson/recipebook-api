package com.dhjacobson.recipebook_api.resources;

import com.codahale.metrics.annotation.Timed;
import com.dhjacobson.recipebook_api.db.RecipeRepository;
import com.dhjacobson.recipebook_commons.models.Recipe;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/recipes")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {
    private final RecipeRepository repository;

    public RecipeResource(RecipeRepository repository) {
        this.repository = repository;
    }

    @GET
    @Timed
    @Path("/{recipe_id}")
    public Recipe getRecipe(@PathParam("recipe_id") int recipeId) {
        return repository.findRecipe(recipeId);
    }


    @GET
    @Timed
    @Path("/all")
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    @POST
    @Timed
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public int createRecipe(Recipe newRecipe) {
        return this.repository.insertRecipe(newRecipe);
    }

    @PUT
    @Timed
    @Path("/{recipe_id}/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public int updateRecipe (@PathParam("recipe_id") int recipeId, Recipe newRecipe) {
        this.repository.findAll().set(recipeId, newRecipe);
        return recipeId;
    }
}
