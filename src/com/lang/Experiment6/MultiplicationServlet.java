package com.lang.Experiment6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MultiplicationServlet")
public class MultiplicationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET request: show input form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  

        out.println("<html><body>"); 
        out.println("<h2>Enter Number for Multiplication Table</h2>");    
        out.println("<form method='post' action='MultiplicationServlet'>");    
        out.println("Number: <input type='text' name='number'><br><br>"); 
        out.println("<input type='submit' value='Generate'>");    
        out.println("</form>"); 
        out.println("</body></html>"); 
    }  

    // Handle POST request: display multiplication table and square
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  

        String numStr = request.getParameter("number");
        int number = 0;

        // Input validation
        try {
            number = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Please enter a valid number!</p>");
            return;
        }

        out.println("<html><body>");    
        out.println("<h2>Multiplication Table</h2>");    
        out.println("<table border='1' cellpadding='15'> <tr><th>Multiplier</th><th>Result</th></tr>");    

        for (int i = 1; i <= 10; i++) { 
            out.println("<tr><td>" + number +  " x " + i + "</td><td>" + (number*i) + "</td></tr>"); 
        } 
        out.println("</table>"); 

        out.println("<h2>Square of Number</h2>"); 
        out.println("<h3>Square of : " + number + "</h3>");    
        out.println("<p>" + number +  " x " + number + " = " + (number*number) + "</p>"); 
        out.println("</body></html>"); 
    } 
}