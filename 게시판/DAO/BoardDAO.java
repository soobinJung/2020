package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Board;
import test.DB;

public class BoardDAO {
	
    Connection CN;
    Statement ST; 
    PreparedStatement PST;
    CallableStatement CST; 
    ResultSet RS; 
    
	public BoardDAO() {
		DB db = new DB();
	}
	
	// 회원 가입
	public void SignUp( String id, String pass ) {
		try{
			Connection con = DB.getConnection();
			//session.setAttribute("id", id);
			String sql = "INSERT INTO LOGIN(ID,PASS) VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}
		catch (SQLException e){
			System.out.println("BoardDAO (SignUp) ERROR  = "+e.toString());
		}
	}
	
	// 게시물 SELECT
	public ArrayList<Board> BoardSelect() {
		ArrayList<Board> list = new ArrayList<Board>();
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT  ID , TITLE, CONTENT, HITS , LIKES,\r\n" + 
					"               TO_CHAR(UPDATE, 'YY/MM/DD') AS UPDATE,\r\n" + 
					"               TO_CHAR(UPTIME ,'HH:MI') AS UPTIME \r\n" + 
					"         FROM BOARD";
			RS = ST.executeQuery(query);
			while (RS.next() == true) {
				Board board = new Board();
				board.setB_ID(RS.getString("id"));
				board.setB_TITLE(RS.getString("title"));
				board.setB_UPDATE(RS.getString("update"));
				board.setB_UPTIME(RS.getString("uptime"));
				board.setContent(RS.getString("content"));
				board.setTitle(RS.getString("title"));
				board.setUpdate(RS.getString("update"));
				board.setHits(RS.getString("hits"));
				board.setLikes(RS.getString("likes"));
				list.add(board);
			}
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (BoardSelect) ERROR = " + e);
		}
		return list;
	}
	
