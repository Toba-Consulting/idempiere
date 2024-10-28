/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.compiere.util.Util;

/**
 *	RfQ Model
 *	
 *  @author Jorg Janke
 *  @version $Id: MRfQ.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MRfQ extends X_C_RfQ implements DocAction, DocOptions
{
	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = 5332116213254863257L;

	/**
	 * 	Get MRfQ from DB
	 *	@param C_RfQ_ID id
	 *	@return MRfQ
	 */
	public static MRfQ get (int C_RfQ_ID)
	{
		return get(C_RfQ_ID, (String)null);
	}
	
	/**
	 * 	Get MRfQ from DB
	 *	@param C_RfQ_ID id
	 *	@param trxName transaction
	 *	@return MRfQ
	 */
	public static MRfQ get (int C_RfQ_ID, String trxName)
	{
		return get(Env.getCtx(), C_RfQ_ID, trxName);
	}
	
	/**
	 * 	Get MRfQ from DB
	 *	@param ctx context
	 *	@param C_RfQ_ID id
	 *	@param trxName transaction
	 *	@return MRfQ
	 */
	public static MRfQ get (Properties ctx, int C_RfQ_ID, String trxName)
	{
		MRfQ retValue = new MRfQ (ctx, C_RfQ_ID, trxName);
		if (retValue.get_ID () == C_RfQ_ID) 
		{
			return retValue;
		}
		return null;
	}	//	get

    /**
     * UUID based Constructor
     * @param ctx  Context
     * @param C_RfQ_UU  UUID key
     * @param trxName Transaction
     */
    public MRfQ(Properties ctx, String C_RfQ_UU, String trxName) {
        super(ctx, C_RfQ_UU, trxName);
		if (Util.isEmpty(C_RfQ_UU))
			setInitialDefaults();
    }

	/**
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param C_RfQ_ID id
	 *	@param trxName transaction
	 */
	public MRfQ (Properties ctx, int C_RfQ_ID, String trxName)
	{
		super (ctx, C_RfQ_ID, trxName);
		if (C_RfQ_ID == 0)
			setInitialDefaults();
	}	//	MRfQ

	/**
	 * Set the initial defaults for a new record
	 */
	private void setInitialDefaults() {
		setDateResponse (new Timestamp(System.currentTimeMillis()));
		setDateWorkStart (new Timestamp(System.currentTimeMillis()));
		setIsInvitedVendorsOnly (false);
		setQuoteType (QUOTETYPE_QuoteSelectedLines);
		setIsQuoteAllQty (false);
		setIsQuoteTotalAmt (false);
		setIsRfQResponseAccepted (true);
		setIsSelfService (true);
		setProcessed (false);
	}

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName transaction
	 */
	public MRfQ (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MRfQ
	
	/**
	 * Copy constructor
	 * @param copy
	 */
	public MRfQ(MRfQ copy) 
	{
		this(Env.getCtx(), copy);
	}

	/**
	 * Copy constructor
	 * @param ctx
	 * @param copy
	 */
	public MRfQ(Properties ctx, MRfQ copy) 
	{
		this(ctx, copy, (String) null);
	}

	/**
	 * Copy constructor
	 * @param ctx
	 * @param copy
	 * @param trxName
	 */
	public MRfQ(Properties ctx, MRfQ copy, String trxName) 
	{
		this(ctx, 0, trxName);
		copyPO(copy);
	}
	
	/**
	 * 	Get active RFQ Lines
	 *	@return array of RFQ lines
	 */
	public MRfQLine[] getLines()
	{
		ArrayList<MRfQLine> list = new ArrayList<MRfQLine>();
		String sql = "SELECT * FROM C_RfQLine "
			+ "WHERE C_RfQ_ID=? AND IsActive='Y' "
			+ "ORDER BY Line,C_RfQLine_ID ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (sql, get_TrxName());
			pstmt.setInt (1, getC_RfQ_ID());
			rs = pstmt.executeQuery ();
			while (rs.next ())
				list.add (new MRfQLine (getCtx(), rs, get_TrxName()));
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		MRfQLine[] retValue = new MRfQLine[list.size ()];
		list.toArray (retValue);
		return retValue;
	}	//	getLines

	/**
	 * 	Get RfQ Responses
	 * 	@param activeOnly active responses only
	 * 	@param completedOnly completed responses only
	 *	@return array of RFQ response
	 */
	public MRfQResponse[] getResponses (boolean activeOnly, boolean completedOnly)
	{
		ArrayList<MRfQResponse> list = new ArrayList<MRfQResponse>();
		String sql = "SELECT * FROM C_RfQResponse "
			+ "WHERE C_RfQ_ID=?";
		if (activeOnly)
			sql += " AND IsActive='Y'";
		if (completedOnly)
			sql += " AND IsComplete='Y'";
		sql += " ORDER BY Price";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (sql, get_TrxName());
			pstmt.setInt (1, getC_RfQ_ID());
			rs = pstmt.executeQuery ();
			while (rs.next ())
				list.add (new MRfQResponse (getCtx(), rs, get_TrxName()));
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		MRfQResponse[] retValue = new MRfQResponse[list.size ()];
		list.toArray (retValue);
		return retValue;
	}	//	getResponses
	
	/**
	 * 	String Representation
	 *	@return info
	 */
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder ("MRfQ[");
		sb.append(get_ID()).append(",Name=").append(getName())
			.append(",QuoteType=").append(getQuoteType())
			.append("]");
		return sb.toString ();
	}	//	toString
		
	/**
	 * 	Is Quote Total Amt Only
	 *	@return true if quote total amount only (QUOTETYPE_QuoteTotalOnly)
	 */
	public boolean isQuoteTotalAmtOnly()
	{
		return QUOTETYPE_QuoteTotalOnly.equals(getQuoteType());
	}	//	isQuoteTotalAmtOnly
	
	/**
	 * 	Is Quote Selected Lines
	 *	@return true if quote selected lines (QUOTETYPE_QuoteSelectedLines)
	 */
	public boolean isQuoteSelectedLines()
	{
		return QUOTETYPE_QuoteSelectedLines.equals(getQuoteType());
	}	//	isQuoteSelectedLines

	/**
	 * 	Is Quote All Lines
	 *	@return true if quote all lines (QUOTETYPE_QuoteAllLines)
	 */
	public boolean isQuoteAllLines()
	{
		return QUOTETYPE_QuoteAllLines.equals(getQuoteType());
	}	//	isQuoteAllLines

	/**
	 * 	Is "Quote Total Amt Only" Valid
	 *	@return null or error message
	 */
	public String checkQuoteTotalAmtOnly()
	{
		if (!isQuoteTotalAmtOnly())
			return null;
		//	Need to check Line Qty
		MRfQLine[] lines = getLines();
		for (int i = 0; i < lines.length; i++)
		{
			MRfQLine line = lines[i];
			MRfQLineQty[] qtys = line.getQtys();
			if (qtys.length > 1)
			{
				log.warning("isQuoteTotalAmtOnlyValid - #" + qtys.length + " - " + line);
				String msg = "@Line@ " + line.getLine() 
					+ ": #@C_RfQLineQty@=" + qtys.length + " - @IsQuoteTotalAmt@";
				return msg;
			}
		}
		return null;
	}	//	checkQuoteTotalAmtOnly
		
	/**
	 * 	Before Save
	 *	@param newRecord new
	 *	@return true
	 */
	@Override
	protected boolean beforeSave (boolean newRecord)
	{
		//	Calculate Complete Date (also used to verify)
		if (getDateWorkStart() != null && getDeliveryDays() != 0)
			setDateWorkComplete (TimeUtil.addDays(getDateWorkStart(), getDeliveryDays()));
		//	Calculate Delivery Days
		else if (getDateWorkStart() != null && getDeliveryDays() == 0 && getDateWorkComplete() != null)
			setDeliveryDays (TimeUtil.getDaysBetween(getDateWorkStart(), getDateWorkComplete()));
		//	Calculate Start Date
		else if (getDateWorkStart() == null && getDeliveryDays() != 0 && getDateWorkComplete() != null)
			setDateWorkStart (TimeUtil.addDays(getDateWorkComplete(), getDeliveryDays() * -1));
		
		return true;
	}	//	beforeSave
	
	@Override
	protected boolean beforeDelete() {
		
		String sql = "DELETE FROM M_MatchQuotation WHERE C_RfQ_ID="+get_ID();
		DB.executeUpdate(sql, get_TrxName());
		
		String sql3 = "DELETE FROM C_RfQLine WHERE C_RfQ_ID="+get_ID();
		DB.executeUpdate(sql3, get_TrxName());
		
		return true;
	}
	
	@Override
	public int customizeValidActions(String docStatus, Object processing,
			String orderType, String isSOTrx, int AD_Table_ID,
			String[] docAction, String[] options, int index) {
		index = 0;
		if (docStatus.equals(DocAction.STATUS_Drafted)) {
			options[index++] = DocAction.ACTION_Complete;
			options[index++] = DocAction.ACTION_Void;

		} else if (docStatus.equals(DocAction.STATUS_InProgress)) {
			options[index++] = DocAction.ACTION_Complete;
			options[index++] = DocAction.ACTION_Void;

		} else if (docStatus.equals(DocAction.STATUS_Invalid)) {
			options[index++] = DocAction.ACTION_Complete;
			options[index++] = DocAction.ACTION_Void;

		} else if (docStatus.equals(DocAction.STATUS_Completed)) {
			options[index++] = DocAction.ACTION_Void;
			options[index++] = DocAction.ACTION_Close;
			options[index++] = DocAction.ACTION_ReActivate;
		}

		return index;
	}
	
	/** Process Message */
	private String m_processMsg = null;

	/** Just Prepared Flag */
	private boolean m_justPrepared = false;
	
	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID = 135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";

	/**
	 * Set Document Action.
	 * @param DocAction
	 * The targeted status of the document
	 */
	public void setDocAction(String DocAction) {

		set_Value(COLUMNNAME_DocAction, DocAction);
	}

	@Override
	public String getDocAction() 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID = 131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	
	@Override
	public boolean processIt(String action) throws Exception {
		m_processMsg = null;
		DocumentEngine engine = new DocumentEngine(this, getDocStatus());
		return engine.processIt(action, getDocAction());

	}

	@Override
	public boolean unlockIt() {
		log.info(toString());
		setProcessing(false);
		return true;
	}

	@Override
	public boolean invalidateIt() {
		log.info(toString());
		setDocAction(DOCACTION_Prepare);
		return true;
	}

	@Override
	public String prepareIt() {
		log.info(toString());

		// Before Complete
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_BEFORE_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;

		MRfQLine[] lines = getLines();
		if (lines.length == 0) {
			m_processMsg = "No Document Lines Found";
			return DocAction.STATUS_Invalid;
		}

		if (m_processMsg == null)
			m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
					ModelValidator.TIMING_AFTER_PREPARE);
		return DocAction.STATUS_InProgress;
	}

	@Override
	public boolean approveIt() {
		log.info(toString());
		return true;
	}

	@Override
	public boolean rejectIt() {
		return false;
	}
	
	/**
	 * Set Document Status.
	 * @param DocStatus
	 * The current status of the document
	 */
	public void setDocStatus(String DocStatus) {

		set_Value(COLUMNNAME_DocStatus, DocStatus);
	}

	/**
	 * Get Document Status.
	 * 
	 * @return The current status of the document
	 */
	public String getDocStatus() {
		return (String) get_Value(COLUMNNAME_DocStatus);
	}

	/**
	 * Set Processed.
	 * @param Processed
	 * The document has been processed
	 */
	public void setProcessed(boolean Processed) {
		set_Value(COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/**
	 * Get Processed.
	 * @return The document has been processed
	 */
	public boolean isProcessed() {
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
	
	public void setDateDoc (Timestamp DateDoc)
	{
		set_Value (COLUMNNAME_DateDoc, DateDoc);
	}

	/** Get Document Date.
		@return Date of the Document
	  */
	public Timestamp getDateDoc () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateDoc);
	}
	/**
	 * Set Process Now.
	 * @param Processing
	 * Process Now
	 */
	public void setProcessing(boolean Processing) {
		set_Value(COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/**
	 * Get Process Now.
	 * @return Process Now
	 */
	public boolean isProcessing() {
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
	
	public static MRfQ copyFrom(MRfQ from, String trxName) {
		MRfQ to = new MRfQ (from.getCtx(), 0, trxName);
		to.set_TrxName(trxName);
		PO.copyValues(from, to, from.getAD_Client_ID(), from.getAD_Org_ID());
		to.set_ValueNoCheck ("C_RfQ_ID", I_ZERO);
		to.set_ValueNoCheck ("DocumentNo", from.getDocumentNo()+"R");
		to.setC_BPartner_ID(from.getC_BPartner_ID());
		to.setC_BPartner_Location_ID(from.getC_BPartner_Location_ID());
		to.setAD_User_ID(from.getAD_User_ID());
		to.setC_Currency_ID(from.getC_Currency_ID());
		to.set_ValueOfColumn("C_DocType_ID", from.get_ValueAsInt("C_DocType_ID"));
		to.setC_RfQ_Topic_ID(from.getC_RfQ_Topic_ID());
		to.setDateDoc(from.getDateDoc());
		to.setDateResponse(from.getDateResponse());
		to.setDateWorkStart(from.getDateWorkStart());
		to.setDateWorkComplete(from.getDateWorkComplete());
		to.setDeliveryDays(from.getDeliveryDays());
		to.setDescription(from.getDescription());
		to.setDocAction(from.getDocAction());
		to.setDocStatus(from.getDocStatus());
		to.setHelp(from.getHelp());
		to.setIsInvitedVendorsOnly(from.isInvitedVendorsOnly());
		to.setIsQuoteAllQty(from.isQuoteAllQty());
		to.setIsQuoteTotalAmt(from.isQuoteTotalAmt());
		to.setIsRfQResponseAccepted(from.isRfQResponseAccepted());
		to.setMargin(from.getMargin());
		to.setName(from.getName());
		to.setQuoteType(from.getQuoteType());
		to.setSalesRep_ID(from.getSalesRep_ID());
		to.setProcessed(true);
		to.setProcessing(false);	
		if (!to.save(trxName))
			throw new IllegalStateException("Could not create RfQ");
	
		//
		//
		//
		
		if (to.copyLinesFrom(from) == 0)
			throw new IllegalStateException("Could not create RfQ Lines");

		if (to.copyResponseFrom(from) == 0)
			throw new IllegalStateException("Could not create Response");
		
		
		return to;
	}	//	copyFrom
	
	public int copyLinesFrom (MRfQ otherQuote)
	{
		if (otherQuote == null)
			return 0;
		MRfQLine[] fromLines = otherQuote.getLines();
		int count = 0;
		for (MRfQLine fromLine: fromLines)
		{
			MRfQLine line = new MRfQLine (this);
			PO.copyValues(fromLine, line, getAD_Client_ID(), getAD_Org_ID());
			line.setC_RfQ_ID(getC_RfQ_ID());
			line.set_ValueNoCheck ("C_RfQLine_ID", I_ZERO);	
			line.set_ValueOfColumn("C_Charge_ID", fromLine.get_ValueAsInt("C_Charge_ID"));
			line.set_ValueOfColumn("C_UOM_ID", fromLine.get_ValueAsInt("C_UOM_ID"));
			line.setDateWorkComplete(fromLine.getDateWorkComplete());
			line.setDateWorkStart(fromLine.getDateWorkStart());
			line.setDeliveryDays(fromLine.getDeliveryDays());
			line.setDescription(fromLine.getDescription());
			line.setHelp(fromLine.getHelp());
			line.setIsDescription(fromLine.isDescription());
			line.setLine(fromLine.getLine());
			line.setM_Product_ID(fromLine.getM_Product_ID());
			line.set_ValueNoCheck ("M_Product_ID", fromLine.get_ValueAsString("M_Product_ID"));	//	new
			line.set_ValueOfColumn("Qty", fromLine.get_ValueAsInt("Qty"));
			//
			
			line.set_ValueOfColumn("Processed", true);;
			if (line.save(get_TrxName()))
				count++;
		}
		if (fromLines.length != count)
			log.log(Level.SEVERE, "Line difference - From=" + fromLines.length + " <> Saved=" + count);
		return count;
	}	//	copyLinesFrom
	
	public int copyResponseFrom (MRfQ otherQuote)
	{
		if (otherQuote == null)
			return 0;
		MRfQResponse[] fromResponses = otherQuote.getResponses(true, false);
		int count = 0;
		for (MRfQResponse fResponse: fromResponses)
		{
			MRfQResponse response = new MRfQResponse(getCtx(), 0, get_TrxName());
			PO.copyValues(fResponse, response, getAD_Client_ID(), getAD_Org_ID());
			response.setC_RfQ_ID(this.getC_RfQ_ID());
			response.set_ValueNoCheck ("C_RfQResponse_ID", I_ZERO);	
			//
			response.setProcessed(true);
			if (response.save(get_TrxName()))
				count++;
			
			if (copyResponseLineFrom(response,fResponse) == 0)
				throw new IllegalStateException("Could not copy Response Line");
			
		}
		if (fromResponses.length != count)
			log.log(Level.SEVERE, "Line difference - From=" + fromResponses.length + " <> Saved=" + count);
		
		return count;
		
		
	}	//	copyResponseFrom

	public int copyResponseLineFrom (MRfQResponse fromResponse, MRfQResponse otherResponse)
	{
		if (otherResponse == null)
			return 0;
		MRfQResponseLine[] fromResponseLines = otherResponse.getLines();
		int count = 0;
		for (MRfQResponseLine fResponseLine: fromResponseLines)
		{
			MRfQResponseLine responseLine = new MRfQResponseLine(getCtx(), 0, get_TrxName());
			PO.copyValues(fResponseLine, responseLine, getAD_Client_ID(), getAD_Org_ID());
			responseLine.set_ValueNoCheck ("C_RfQResponseLine_ID", I_ZERO);	
			responseLine.setC_RfQResponse_ID(fromResponse.get_ID());
			responseLine.set_ValueNoCheck ("M_Product_Category_ID", fResponseLine.get_ValueAsInt("M_Product_Category_ID"));	
			responseLine.set_ValueNoCheck ("Product", fResponseLine.get_ValueAsString("Product"));	//	new
			responseLine.set_ValueNoCheck ("Size", fResponseLine.get_ValueAsString("Size"));	//	new
			//
			
			responseLine.set_ValueOfColumn("Processed", true);
			if (responseLine.save(get_TrxName()))
				count++;
		}
		if (fromResponseLines.length != count)
			log.log(Level.SEVERE, "Line difference - From=" + fromResponseLines.length + " <> Saved=" + count);
		return count;
	}	//	copyResponseLineFrom
	
	@Override
	public String completeIt() {
		StringBuilder info = new StringBuilder("");

		// Just prepare
		if (DOCACTION_Prepare.equals(getDocAction())) {
			setProcessed(false);
			return DocAction.STATUS_InProgress;
		}

		// Re-Check
		if (!m_justPrepared) {
			String status = prepareIt();
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}

		 m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
		 ModelValidator.TIMING_BEFORE_COMPLETE);
		 if (m_processMsg != null)
		 return DocAction.STATUS_Invalid;
		
		 MRfQLine[] lines = getLines();
		 for (MRfQLine line : lines) {
			 line.set_ValueOfColumn("Processed", true);
			 line.saveEx();
		 }

		String valid = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_AFTER_COMPLETE);
		if (valid != null) {
			if (info.length() > 0)
				info.append(" - ");
			info.append(valid);
			m_processMsg = info.toString();
			return DocAction.STATUS_Invalid;
		}

		setProcessed(true);
		m_processMsg = info.toString();
		setDocAction(DOCACTION_Close);
		setDocStatus(DOCSTATUS_Completed);
		return DocAction.STATUS_Completed;

	}

	@Override
	public boolean voidIt() {
		log.info(toString());

		// Before Void
		 m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
		 ModelValidator.TIMING_BEFORE_VOID);
		 if (m_processMsg != null)
		 return false;
		
		 MRfQLine [] lines = getLines();
		 for (MRfQLine line : lines ){
		 line.setDescription("VOIDED");
		 line.set_ValueOfColumn("Processed", true);
		 line.set_ValueOfColumn("Qty", Env.ZERO);
		 line.saveEx();
		 }
		 
		 MRfQResponse[] responses = getResponses(true, false);
		 
		 for (MRfQResponse response: responses) {
			 response.setDescription("VOIDED");
			 response.setProcessed(true);
			 response.saveEx();
			 
			 MRfQResponseLine[] rLines = response.getLines(true);
			 
			 for (MRfQResponseLine rLine: rLines) {
				 rLine.set_ValueOfColumn("Processed", true);
				 /*
				  * void cant make price zero
				 rLine.setQty(Env.ZERO);
				 rLine.setPrice(Env.ZERO);
				 rLine.setPriceActual(Env.ZERO);
				 rLine.setPriceKondisi(Env.ZERO);
				 rLine.setPriceStd(Env.ZERO);
				 */
				 rLine.setDescription("VOIDED");
				 rLine.saveEx();
				 
			 }
		 }
		 
		// Afer void

		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_AFTER_VOID);
		if (m_processMsg != null)
			return false;

		setProcessed(true);
		setDocAction(DOCACTION_None);
		setDocStatus(DocAction.STATUS_Voided);

		return true;
	}

	@Override
	public boolean closeIt() {
		log.info(toString());
		// Before Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_BEFORE_CLOSE);
		if (m_processMsg != null)
			return false;

		setProcessed(true);
		setDocAction(DOCACTION_None);

		// After Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_AFTER_CLOSE);
		if (m_processMsg != null)
			return false;
		return true;
	}

	@Override
	public boolean reverseCorrectIt() {
		log.info(toString());
		// Before reverseCorrect
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_BEFORE_REVERSECORRECT);
		if (m_processMsg != null)
			return false;

		// After reverseCorrect
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_AFTER_REVERSECORRECT);
		if (m_processMsg != null)
			return false;

		return true;
	}

	@Override
	public boolean reverseAccrualIt() {
		log.info(toString());
		// Before reverseAccrual
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_BEFORE_REVERSEACCRUAL);
		if (m_processMsg != null)
			return false;

		// After reverseAccrual
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_AFTER_REVERSEACCRUAL);
		if (m_processMsg != null)
			return false;

		return true;
	}

	@Override
	public boolean reActivateIt() {
		log.info(toString());
		// Before reactivate
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_BEFORE_REACTIVATE);
		if (m_processMsg != null)
			return false;

		String whereClause = " C_RfQ_ID = " + getC_RfQ_ID();
		boolean match = new Query(getCtx(), MRfQResponse.Table_Name, whereClause, get_TrxName()).match();
		if(match) {
			throw new AdempiereException("RfQ still has a valid RfQ Responses");
		}
		
		String sql1 = "UPDATE C_RfQLine set processed = 'N' WHERE C_RfQ_ID = ?";
	    DB.executeUpdate(sql1, getC_RfQ_ID(), get_TrxName());
		
		// After reactivate
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,
				ModelValidator.TIMING_AFTER_REACTIVATE);
		if (m_processMsg != null)
			return false;

		setDocAction(DOCACTION_Complete);
		setProcessed(false);
		
		return true;
	}

	@Override
	public String getSummary() {
		StringBuffer sb = new StringBuffer();
		sb.append(getDocumentNo());
		// : Total Lines = 123.00 (#1)
		sb.append(":").append(" (#").append(getLines().length).append(")");
		// - Description
		if (getDescription() != null && getDescription().length() > 0)
			sb.append(" - ").append(getDescription());
		return sb.toString();
	}

	@Override
	public String getDocumentInfo() {
		MDocType dt = MDocType.get(getCtx(), get_ValueAsInt("C_DocType_ID"));
		return dt.getName() + " " + getDocumentNo();
	}

	public File createPDF(File file) {
		// We have a Jasper Print Format
		// ==============================
		ProcessInfo pi = new ProcessInfo("", 1000151); // TODO: @win hardcode to
														// jasper process
		pi.setRecord_ID(getC_RfQ_ID());
		pi.setExport(true);
		pi.setExportFileExtension("pdf");
		pi.setIsBatch(true);

		ServerProcessCtl.process(pi, null);

		return pi.getExportFile();

	}

	@Override
	public File createPDF() 
	{
		return createPDF (null);
	}// getPDF

	@Override
	public String getProcessMsg() {
		return m_processMsg;
	}

	@Override
	public int getDoc_User_ID() {

		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		return Env.ZERO;
	}
}	//	MRfQ
