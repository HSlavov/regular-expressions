package bond;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REtest
{
    public static void main(String args[])
    {
        String test = "<img src=images/dukesign.GIF width=130 height=104 align=right border=0 alt=Duke holding a sign /></h1><p><img src=images/shoeline2.GIF alt=path of footprints /> <img src=images/shoeline2.GIF alt=path of footprints /></p>";

        // String regex = "href=\"(\\w +.htm[l])+\">(([\\s?\\S+]+)+)?<";
        String regex = "src=(?:\"|\')?(?<imgSrc>[^>]*[^/].(?:jpg|png|GIF|gif))(?:\"|\')?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(test);
        if (matcher.find())
        {
            System.out.println(matcher.group());
            String str = matcher.group();

        }
        else
        {
            System.out.println("null");

        }
    }
}
