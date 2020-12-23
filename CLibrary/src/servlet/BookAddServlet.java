package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BooksDTO;
import model.MasterDAO;

/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = request.getParameter("target");

		//フォワード先を指定（初期値をmaster.jspとする）
		String forwardPath = "/WEB-INF/jsp/master.jsp";

		//分岐する**********************************************************
		switch (target) {
		case "bookadd":
			// データベース処理を行うDAOを生成
			 BooksDTO bookdata = (BooksDTO) request.getSession().getAttribute("result");

			// DAO内に定義されているデータ登録用のメソッドを実行し、その結果を保存
			boolean isInsert = new MasterDAO().insert(bookdata);

			// メソッドの実行結果によって、切り替えるJSPファイル名を決定
			if (isInsert) {
				forwardPath = "/WEB-INF/jsp/addsuccess.jsp";
			} else {
				//エラーメッセージを設定
				setErrMsg(request, response, "登録に失敗しました。内容を確認して下さい。");
			}
			break;
		}
		//**********************************************************
		//フォワードするメソッドを実行
		doForward(request, response, forwardPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//フォワードするメソッドを実行（master.jspへ）
		doForward(request, response, "/WEB-INF/jsp/master.jsp");
	}

	//**********************************************************
	//フォワードを実行するメソッド
	//**********************************************************
	public void doForward(HttpServletRequest request, HttpServletResponse response, String forwardPath)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}
	//**********************************************************
		//エラーメッセージをスコープに保存
		//**********************************************************
		public void setErrMsg(HttpServletRequest request, HttpServletResponse response, String errMsg)
				throws ServletException, IOException {
			//リクエストスコープにエラーメッセージを保存
			request.setAttribute("errMsg", errMsg);

		}

}