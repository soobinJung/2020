package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DTO.Board;


@WebServlet("/board.do")
public class BoardServlet extends HttpServlet {
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

		BoardDAO DAO = new BoardDAO();
		ArrayList<Board> list = DAO.BoardSelect();
		
		// �Խù��� ���� üũ
		String cheak = list.isEmpty() ? "X" : "O";
		
		request.setAttribute("cheak", cheak);
		request.setAttribute("list", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("/Board.jsp");
		dis.forward(request, response);
   }

}