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
import oracle.net.aso.b;


@WebServlet("/boardlike.do")
public class BoardLikeServlet extends HttpServlet {
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
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		// ¥Ò±€ ¿˙¿Â
		BoardDAO DAO = new BoardDAO();
		Board board = new Board();
		board.setId(id);
		board.setReply(request.getParameter("reply"));
		
		board.setB_ID(request.getParameter("B_ID"));
		board.setB_UPDATE(request.getParameter("B_UPDATE"));
		board.setB_UPTIME(request.getParameter("B_UPTIME"));
		
		DAO.BoardUpdateLike(board);
		
		request.setAttribute("board", board);
		RequestDispatcher dis = request.getRequestDispatcher("/bdetail.do");
		dis.forward(request, response);
   }

}