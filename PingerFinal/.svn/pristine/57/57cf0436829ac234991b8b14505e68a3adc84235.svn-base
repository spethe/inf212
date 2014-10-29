package ee.pinger.database;

import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class WebResourceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Repository repository;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = config.getServletContext();
		repository = (Repository) context.getAttribute("repository");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Calendar cal = Calendar.getInstance();
		String pingTime = cal.getTime().toString();

		try {
			JSONObject json = new JSONObject();
			int processingTime = takeABreak();

			repository.write(new Ping(this.getClass().getSimpleName(), pingTime, processingTime));

			json.put("processingTime", processingTime);
			response.setContentType("application/json");
			response.getWriter().write(json.toString());
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		repository.destroy();
	}

	private int takeABreak() throws InterruptedException {
		int sleepTime = new Random().nextInt(7000 - 2000) + 2000;
		Thread.sleep(sleepTime);
		return sleepTime;
	}

}