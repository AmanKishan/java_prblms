package test;

import com.revolut.seourl.exception.UrlManipulationException;
import com.revolut.seourl.impl.SeoUrl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for Seo Url Manipulation")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SeoUrlTest {

    private SeoUrl seoUrl;

    private static String baseUrl = "http://www.short.com/";

    @BeforeAll
    void setUp() {
        seoUrl = new SeoUrl(baseUrl);
    }

    @Test
    @DisplayName("Test to get Seo Url: Success response")
    void getSeoUrl() throws UrlManipulationException {

        String seoUrlStr = seoUrl.getSeoUrl("MMM-NNN");
        assertEquals(baseUrl+"MMM-NNN", seoUrlStr);
    }

    @Test
    @DisplayName("Test to get Seo Url: when seo keyword length is greater than 20")
    void getSeoUrlG8Than20() throws UrlManipulationException {

        Assertions.assertThrows(UrlManipulationException.class, () ->
                seoUrl.getSeoUrl("MMM-NNN-------------TYUYI"));
    }

    @Test
    @DisplayName("Test to get Seo Url: when seo keyword length null")
    void getSeoUrlNullCheck()  {

        Assertions.assertThrows(Exception.class, () ->
                seoUrl.getSeoUrl(null));
    }
}
