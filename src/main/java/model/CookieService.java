package model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    void saveSelectedBox(HttpServletResponse response, int selectedBox);
    int getSelectedBox(HttpServletRequest request);
}
