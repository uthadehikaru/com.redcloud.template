package com.redcloud.template.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MREDTemplate extends X_RED_Template{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7069569239395587007L;

	public MREDTemplate(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MREDTemplate(Properties ctx, int RED_Template_ID, String trxName) {
		super(ctx, RED_Template_ID, trxName);
	}


}
