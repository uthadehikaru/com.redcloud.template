package com.redcloud.template.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.CLogger;

import com.redcloud.template.model.MREDTemplate;

public class CalloutREDTemplate implements IColumnCallout {
	private CLogger log = CLogger.getCLogger(CalloutREDTemplate.class);

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		
		if(mField.getColumnName().equals(MREDTemplate.COLUMNNAME_Value))
			logValue(ctx, WindowNo, mTab, mField, value, oldValue);
		
		return null;
	}

	private void logValue(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(value==null)
			return;
		
		log.info("Callout Example");
	}

}
