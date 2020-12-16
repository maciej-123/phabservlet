import java.io.*;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.stream.Collectors;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns={"/druglist","/drugstock"},loadOnStartup = 1)
public class phabservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("test");

        String ending = req.getServletPath();
        if(ending.equals("/druglist")) {
            resp.getWriter().write("<b>List of Drugs Database</b>");


        //ResultSet result = statement.executeQuery(sql);

        FileReader fr = new FileReader("postgres_public_test_database.sql") ;


        //     https://www.journaldev.com/875/java-read-file-to-string#:~:text=
        //     Java%20read%20file%20to%20String%20using%20BufferedReader,-We%20
        //     can%20use&text=BufferedReader%20reader%20%3D%20new%20BufferedReader(new,readLine())%20!%3D


        BufferedReader reader = new BufferedReader(fr);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();
        String content = stringBuilder.toString();

        resp.getWriter().write(content);


        }

        if(ending.equals("/drugstock")) {
            resp.getWriter().write("<b>Drug Stock</b>");
        }



        ///just use /druglist in url http://localhost:8020/druglist

        //export sql file to heroku

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        resp.setContentType("text/html");

        resp.getWriter().write("Thank you client! "+reqBody);
    }


}