	// 게시물  검색 SELECT
	public ArrayList<Board> BoardsearchSelect( String Query ) {
		ArrayList<Board> list = new ArrayList<Board>();
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT  ID , TITLE, CONTENT, HITS , LIKES,\r\n" + 
					"               TO_CHAR(UPDATE, 'YY/MM/DD') AS UPDATE,\r\n" + 
					"               TO_CHAR(UPTIME ,'HH:MI') AS UPTIME \r\n" + 
					"         FROM BOARD \r\n" + Query;
			RS = ST.executeQuery(query);
			while (RS.next() == true) {
				Board board = new Board();
				board.setB_ID(RS.getString("id"));
				board.setB_TITLE(RS.getString("title"));
				board.setB_UPDATE(RS.getString("update"));
				board.setB_UPTIME(RS.getString("uptime"));
				board.setContent(RS.getString("content"));
				board.setTitle(RS.getString("title"));
				board.setUpdate(RS.getString("update"));
				board.setHits(RS.getString("hits"));
				board.setLikes(RS.getString("likes"));
				list.add(board);
			}
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (BoardsearchSelect) ERROR = " + e);
		}
		return list;
	}
	
	// 게시물 INSERT
	public void BoardInsert( Board board ) {
		try {
			CN = DB.getConnection();
			String query = "INSERT INTO BOARD\r\n" + 
					       "VALUES (  '"+board.getId()+"',"
					      +         "'"+board.getTitle()+"',"
					      +         "'"+board.getContent()+"',"
					      +         "now(),"
					      +         "now(),"
					      +         "0,"
					      +         "0 )";
            PST = CN.prepareStatement(query);
            PST.executeUpdate(); 
		}catch (Exception e) {
			System.out.println("BoardDAO (BoardInsert) " + e);
		}
	}
	
	// 게시물 자세히 SELECT
	public Board BoardDetailSelect( Board board ) {
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT  ID , TITLE, CONTENT, HITS , LIKES,\r\n" + 
					"               TO_CHAR(UPDATE, 'YY/MM/DD') AS UPDATE,\r\n" + 
					"               TO_CHAR(UPTIME ,'HH:MI') AS UPTIME \r\n" + 
					"         FROM  BOARD\r\n" + 
					"        WHERE  ID = '"+board.getB_ID()+"'\r\n" + 
					"          AND  UPDATE = '"+board.getB_UPDATE()+"'\r\n" + 
					"          AND  TO_CHAR(UPTIME,'HH:MI') = '"+board.getB_UPTIME()+"'";
			RS = ST.executeQuery(query);
			RS.next();
			board.setContent(RS.getString("content"));
			board.setTitle(RS.getString("title"));
			board.setUpdate(RS.getString("update") + RS.getString("uptime"));
			board.setHits(RS.getString("hits"));
			board.setLikes(RS.getString("likes"));
			board.setB_ID(RS.getString("id"));
			board.setB_UPDATE(RS.getString("update"));
			board.setB_UPTIME(RS.getString("uptime"));
			board.setB_TITLE(RS.getString("title"));
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (BoardDetailSelect) ERROR = " + e);
		}
		return board;
	}
	
	// 댓글 INSERT
	public void ReplyInsert( Board board ) {
		try {
			CN = DB.getConnection();
			String query =  "INSERT INTO REPLY\r\n"  
					     +  "VALUES (  '"+board.getId()+"',"
		    		     +           "'"+board.getB_ID()+"',"
		    		     +           "'"+board.getB_UPDATE()+"',"
		    		     +           "'"+board.getB_UPTIME()+"',"
					     +           "'"+board.getReply()+"',"
					     +           "now(),"
						 +           "now())";
            PST = CN.prepareStatement(query);
            PST.executeUpdate(); 
		}catch (Exception e) {
			System.out.println("BoardDAO (BoardInsert) " + e);
		}
		return;
	}
	
	// 공감수 증가
	public void BoardUpdateLike( Board board ) {
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT LIKES\r\n" + 
					"         FROM BOARD\r\n" + 
					"        WHERE ID = '"+board.getB_ID()+"'\r\n" + 
					"          AND TO_CHAR(UPDATE, 'YY/MM/DD') ='"+board.getB_UPDATE()+"'\r\n" + 
					"          AND TO_CHAR(UPTIME ,'HH:MI') ='"+board.getB_UPTIME()+"'\r\n";
			RS = ST.executeQuery(query);
			RS.next();
			String count = Integer.toString(Integer.parseInt(RS.getString("LIKES"))+1);
			query = "UPDATE BOARD SET LIKES = '"+count+"' \r\n"+
					" WHERE ID = '"+board.getB_ID()+"'\r\n" + 
					"   AND TO_CHAR(UPDATE, 'YY/MM/DD') ='"+board.getB_UPDATE()+"'\r\n" + 
					"   AND TO_CHAR(UPTIME, 'HH:MI'   ) ='"+board.getB_UPTIME()+"'\r\n";
			PST = CN.prepareStatement(query);
		    PST.executeUpdate();
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (BoardUpdateLike) ERROR = " + e);
		}
		return ;
	}
	
	// 공감수 조회
	public String BoardLike( Board board ) {
		String like = null;
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT LIKES\r\n" + 
					"         FROM BOARD\r\n" + 
					"        WHERE ID = '"+board.getB_ID()+"'\r\n" + 
					"          AND TO_CHAR(UPDATE, 'YY/MM/DD') ='"+board.getB_UPDATE()+"'\r\n" + 
					"          AND TO_CHAR(UPTIME ,'HH:MI') ='"+board.getB_UPTIME()+"'\r\n";
			RS = ST.executeQuery(query);
			RS.next();
			like = RS.getString("LIKES");
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (BoardLike) ERROR = " + e);
		}
		return like;
	}
	
	// 조회수 증가
	public String BoardUpdateHits( Board board ) {
		String count="";
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT HITS\r\n" + 
					"         FROM BOARD\r\n" + 
					"        WHERE ID = '"+board.getB_ID()+"'\r\n" + 
					"          AND TO_CHAR(UPDATE, 'YY/MM/DD') ='"+board.getB_UPDATE()+"'\r\n" + 
					"          AND TO_CHAR(UPTIME ,'HH:MI') ='"+board.getB_UPTIME()+"'\r\n";
			RS = ST.executeQuery(query);
			RS.next();
		    count = Integer.toString(Integer.parseInt(RS.getString("HITS"))+1);
			
			query = "UPDATE BOARD SET HITS = '"+count+"' \r\n"+
					" WHERE ID = '"+board.getB_ID()+"'\r\n" + 
					"   AND TO_CHAR(UPDATE, 'YY/MM/DD') ='"+board.getB_UPDATE()+"'\r\n" + 
					"   AND TO_CHAR(UPTIME ,'HH:MI') ='"+board.getB_UPTIME()+"'\r\n";
			PST = CN.prepareStatement(query);
		    PST.executeUpdate();
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (BoardUpdateHits) ERROR = " + e);
		}
		return count;
	}
	
	// 댓글 수 조회
	public String RepluCount( Board board ) {
		String COUNT = null;
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT COUNT(ID) AS COUNT\r\n" + 
					"         FROM REPLY\r\n" + 
					"        WHERE B_ID = 'customer1'\r\n" + 
					"          AND TO_CHAR(B_UPDATE,'YY/MM/DD') = '"+board.getB_UPDATE()+"'\r\n" + 
					"          AND TO_CHAR(B_UPTIME,'HH:MI')      = '"+board.getB_UPTIME()+"'\r\n";
			System.out.println(query);
			RS = ST.executeQuery(query);
			RS.next();
			COUNT = RS.getString("COUNT");
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (RepluCount) ERROR = " + e);
		}
		return COUNT;
	}
	
	// 댓글 SELECT
	public ArrayList<Board> ReplySelect( Board board1 ) {
		ArrayList<Board> list = new ArrayList<Board>();
		try {
		    CN = DB.getConnection();
			ST = CN.createStatement();
			String query = "SELECT  ID, REPLY,\r\n" + 
					"               TO_CHAR(REPLYDATE ,'YYYY/MM/DD') AS REPLYDATE,\r\n" + 
					"               TO_CHAR(REPLYTIME ,'HH:MI')      AS REPLYTIME \r\n" + 
					"         FROM REPLY\r\n" + 
					"        WHERE B_ID = '"+board1.getB_ID()+"'\r\n" + 
					"          AND TO_CHAR(B_UPDATE,'YY/MM/DD') = '"+board1.getB_UPDATE()+"'\r\n" + 
					"          AND TO_CHAR(B_UPTIME,'HH:MI')    = '"+board1.getB_UPTIME()+"'"; 
			RS = ST.executeQuery(query);
			
			while (RS.next() == true) {
				Board board = new Board();
				board.setReply(RS.getString("REPLY"));
				board.setReplydate(RS.getString("REPLYDATE") +" "+ RS.getString("REPLYTIME"));
				board.setReplyid(RS.getString("ID"));
				list.add(board);
			}
			CN.close();
		} catch (Exception e) {
			System.out.println("BoardDAO (ReplySelect) ERROR = " + e);
		}
		return list;
	}
}
