import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class WebScrapper {

    public static void main(String[] args) {
        System.out.println("Hello");

        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        try {

            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setPrintContentOnFailingStatusCode(false);

            HtmlPage page = webClient.getPage("https://foodnetwork.co.uk/italian-family-dinners/");


            String title = page.getTitleText();
            System.out.println("Page Title: " + title);

            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            webClient.close();
            // recipesFile.close();
            System.out.println(page.getPage());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

}
