package com.dhjacobson.recipebook_api.db;

import com.dhjacobson.recipebook_commons.models.Recipe;
import com.dhjacobson.recipebook_commons.utils.SampleDataUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DummyRecipeRepository implements RecipeRepository {

    private static final String DATA_SOURCE = "dummy_data.json";

    private List<Recipe> recipes;

    public DummyRecipeRepository() {
        if (false) {
            try {
                initDataFromConfig();
            } catch (IOException e) {
                throw new RuntimeException(
                        DATA_SOURCE + " missing or is unreadable", e);
            }
        } else {
            initDataFromUtils();
        }
    }

    private void initDataFromConfig() throws IOException {
        URL url = Resources.getResource(DATA_SOURCE);
        String json = Resources.toString(url, Charsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper
                .getTypeFactory()
                .constructCollectionType(List.class, Recipe.class);
        recipes = mapper.readValue(json, type);
    }

    private void initDataFromUtils() {
        recipes = SampleDataUtils.sampleRecipes();
    }

    @Override
    public List<Recipe> findAll() {
        return recipes;
    }

    @Override
    public Recipe findRecipe(int recipeId) {
        return recipes.get(recipeId);
    }

    @Override
    public int insertRecipe(Recipe recipe) {
        recipes.add(recipe);
        return recipes.size() - 1;
    }


}
