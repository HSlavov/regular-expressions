package bond;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHtmlParser extends HtmlParser
{
    private int counter = 0;

    public int getCounter()
    {
        return counter;
    }

    public void setCounter(int counter)
    {
        this.counter = counter;
    }

    public void readFiles(String filePath)
    {
        File file = null;
        BufferedReader buffer = null;
        try
        {
            file = new File(filePath);
            buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String strLines;
            while ((strLines = buffer.readLine()) != null)
            {
                if (isHasH(strLines))
                {
                    htmlParser(strLines);
                    this.counter++;

                }

            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                buffer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static boolean isHasH(String strLines)
    {
        String regex = "src=(?:\"|\')?(?<imgSrc>[^>]*[^/].(?:jpg|png|GIF|gif))(?:|\')?[\\s+\\S+]+?alt=(?:\"|\')?(?<alt>[^/>]*[^/]*)(?:\"|/')";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strLines);
        if (matcher.find())
        {
            return true;

        }
        return false;
    }

    public HtmlTag htmlParser(String strLines) throws IOException
    {
        String regex = "src=(?:\"|\')?(?<imgSrc>[^>]*[^/].(?:jpg|png|GIF|gif))(?:|\')?[\\s+\\S+]+?alt=(?:\"|\')?(?<alt>[^/>]*[^/]*)(?:\"|/')";

        HtmlTag name = null;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strLines);
        if (matcher.find())
        {
            name = new HtmlTag(matcher.group(1), matcher.group(2));
            System.out.println("Name= " + matcher.group(1) + "  " + "Value= " + matcher.group(2));

            FileWriter fw = new FileWriter("EndResult.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Name= " + matcher.group(1) + "  " + "Value= " + matcher.group(2));
            bw.newLine();
            bw.close();

        }
        return name;

    }
}
