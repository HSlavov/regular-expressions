package bond;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileHtmlParserTest
{

    @Test
    public void testReadFile()
    {
        // String name = "C:\\Users\\BitMax\\Downloads\\test.txt";
        // String regex = "images(?:\"|\')?(?<imgSrc>[^>]*[^/].(?:jpg|png|GIF|gif))(?:|\')?";

        FileHtmlParser parser = new FileHtmlParser();
        parser.readFiles("D:\\gitWorcSpace\\regular-expressions\\skyfall\\web.txt");
        assertEquals(7, parser.getCounter());

    }

}
