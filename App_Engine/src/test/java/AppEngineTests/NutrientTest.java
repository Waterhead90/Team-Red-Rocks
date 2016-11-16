package AppEngineTests;
import com.Engine.Nutrient;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ryan on 11/14/16.
 * //Test2
 */
public class NutrientTest {
    @org.junit.Before
    public void setUp()  {

    }

    @org.junit.After
    public void tearDown()  {

    }

    @org.junit.Test
    public void testToString()
    {

        Nutrient test = new Nutrient("Protein", "grams");
        String expected = "nutrient{" + "name =" + "Protein" + ", unit =" + "grams" + "}";
        String actual = test.toString();

        assertEquals(expected, actual);
    }

}