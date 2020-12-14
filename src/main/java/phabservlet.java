import java.io.*;
import java.util.stream.Collectors;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns={"/druglist","/drugstock"},loadOnStartup = 1)
public class phabservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("test");

        if(req.getServletPath()=="/druglist") {
            resp.getWriter().write("<b>List of Drugs Database</b>");
        }

        if("/drugstock" == req.getServletPath()) {
            resp.getWriter().write("<b>Drug Stock</b>"); //don't work yet
        }


        resp.getWriter().write(req.getServletPath());

        ///just use /druglist in url http://localhost:8020/druglist



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        resp.setContentType("text/html");

        resp.getWriter().write("Thank you client! "+reqBody);
    }

    //Postgres for heroku -

}
