package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.formDAO;
import dto.FormDto;

@SuppressWarnings("serial")
@WebServlet("/googleForm")
public class FormController extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormDto dto = new FormDto();
		dto.setEmailId(request.getParameter("email"));
		dto.setName(request.getParameter("name"));
		dto.setPhoneNumber(request.getParameter("number"));
		dto.setAddress(request.getParameter("address"));
		dto.setGender(request.getParameter("gender"));
		dto.setDateOfBirth(request.getParameter("dob"));
		dto.setMaritalStatus(request.getParameter("maritalstatus"));
		dto.setNationality(request.getParameter("nationality"));

		formDAO fd = new formDAO();
		int result = fd.insertGoogleForm(dto);

		JSONObject jsonResponse = new JSONObject();

		if (result > 0) {
			jsonResponse.put("success", true);
			jsonResponse.put("message", "Inserted Successfully");
		} else {
			jsonResponse.put("success", false);
			jsonResponse.put("message", "Failed to Insert");
		}

		jsonResponse.put("data", dtoToJsonObject(dto));

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		writer.println(jsonResponse.toJSONString());
		writer.flush();
	}

	@SuppressWarnings("unchecked")
	private JSONObject dtoToJsonObject(FormDto dto) {
		JSONObject jsonDto = new JSONObject();
		jsonDto.put("name", dto.getName());
		jsonDto.put("email", dto.getEmailId());
		jsonDto.put("phoneNumber", dto.getPhoneNumber());
		jsonDto.put("address", dto.getAddress());
		jsonDto.put("dob", dto.getDateOfBirth());
		jsonDto.put("gender", dto.getGender());
		jsonDto.put("maritalStatus", dto.getMaritalStatus());
		jsonDto.put("nationality", dto.getNationality());
		return jsonDto;
	}

}
