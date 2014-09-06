package com.xsjrw.websit.core.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.xsjrw.websit.core.util.EvaluateUtil;


public class AutoEvalToValServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		EvaluateUtil.autoEvalVal();
	}
	
}