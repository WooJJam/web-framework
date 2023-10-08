package exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name="newsController", urlPatterns = "/exam/*")
public class NewsController extends HttpServlet {

    private NewsDAO newsDAO;

    public NewsController() {
        newsDAO = new NewsDAO();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doHandle(req,res);
    }

    public void doHandle(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nextPage = "";
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        String method = req.getMethod();
        String action = req.getPathInfo();

        if (action.equals("/list.do")) {
            List<NewsVO> newsList = newsDAO.listNews();
            req.setAttribute("newsList", newsList);
            nextPage = "/list.jsp";
        }
        if (action.equals("/read.do")) {
            int id = Integer.parseInt(req.getParameter("id"));
            newsDAO.updateReadCnt(id);
            NewsBodyVO news = newsDAO.detailNews(id);
            req.setAttribute("news", news);
            nextPage = "/detail.jsp";
        }
        if (action.equals("/update.do") && method.equals("GET")) {
            int id = Integer.parseInt(req.getParameter("id"));
            NewsBodyVO news = newsDAO.detailNews(id);
            req.setAttribute("news", news);
            nextPage = "/update.jsp";
        }
        if (action.equals("/update.do") && method.equals("POST")) {
            int id = Integer.parseInt(req.getParameter("id"));
            NewsBodyVO updateNews = new NewsBodyVO();
            updateNews.setTitle(req.getParameter("title"));
            updateNews.setBody(req.getParameter("body"));
            updateNews.setWriter(req.getParameter("writer"));
            newsDAO.updateNews(id, updateNews);
            nextPage="/exam/list.do";
            res.sendRedirect(nextPage);
            return;
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(nextPage);
        dispatcher.forward(req, res);
    }
}
