package unit;

import com.dhjacobson.recipebook_api.db.RecipeRepository;
import com.dhjacobson.recipebook_api.resources.RecipeResource;
import com.example.recipebook_commons.models.Recipe;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class RecipeResourceTest {

    private static final RecipeRepository dao = mock(RecipeRepository.class);
    private Recipe recipe;

    public RecipeResourceTest() {
        Recipe recipe = new Recipe();
        recipe.setTitle("Turtle Soup");
    }

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new RecipeResource(dao))
            .build();

    @Before
    public void setup() {
        when(dao.findRecipe(0)).thenReturn(recipe);
        // we have to reset the mock after each test because of the
        // @ClassRule, or use a @Rule as mentioned below.
        reset(dao);
    }

    @Test
    public void testGetRecipe() {
        assertEquals(resources.client()
                .target("/recipes/0")
                .request(MediaType.APPLICATION_JSON)
                .get(Recipe.class),
                recipe
        );

        verify(dao).findRecipe(0);
    }

}
