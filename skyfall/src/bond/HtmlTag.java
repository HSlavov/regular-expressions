package bond;

public class HtmlTag
{
    private String tagName;
    private String value;

    public HtmlTag(String name, String value)
    {
        settagName(name);
        setvalue(value);
    }

    public HtmlTag()
    {
        this(null, null);
    }

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

}
