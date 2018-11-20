//package integration;
//
//import com.example.recipebook_api.RecipeApplication;
//import com.example.recipebook_api.RecipeConfiguration;
//import com.example.recipebook_api.db.RecipeRepository;
//import com.example.recipebook_api.resources.RecipeResource;
//import com.example.recipebook_commons.api.DataAccessLayer;
//import com.example.recipebook_commons.models.Recipe;
//import com.example.recipebook_commons.utils.SampleDataUtils;
//import io.dropwizard.Application;
//import io.dropwizard.testing.junit.DropwizardAppRule;
//import io.dropwizard.testing.junit.ResourceTestRule;
//import org.junit.Before;
//import org.junit.ClassRule;
//import org.junit.Test;
//
//import javax.ws.rs.core.MediaType;
//
//import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class IntegrationTest {
//
//    private static final RecipeRepository dao = mock(RecipeRepository.class);
//    private Recipe recipe;
//
//
//    @ClassRule
//    public static final DropwizardAppRule<RecipeConfiguration> RULE =
//            new DropwizardAppRule<>(RecipeApplication.class);
//
//    @Before
//    public void setup() {
//    }
//
//    @Test
//    public void testFetchRecipe() {
//        DataAccessLayer dal = new DataAccessLayer();
//        assertEquals(SampleDataUtils.sampleRecipes().get(0).getTitle(), dal.fetchRecipe(0).getTitle());
//    }
//
//    @Test
//    public void testCreateAndFetchRecipe() {
//        String recipeTitle = "Turtle Soup";
//
//        DataAccessLayer dal = new DataAccessLayer();
//
//        int newRecipeId = dal.createRecipe(new Recipe(recipeTitle));
//        assertEquals(recipeTitle, dal.fetchRecipe(newRecipeId).getTitle());
//    }
//
//    @Test
//    public void testCreateFetchUpdateAndFetchRecipe() {
//        String recipeTitle = "Turtle Soup";
//        String recipeDescription = "I love this recipe!";
//        String updatedRecipeTitle = "Better Turtle Soup";
//
//        DataAccessLayer dal = new DataAccessLayer();
//
//        // create the recipe
//        Recipe recipeToCreate = new Recipe(recipeTitle);
//        recipeToCreate.setDescription(recipeDescription);
//        int recipeId = dal.createRecipe(recipeToCreate);
//
//        // fetch the recipe you just created
//        Recipe createdRecipe = dal.fetchRecipe(recipeId);
//
//        // change the name the recipe you just fetched, and update
//        createdRecipe.setTitle(updatedRecipeTitle);
//        dal.updateRecipe(recipeId, createdRecipe);
//
//        // fetch the recipe you just updated
//        Recipe updatedRecipe = dal.fetchRecipe(recipeId);
//
//        // the recipe should have the new name
//        assertEquals(updatedRecipeTitle, updatedRecipe.getTitle());
//
//        // the recipe should still have the original description
//        assertEquals(recipeDescription, updatedRecipe.getDescription());
//
//    }
//}
