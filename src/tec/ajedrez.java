package tec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class ajedrez
 */
@WebServlet("/ajedrez")
public class ajedrez extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajedrez() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<table width='800' height='600px' style='border:1px solid #757575;' cellspacing='2' cellpadding='2' bgcolor='#ffffff'>");
		out.println("<tr align='center'>");
		out.println("<td><font color='#787878'><img src='torreNegro.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='caballoNegro.png'></td>");
		out.println("<td><font color='#787878'><img src='alfilNegro.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='reyNegro.png'></td>");
		out.println("<td><font color='#787878'><img src='reinaNegro.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='alfilNegro.png'></td>");
		out.println("<td><font color='#787878'><img src='caballoNegro.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='torreNegro.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("<td><font color='#787878'><img src='peonNegro.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("<td><font color='787878'><img src='peonNegro.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("<td><font color='#787878'><img src='peonNegro.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("<td><font color='#787878'><img src='peonNegro.png'></font></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("<td><font color='#787878'>17</font></td>");
		out.println("<td bgcolor='#787878'>18</td>");
		out.println("<td><font color='#787878'>19</font></td>");
		out.println("<td bgcolor='#787878'>20</td>");
		out.println("<td><font color='#787878'>21</font></td>");
		out.println("<td bgcolor='#787878'>22</td>");
		out.println("<td><font color='#787878'>23</font></td>");
		out.println("<td bgcolor='#787878'>24</td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("<td bgcolor='#787878'>25</td>");
		out.println("<td><font color='#787878'>26</font></td>");
		out.println("<td bgcolor='#787878'>27</td>");
		out.println("<td><font color='#787878'>28</font></td>");
		out.println("<td bgcolor='#787878'>29</td>");
		out.println("<td><font color='#787878'>30</font></td>");
		out.println("<td bgcolor='#787878'>31</td>");
		out.println("<td><font color='#787878'>32</font></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("<td><font color='#787878'>33</font></td>");
		out.println("<td bgcolor='#787878'>34</td>");
		out.println("<td><font color='#787878'>35</font></td>");
		out.println("<td bgcolor='#787878'>36</td>");
		out.println("<td><font color='#787878'>37</font></td>");
		out.println("<td bgcolor='#787878'>38</td>");
		out.println("<td><font color='#787878'>39</font></td>");
		out.println("<td bgcolor='#787878'>40</td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("<td bgcolor='#787878'>41</td>");
		out.println("<td><font color='#787878'>42</font></td>");
		out.println("<td bgcolor='#787878'>43</td>");
		out.println("<td><font color='#787878'>44</font></td>");
		out.println("<td bgcolor='#787878'>45</td>");
		out.println("<td><font color='#787878'>46</font></td>");
		out.println("<td bgcolor='#787878'>47</td>");
		out.println("<td><font color='#787878'>48</font></td>");
		out.println("</tr>  <tr align='center'>");
		out.println("<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("</tr>  <tr align='center'>");
		out.println("<td bgcolor='#787878'><img src='torreBlanco.png'></td>");
		out.println("<td><font color='#787878'><img src='caballoBlanco.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='alfilBlanco.png'></td>");
		out.println("<td><font color='#787878'><img src='reyBlanco.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='reinaBlanco.png'></td>");
		out.println("<td><font color='#787878'><img src='alfilBlanco.png'></font></td>");
		out.println("<td bgcolor='#787878'><img src='caballoBlanco.png'></td>");
		out.println("<td><font color='#787878'><img src='torreBlanco.png'></font></td>");
		out.println("</tr>");
		out.println("</table>");
	}

}
