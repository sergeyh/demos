package app;

import com.google.common.collect.ImmutableMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@WebServlet(
        urlPatterns = { "/character/*" }
)
public class CharacterFrontController extends HttpServlet {
    private static class Router {
        private final Map<String, Supplier<String>> routes;
        {
            Map<String, Supplier<String>> routes = new HashMap<>();
            routes.put(
                    "liukang",
                    () -> "<html><head></head><body><marquee><img src='../images/liukang.gif'/></marquee></body>");
            routes.put(
                    "raiden",
                    () -> "<html><head></head><body><marquee><img src='../images/raiden.gif'/></marquee></body>");
            this.routes = Collections.unmodifiableMap(routes);
        }

        public void route(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            Supplier<String> page = dispatch(req).orElseThrow(IllegalArgumentException::new);
            resp.getWriter().write(page.get());
        }

        private Optional<Supplier<String>> dispatch(HttpServletRequest req) {
            String[] uriParts = req.getRequestURI().split("/");
            return Optional.ofNullable(routes.get(uriParts[uriParts.length - 1]));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Router router = new Router();
        router.route(req, resp);
    }
}
