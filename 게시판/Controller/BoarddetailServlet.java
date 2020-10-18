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


@WebServlet("/bdetail.do")
public class BoarddetailServlet extends HttpServlet {
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
		
		Board board = new Board();
		BoardDAO DAO = new BoardDAO();

		board.setB_ID(request.getParameter("B_ID"));
		board.setB_TITLE(request.getParameter("B_TITLE"));
		board.setB_UPDATE(request.getParameter("B_UPDATE"));
		board.setB_UPTIME(request.getParameter("B_UPTIME"));

		// �Խù� ����
		board = DAO.BoardDetailSelect(board);
		
		// ��� ����
		ArrayList<Board> replylist = DAO.ReplySelect(board);
		
		// ���� ��
		String like = DAO.BoardLike(board);
		
		// ��� ��
		String replycount = DAO.RepluCount(board);
		
		// ��ȸ�� ����
		String count = DAO.BoardUpdateHits(board);
		
		request.setAttribute("like", like);
		request.setAttribute("count", count);
		request.setAttribute("board", board);
		request.setAttribute("replylist", replylist);
		request.setAttribute("replycount", replycount);
		RequestDispatcher dis = request.getRequestDispatcher("/BoardDetail.jsp");
		dis.forward(request, response);
   }

}