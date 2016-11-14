package nutrition.app;

/**
 *
 * @author donovan.beckmann
 */
public class Recommendation {
    private String title;
    private String message;
    private String source;
    
    public Recommendation(String title, String message, String source)
    {
    this.title = title;
    this.message = message;
    this.source = source;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Recommendation{" + "Title=" + title + ", Message=" + message + ", Source=" + source + '}';
    }
    
}
