package cs472.mum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String messages = null;
        String name = request.getParameter("name");
        String gender = request.getParameter("sex");
        String category = request.getParameter("category");
        String message = request.getParameter("message");
        messages  = "<p>Your Name: " + name + "</p>";
        messages += "<p> Your Gender: " + gender + "</p>";
        messages += "<p> Your Category: " + category + "</p>";
        messages += "<p> Your Message: " + message + "</p>";
        out.print(generateWelcomePage(messages));
    }

    protected String generateWelcomePage(String messages) {
        return " <html>\n" +
                "<head>\n" +
                "\n" +
                "    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>\n" +
                "    <script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>\n" +
                "    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>\n" +
                "    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>\n" +
                "    <style>\n" +
                "        .jumbotron {\n" +
                "            margin-left: 200px;\n" +
                "            margin-right: 200px;\n" +
                "        }\n" +
                "    </style>\n" +
                "   <script> $docu </script> \n" +
                "    <title>MyFirst Servlet</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<nav class='navbar navbar-expand-lg navbar-dark bg-primary'>\n" +
                "    <a class='navbar-brand' href='#'>CS472-WAP:::Lab11</a>\n" +
                "    <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>\n" +
                "        <span class='navbar-toggler-icon'></span>\n" +
                "    </button>\n" +
                "\n" +
                "    <div class='collapse navbar-collapse' id='navbarSupportedContent'>\n" +
                "        <ul class='navbar-nav mr-auto'>\n" +
                "            <li class='nav-item '>\n" +
                "                <a class='nav-link' href='#'>Home <span class='sr-only'>(current)</span></a>\n" +
                "            </li>\n" +
                "            <li class='nav-item'>\n" +
                "                <a class='nav-link' href='#'>About</a>\n" +
                "            </li>\n" +
                "            <li class='nav-item active'>\n" +
                "                <a class='nav-link' href='contact'>Contact Us</a>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "        <form class='form-inline my-2 my-lg-0'>\n" +
                "            <input class='form-control mr-sm-2' type='search' placeholder='Search' aria-label='Search'>\n" +
                "            <button class='btn btn-outline-success my-2 my-sm-0' type='submit'>Search</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</nav>\n" +
                "<div class='jumbotron'>\n" +
                "    <h1 class='display-4'>Thank You!!!!!</h1>\n" +
                "    <p class='lead'>Here's What You sent Us</p>\n" +
                "                <hr class='my-4'>\n" +
                "    <p>" + messages + "</p>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";
    }
}
