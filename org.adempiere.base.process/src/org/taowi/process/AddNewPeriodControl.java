package org.taowi.process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.compiere.model.I_C_Period;
import org.compiere.model.MDocType;
import org.compiere.model.MPeriod;
import org.compiere.model.MPeriodControl;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

@org.adempiere.base.annotation.Process
public class AddNewPeriodControl extends SvrProcess {

	private int p_C_Year_ID = 0;

	/**
	 * Prepare - e.g., get Parameters.
	 */
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		p_C_Year_ID = getRecord_ID();
	} // prepare

	/**
	 * Perform process.
	 * 
	 * @return Message (translated text)
	 * @throws Exception
	 *             if not successful
	 */
	protected String doIt() throws Exception {

		int noInsertPeriodControl = 0;

		MYear year = new MYear(getCtx(), p_C_Year_ID, get_TrxName());
		if (log.isLoggable(Level.INFO))
			log.info("Synchronize Year - " + year);

		MPeriod[] periods = getPeriod(p_C_Year_ID);

		for (MPeriod period : periods) {
			
			// List to hold unmatched DocBaseType values
			List<String> unmatchedDocBaseTypes = new ArrayList<>();

			MPeriodControl[] periodControls = period.getPeriodControls(true);
			MDocType[] types = MDocType.getOfClient(getCtx());

			for (MDocType type : types) {
				String docBaseType = type.getDocBaseType();
				boolean matched = false;

				if (unmatchedDocBaseTypes.contains(docBaseType))
					continue;

				for (MPeriodControl periodControl : periodControls) {
					if (periodControl.getDocBaseType().equals(docBaseType)) {
						matched = true;
						break;
					}
				}

				// If no matching period control found, add to unmatched list
				if (!matched) {
					MPeriodControl pc = new MPeriodControl(period, docBaseType);
					if (pc.save()) {
						noInsertPeriodControl++;
					}
				}
				unmatchedDocBaseTypes.add(docBaseType);
			}
		}
		
		addLog(0, null, new BigDecimal(noInsertPeriodControl), "@C_PeriodControl_ID@: @Inserted@");
		return "";
	} // doIt
	
	public MPeriod[] getPeriod(int C_Year_ID) {

		List<MPeriod> list = new Query(getCtx(), I_C_Period.Table_Name, "C_Year_ID=?", get_TrxName())
				.setParameters(C_Year_ID).setOrderBy(MPeriod.COLUMNNAME_PeriodNo).list();
		//
		MPeriod[] periods = new MPeriod[list.size()];
		list.toArray(periods);
		return periods;
	} // getPeriod
}
