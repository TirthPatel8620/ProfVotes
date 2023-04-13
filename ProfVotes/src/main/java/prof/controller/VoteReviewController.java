package prof.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prof.dao.VoterDao;
import prof.person.VoteListAttr;

public class VoteReviewController extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse responde) {
		VoterDao voterdao = new VoterDao();
		List<VoteListAttr> voteList=new ArrayList<VoteListAttr>();

		voteList=voterdao.voteReview();
		request.setAttribute("votereviewlist", voteList);
		int listLen=voteList.size();
		int c1=0,c2=0,c3=0,nota=0;
		String winnerCandidate="";
		for (VoteListAttr voteListAttr : voteList) {
			if (voteListAttr.getVote()=="candidate1") {
				c1++;
			}
			else if (voteListAttr.getVote()=="candidate2") {
				c2++;
			}
			else if (voteListAttr.getVote()=="candidate3") {
				c2++;
			}else {
				nota++;
			}
			
		}
		if(c1>c2 && c1>c3)
			winnerCandidate="Candidate 1";
		else if (c2>c3)
			winnerCandidate="Candidate 2";
		else
			winnerCandidate="Candidate 3";
		request.setAttribute("candidate1Vote", c1);
		request.setAttribute("candidate2Vote", c2);
		request.setAttribute("candidate3Vote", c3);
		request.setAttribute("notaVote", nota);
		request.setAttribute("totalLen", listLen);
		request.setAttribute("winnerVote", Math.max(c1,Math.max(c2,c3)));
		request.setAttribute("winnerCandidate", winnerCandidate);

		RequestDispatcher rd = request.getRequestDispatcher("VoteReviewAuthority.jsp");
		try {
			rd.forward(request, responde);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
