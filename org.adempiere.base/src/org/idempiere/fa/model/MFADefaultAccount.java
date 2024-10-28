package org.idempiere.fa.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCharge;
import org.compiere.util.CLogger;
import org.compiere.util.DB;

public class MFADefaultAccount extends X_FA_DefaultAccount {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MFADefaultAccount(Properties ctx, int FA_DefaultAccount_ID,
			String trxName) {
		super(ctx, FA_DefaultAccount_ID, trxName);
	
	}
	
	public MFADefaultAccount(Properties ctx, ResultSet rs,
			String trxName) {
		super(ctx, rs, trxName);
		
	}
	
	/**	Static Logger	*/
	private static CLogger	s_log	= CLogger.getCLogger (MCharge.class);
	

	/**
	 *  Get Asset Disposal Revenue Account
	 *  @param as account schema
	 *  @return Asset Disposal Revenue Account or null
	 */
	public static MAccount getAssetRevenueAccount (MAcctSchema as)
	{

		String sql = "SELECT A_Disposal_Revenue_Acct FROM FA_DefaultAccount WHERE C_AcctSchema_ID=?";
		int Account_ID = DB.getSQLValueEx(null, sql, as.get_ID());
		//	No account
		if (Account_ID <= 0)
		{
			s_log.severe ("NO account for Asset Disposal Revenue");
			return null;
		}

		//	Return Account
		MAccount acct = MAccount.get (as.getCtx(), Account_ID);
		return acct;
	}   //  getAccount
	
	/**
	 *  Get Asset Disposal Gain Account
	 *  @param as account schema
	 *  @return Asset Disposal Gain Account or null
	 */
	public static MAccount getAssetGainAccount (MAcctSchema as)
	{

		String sql = "SELECT A_Disposal_Gain_Acct FROM FA_DefaultAccount WHERE C_AcctSchema_ID=?";
		int Account_ID = DB.getSQLValueEx(null, sql, as.get_ID());
		//	No account
		if (Account_ID <= 0)
		{
			s_log.severe ("NO account for Asset Disposal Gain");
			return null;
		}

		//	Return Account
		MAccount acct = MAccount.get (as.getCtx(), Account_ID);
		return acct;
	}   //  getAccount

	/**
	 *  Get Asset Disposal Loss Account
	 *  @param as account schema
	 *  @return Asset Disposal Loss Account or null
	 */
	public static MAccount getAssetLossAccount (MAcctSchema as)
	{

		String sql = "SELECT A_Disposal_Loss_Acct FROM FA_DefaultAccount WHERE C_AcctSchema_ID=?";
		int Account_ID = DB.getSQLValueEx(null, sql, as.get_ID());
		//	No account
		if (Account_ID <= 0)
		{
			s_log.severe ("NO account for Asset Disposal Loss");
			return null;
		}

		//	Return Account
		MAccount acct = MAccount.get (as.getCtx(), Account_ID);
		return acct;
	}   //  getAccount

}
