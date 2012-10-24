package bond;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHtmlParser extends HtmlParser
{

    public static void main(String args[])
    {
        readFile("web.txt");
    }

    public static String readFile(String filepath)
    {
        File file = null;
        Scanner input = null;
        String strLines = null;
        try
        {
            file = new File(filepath);
            try
            {
                input = new Scanner(file);
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            while (input.hasNextLine())
            {

                strLines = input.nextLine();
                String test = strLines;

                String regex = "src=(?:\"|\')?(?<imgSrc>[^>]*[^/].(?:jpg|png|GIF|gif))(?:\"|\')?";

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(strLines);
                if (matcher.find())
                {
                    System.out.println(matcher.group());
                    String str = matcher.group();

                }

            }
        }
        finally
        {
            if (input != null)
            {
                input.close();
            }
        }
        return strLines;

    }

    @Override
    public void parseHtml(String line)
    {
        String regex = "href=\"(\\w+.htm[l]?)+\">(([\\s?\\S+]+)+)?<";
        Pattern p = Pattern.compile("<row><column>(.*)</column></row>");
        Matcher matcher = p.matcher("<row><column>()</column></row>");
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
        }

    }
}
