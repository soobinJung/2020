package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;


@WebServlet("/save.do")
public class SaveServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request, response);
   }
   protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String id   = (String)request.getParameter("id");
		String pass = (String)request.getParameter("pass");
		
		BoardDAO DAO = new BoardDAO();
		
		// 회원정보 저장
		DAO.SignUp( id, pass );
		
		RequestDispatcher dis = request.getRequestDispatcher("/Index.jsp");
		dis.forward(request, response);
   }

}