package sait.cprg352;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 742227
 */

public class Calculator extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    String firstStr = request.getParameter("first");
    String secondStr = request.getParameter("second");
    String operation = request.getParameter("operation");
    
    int result=0;
    boolean calcPerformed=false;
    
    if (operation!=null)
    {
        if (firstStr!=null && secondStr!=null && !firstStr.equals("") && !secondStr.equals(""))
        {
            int first = Integer.parseInt(firstStr);
            int second = Integer.parseInt(secondStr);
            
            char operationType = operation.charAt(0);
            
            switch (operationType)
            {
                case '+': result = first + second;
                    break;
                case '-': result = first - second;
                    break;
                case '*': result = first * second;
                    break;
                case '%': result = first % second;
                    break;
            }
            
            calcPerformed = true;
            request.setAttribute("result", result );
            
        }
    }

          
      
        
    
        getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
            // stop other execution of code
        
           
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        

        
    }

}
