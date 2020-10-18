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


@WebServlet("/boardsearch.do")
public class BoardsearchServlet extends HttpServlet {
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

		String keyword = request.getParameter("keyword");
		String keyfield = request.getParameter("keyfield");
		
		BoardDAO DAO = new BoardDAO();
		ArrayList<Board> list = null;
		
		if (keyfield.equals("제목+내용")) {
			list = DAO.BoardsearchSelect("WHERE TITLE LIKE '%" + keyword +"%' OR CONTENT LIKE '%" + keyword + "%'");
		} else if (keyfield.equals("글제목")) {
			list = DAO.BoardsearchSelect("WHERE TITLE LIKE '%" + keyword + "%'");
		} else if (keyfield.equals("작성자")) {
			list = DAO.BoardsearchSelect("WHERE ID LIKE '%" + keyword +"%'");
		}
		
		// 게시물의 유무 체크
		String cheak = list.isEmpty() ? "X" : "O";
		
		request.setAttribute("cheak", cheak);
		request.setAttribute("list", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("/Board.jsp");
		dis.forward(request, response);
   }

}