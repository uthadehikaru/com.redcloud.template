package com.redcloud.template.component;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class REDValidatorFactory extends AbstractEventHandler {
	private CLogger log = CLogger.getCLogger(REDValidatorFactory.class);

	@Override
	protected void initialize() {
		registerEvent(IEventTopics.AFTER_LOGIN);

		log.info("RED EVENT MANAGER // INITIALIZED");
	}

	@Override
	protected void doHandleEvent(Event event) {
		String type = event.getTopic();
		String msg = "";
		if (type.equals(IEventTopics.AFTER_LOGIN)) {
			LoginEventData eventData = getEventData(event);
			log.info(" topic="+event.getTopic()+" AD_Client_ID="+eventData.getAD_Client_ID()
					+" AD_Org_ID="+eventData.getAD_Org_ID()+" AD_Role_ID="+eventData.getAD_Role_ID()
					+" AD_User_ID="+eventData.getAD_User_ID());
			Env.setContext(Env.getCtx(), "#RED_ACTIVATED", true);
		}
		
		if (msg!=null && msg.length() > 0)
			logEvent(event, getPO(event), msg);
	}


	private void logEvent (Event event, PO po, String msg) {
		log.fine("RED EVENT MANAGER // "+event.getTopic()+" po="+po+" MESSAGE ="+msg);
		throw new AdempiereException(msg);
	}

}
