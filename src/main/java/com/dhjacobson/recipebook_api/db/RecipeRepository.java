package com.dhjacobson.recipebook_api.db;

import com.dhjacobson.recipebook_commons.models.Recipe;

import java.util.List;

public interface RecipeRepository {

    List<Recipe> findAll();

    Recipe findRecipe(int recipeId);

    int insertRecipe(Recipe recipe);

}
