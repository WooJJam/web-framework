package ex01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "webServlet", value = "/member/*")
public class NewsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    public NewsController() {
        memberDAO = new MemberDAO();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doHandle(req,res);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nextPage = null;
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        String action = req.getPathInfo();
        System.out.println("action = " + action);

        if(action ==null||action.equals("/listMember.do")) {
            List<MemberVO> memberList = memberDAO.listMember();
            req.setAttribute("memberList",memberList);
            nextPage="/listMember.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(nextPage);
        dispatcher.forward(req,res);
    }

}
