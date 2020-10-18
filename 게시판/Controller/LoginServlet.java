package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
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
		HttpSession session = request.getSession();

		String id   = (String)request.getParameter("id");
		String pass = (String)request.getParameter("pass");
		String url = "";
		Statement stmt = null;
		ResultSet rs = null;
		try{
			DB db = new DB();
			Connection con = DB.getConnection();
			stmt = con.createStatement();
			String query="select count(*) as count from login where id like '"+id+"' and pass like '"+pass+"'";
			rs =  stmt.executeQuery(query);
			rs.next();
			int count = rs.getInt("count");
			// 존재하는 회원인지 체크
			if( count > 0 ){
				session.setAttribute("id", id);
				url = "/board.do";
			}else{
			     PrintWriter writer = response.getWriter(); 
			     writer.println("<script>alert('입력하신 정보가 틀렸습니다'); location.href='/Index.jsp';</script>");
			     writer.close();
			}
			con.close();
		}
		catch ( Exception e){
			out.println("login.do ERROR = "+ e );
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
   }

}