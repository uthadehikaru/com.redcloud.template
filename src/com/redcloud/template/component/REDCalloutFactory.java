package com.redcloud.template.component;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;

import com.redcloud.template.callout.CalloutREDTemplate;
import com.redcloud.template.model.MREDTemplate;

public class REDCalloutFactory implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		
		if(tableName.equals(MREDTemplate.Table_Name))
			list.add(new CalloutREDTemplate());
		
		return list != null? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}

}
