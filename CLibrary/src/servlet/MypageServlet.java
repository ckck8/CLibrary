package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MypageDAO;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MypageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// DB接続情報の設定
		final String URL = "jdbc:mysql://172.16.71.108:3306/sampledb?serverTimezone=JST";
		final String USER = "CLibary";
		final String PASS = "CLibrary01";

		String forword = "";

		// DB接続処理は例外処理が必須
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			// 接続に成功した場合、success.jspファイルにフォワード
			//			forword = "/WEB-INF/jsp/success.jsp";

			forword = "/WEB-INF/jsp/myRent.jsp";
		} catch (SQLException e) {
			// 接続に失敗した場合、fall.jspファイルにフォワード
			forword = "fail.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forword);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String forword = "";
		int result = 3;
		// URLエンコーディングの文字コードを設定
		request.setCharacterEncoding("utf-8");
		// name="target"のデータを抽出(どこからの通信かをチェックする)
		String target = request.getParameter("target");

		// アクセス元のページによって処理を分岐
		switch (target) {
		case "return": // target=returnの場合
			// 本を返却する自作メソッドを実行
			result = MypageDAO.returnBook();
			if (result == 0) {
				forword = "/WEB-INF/jsp/returnOk.jsp";
			} else {
				forword = "/WEB-INF/jsp/test.jsp";
			}

			break;
		case "rent": // target=cat_keywordの場合
			// 本を借りる自作メソッドを実行
			result = MypageDAO.rentBook();
			if (result == 0) {
				forword = "/WEB-INF/jsp/rentOk.jsp";
			} else if (result == 1) {
				forword = "/WEB-INF/jsp/test2.jsp";
			}
			break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forword);
		dispatcher.forward(request, response);
	}

	//	private void returnBook(HttpServletRequest request, HttpServletResponse response) {
	//
	//	}
	//
	//	private void rentBook(HttpServletRequest request, HttpServletResponse response) {
	//
	//	}

}