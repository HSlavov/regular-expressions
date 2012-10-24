package bond;

public class HtmlTag
{
    private String tagName;
    private String value;

    public void settagName(String a)
    {
        if (a != null)
        {
            tagName = a;
        }
    }

    public String gettagName()
    {
        return tagName;
    }

    public void setvalue(String b)
    {
        if (b != null)
        {
            value = b;
        }
    }

    public String getvalue()
    {
        return value;
    }

    public HtmlTag()
    {
        this(null, null);
    }

    public HtmlTag(String a, String b)
    {
        settagName(a);
        setvalue(b);
    }

}
