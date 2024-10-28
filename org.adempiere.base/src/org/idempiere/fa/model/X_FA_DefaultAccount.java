/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.idempiere.fa.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for FA_DefaultAccount
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="FA_DefaultAccount")
public class X_FA_DefaultAccount extends PO implements I_FA_DefaultAccount, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241017L;

    /** Standard Constructor */
    public X_FA_DefaultAccount (Properties ctx, int FA_DefaultAccount_ID, String trxName)
    {
      super (ctx, FA_DefaultAccount_ID, trxName);
      /** if (FA_DefaultAccount_ID == 0)
        {
			setA_Accumdepreciation_Acct (0);
			setA_Asset_Acct (0);
			setA_Depreciation_Acct (0);
			setA_Depreciation_ID (0);
			setA_Disposal_Gain_Acct (0);
			setA_Disposal_Loss_Acct (0);
			setC_AcctSchema_ID (0);
// @C_AcctSchema_ID@
			setFA_DefaultAccount_ID (0);
			setPostingType (null);
// A
        } */
    }

    /** Standard Constructor */
    public X_FA_DefaultAccount (Properties ctx, int FA_DefaultAccount_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, FA_DefaultAccount_ID, trxName, virtualColumns);
      /** if (FA_DefaultAccount_ID == 0)
        {
			setA_Accumdepreciation_Acct (0);
			setA_Asset_Acct (0);
			setA_Depreciation_Acct (0);
			setA_Depreciation_ID (0);
			setA_Disposal_Gain_Acct (0);
			setA_Disposal_Loss_Acct (0);
			setC_AcctSchema_ID (0);
// @C_AcctSchema_ID@
			setFA_DefaultAccount_ID (0);
			setPostingType (null);
// A
        } */
    }

    /** Standard Constructor */
    public X_FA_DefaultAccount (Properties ctx, String FA_DefaultAccount_UU, String trxName)
    {
      super (ctx, FA_DefaultAccount_UU, trxName);
      /** if (FA_DefaultAccount_UU == null)
        {
			setA_Accumdepreciation_Acct (0);
			setA_Asset_Acct (0);
			setA_Depreciation_Acct (0);
			setA_Depreciation_ID (0);
			setA_Disposal_Gain_Acct (0);
			setA_Disposal_Loss_Acct (0);
			setC_AcctSchema_ID (0);
// @C_AcctSchema_ID@
			setFA_DefaultAccount_ID (0);
			setPostingType (null);
// A
        } */
    }

    /** Standard Constructor */
    public X_FA_DefaultAccount (Properties ctx, String FA_DefaultAccount_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, FA_DefaultAccount_UU, trxName, virtualColumns);
      /** if (FA_DefaultAccount_UU == null)
        {
			setA_Accumdepreciation_Acct (0);
			setA_Asset_Acct (0);
			setA_Depreciation_Acct (0);
			setA_Depreciation_ID (0);
			setA_Disposal_Gain_Acct (0);
			setA_Disposal_Loss_Acct (0);
			setC_AcctSchema_ID (0);
// @C_AcctSchema_ID@
			setFA_DefaultAccount_ID (0);
			setPostingType (null);
// A
        } */
    }

    /** Load Constructor */
    public X_FA_DefaultAccount (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_FA_DefaultAccount[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_C_ValidCombination getA_Accumdepreciation_A() throws RuntimeException
	{
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_ID)
			.getPO(getA_Accumdepreciation_Acct(), get_TrxName());
	}

	/** Set Accumulated Depreciation Account.
		@param A_Accumdepreciation_Acct Accumulated Depreciation Account
	*/
	public void setA_Accumdepreciation_Acct (int A_Accumdepreciation_Acct)
	{
		set_Value (COLUMNNAME_A_Accumdepreciation_Acct, Integer.valueOf(A_Accumdepreciation_Acct));
	}

	/** Get Accumulated Depreciation Account.
		@return Accumulated Depreciation Account	  */
	public int getA_Accumdepreciation_Acct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Accumdepreciation_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_ValidCombination getA_Asset_A() throws RuntimeException
	{
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_ID)
			.getPO(getA_Asset_Acct(), get_TrxName());
	}

	/** Set Asset Acct.
		@param A_Asset_Acct Asset Acct
	*/
	public void setA_Asset_Acct (int A_Asset_Acct)
	{
		set_Value (COLUMNNAME_A_Asset_Acct, Integer.valueOf(A_Asset_Acct));
	}

	/** Get Asset Acct.
		@return Asset Acct	  */
	public int getA_Asset_Acct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_ValidCombination getA_Asset_Clearing_A() throws RuntimeException
	{
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_ID)
			.getPO(getA_Asset_Clearing_Acct(), get_TrxName());
	}

	/** Set Asset Clearing Acct.
		@param A_Asset_Clearing_Acct Asset Clearing Acct
	*/
	public void setA_Asset_Clearing_Acct (int A_Asset_Clearing_Acct)
	{
		set_Value (COLUMNNAME_A_Asset_Clearing_Acct, Integer.valueOf(A_Asset_Clearing_Acct));
	}

	/** Get Asset Clearing Acct.
		@return Asset Clearing Acct	  */
	public int getA_Asset_Clearing_Acct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_Clearing_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_ValidCombination getA_Depreciation_A() throws RuntimeException
	{
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_ID)
			.getPO(getA_Depreciation_Acct(), get_TrxName());
	}

	/** Set Depreciation Account.
		@param A_Depreciation_Acct Depreciation Account
	*/
	public void setA_Depreciation_Acct (int A_Depreciation_Acct)
	{
		set_Value (COLUMNNAME_A_Depreciation_Acct, Integer.valueOf(A_Depreciation_Acct));
	}

	/** Get Depreciation Account.
		@return Depreciation Account	  */
	public int getA_Depreciation_Acct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Depreciation_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_A_Depreciation getA_Depreciation() throws RuntimeException
	{
		return (org.compiere.model.I_A_Depreciation)MTable.get(getCtx(), org.compiere.model.I_A_Depreciation.Table_ID)
			.getPO(getA_Depreciation_ID(), get_TrxName());
	}

	/** Set Depreciation.
		@param A_Depreciation_ID Depreciation
	*/
	public void setA_Depreciation_ID (int A_Depreciation_ID)
	{
		if (A_Depreciation_ID < 1)
			set_Value (COLUMNNAME_A_Depreciation_ID, null);
		else
			set_Value (COLUMNNAME_A_Depreciation_ID, Integer.valueOf(A_Depreciation_ID));
	}

	/** Get Depreciation.
		@return Depreciation	  */
	public int getA_Depreciation_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Depreciation_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_ValidCombination getA_Disposal_Gain_A() throws RuntimeException
	{
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_ID)
			.getPO(getA_Disposal_Gain_Acct(), get_TrxName());
	}

	/** Set Disposal Gain Acct.
		@param A_Disposal_Gain_Acct Disposal Gain Acct
	*/
	public void setA_Disposal_Gain_Acct (int A_Disposal_Gain_Acct)
	{
		set_Value (COLUMNNAME_A_Disposal_Gain_Acct, Integer.valueOf(A_Disposal_Gain_Acct));
	}

	/** Get Disposal Gain Acct.
		@return Disposal Gain Acct	  */
	public int getA_Disposal_Gain_Acct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Disposal_Gain_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_ValidCombination getA_Disposal_Loss_A() throws RuntimeException
	{
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_ID)
			.getPO(getA_Disposal_Loss_Acct(), get_TrxName());
	}

	/** Set Disposal Loss Acct.
		@param A_Disposal_Loss_Acct Disposal Loss Acct
	*/
	public void setA_Disposal_Loss_Acct (int A_Disposal_Loss_Acct)
	{
		set_Value (COLUMNNAME_A_Disposal_Loss_Acct, Integer.valueOf(A_Disposal_Loss_Acct));
	}

	/** Get Disposal Loss Acct.
		@return Disposal Loss Acct	  */
	public int getA_Disposal_Loss_Acct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Disposal_Loss_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_ValidCombination getA_Disposal_Revenue_A() throws RuntimeException
	{
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_ID)
			.getPO(getA_Disposal_Revenue_Acct(), get_TrxName());
	}

	/** Set Disposal Revenue Acct.
		@param A_Disposal_Revenue_Acct Disposal Revenue Acct
	*/
	public void setA_Disposal_Revenue_Acct (int A_Disposal_Revenue_Acct)
	{
		set_Value (COLUMNNAME_A_Disposal_Revenue_Acct, Integer.valueOf(A_Disposal_Revenue_Acct));
	}

	/** Get Disposal Revenue Acct.
		@return Disposal Revenue Acct	  */
	public int getA_Disposal_Revenue_Acct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Disposal_Revenue_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_AcctSchema getC_AcctSchema() throws RuntimeException
	{
		return (org.compiere.model.I_C_AcctSchema)MTable.get(getCtx(), org.compiere.model.I_C_AcctSchema.Table_ID)
			.getPO(getC_AcctSchema_ID(), get_TrxName());
	}

	/** Set Accounting Schema.
		@param C_AcctSchema_ID Rules for accounting
	*/
	public void setC_AcctSchema_ID (int C_AcctSchema_ID)
	{
		if (C_AcctSchema_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_AcctSchema_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_AcctSchema_ID, Integer.valueOf(C_AcctSchema_ID));
	}

	/** Get Accounting Schema.
		@return Rules for accounting
	  */
	public int getC_AcctSchema_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_AcctSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set FA_DefaultAccount.
		@param FA_DefaultAccount_ID FA_DefaultAccount
	*/
	public void setFA_DefaultAccount_ID (int FA_DefaultAccount_ID)
	{
		if (FA_DefaultAccount_ID < 1)
			set_ValueNoCheck (COLUMNNAME_FA_DefaultAccount_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_FA_DefaultAccount_ID, Integer.valueOf(FA_DefaultAccount_ID));
	}

	/** Get FA_DefaultAccount.
		@return FA_DefaultAccount	  */
	public int getFA_DefaultAccount_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FA_DefaultAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair()
    {
        return new KeyNamePair(get_ID(), String.valueOf(getFA_DefaultAccount_ID()));
    }

	/** Set FA_DefaultAccount_UU.
		@param FA_DefaultAccount_UU FA_DefaultAccount_UU
	*/
	public void setFA_DefaultAccount_UU (String FA_DefaultAccount_UU)
	{
		set_Value (COLUMNNAME_FA_DefaultAccount_UU, FA_DefaultAccount_UU);
	}

	/** Get FA_DefaultAccount_UU.
		@return FA_DefaultAccount_UU	  */
	public String getFA_DefaultAccount_UU()
	{
		return (String)get_Value(COLUMNNAME_FA_DefaultAccount_UU);
	}

	/** PostingType AD_Reference_ID=125 */
	public static final int POSTINGTYPE_AD_Reference_ID=125;
	/** Actual = A */
	public static final String POSTINGTYPE_Actual = "A";
	/** Budget = B */
	public static final String POSTINGTYPE_Budget = "B";
	/** Commitment = E */
	public static final String POSTINGTYPE_Commitment = "E";
	/** Reservation = R */
	public static final String POSTINGTYPE_Reservation = "R";
	/** Statistical = S */
	public static final String POSTINGTYPE_Statistical = "S";
	/** Set Posting Type.
		@param PostingType The type of posted amount for the transaction
	*/
	public void setPostingType (String PostingType)
	{

		set_Value (COLUMNNAME_PostingType, PostingType);
	}

	/** Get Posting Type.
		@return The type of posted amount for the transaction
	  */
	public String getPostingType()
	{
		return (String)get_Value(COLUMNNAME_PostingType);
	}
}