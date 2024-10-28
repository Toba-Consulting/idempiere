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
package org.idempiere.fa.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for FA_DefaultAccount
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_FA_DefaultAccount 
{

    /** TableName=FA_DefaultAccount */
    public static final String Table_Name = "FA_DefaultAccount";

    /** AD_Table_ID=300034 */
    public static final int Table_ID = 300034;

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 2 - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(2);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name A_Accumdepreciation_Acct */
    public static final String COLUMNNAME_A_Accumdepreciation_Acct = "A_Accumdepreciation_Acct";

	/** Set Accumulated Depreciation Account	  */
	public void setA_Accumdepreciation_Acct (int A_Accumdepreciation_Acct);

	/** Get Accumulated Depreciation Account	  */
	public int getA_Accumdepreciation_Acct();

	public I_C_ValidCombination getA_Accumdepreciation_A() throws RuntimeException;

    /** Column name A_Asset_Acct */
    public static final String COLUMNNAME_A_Asset_Acct = "A_Asset_Acct";

	/** Set Asset Acct	  */
	public void setA_Asset_Acct (int A_Asset_Acct);

	/** Get Asset Acct	  */
	public int getA_Asset_Acct();

	public I_C_ValidCombination getA_Asset_A() throws RuntimeException;

    /** Column name A_Asset_Clearing_Acct */
    public static final String COLUMNNAME_A_Asset_Clearing_Acct = "A_Asset_Clearing_Acct";

	/** Set Asset Clearing Acct	  */
	public void setA_Asset_Clearing_Acct (int A_Asset_Clearing_Acct);

	/** Get Asset Clearing Acct	  */
	public int getA_Asset_Clearing_Acct();

	public I_C_ValidCombination getA_Asset_Clearing_A() throws RuntimeException;

    /** Column name A_Depreciation_Acct */
    public static final String COLUMNNAME_A_Depreciation_Acct = "A_Depreciation_Acct";

	/** Set Depreciation Account	  */
	public void setA_Depreciation_Acct (int A_Depreciation_Acct);

	/** Get Depreciation Account	  */
	public int getA_Depreciation_Acct();

	public I_C_ValidCombination getA_Depreciation_A() throws RuntimeException;

    /** Column name A_Depreciation_ID */
    public static final String COLUMNNAME_A_Depreciation_ID = "A_Depreciation_ID";

	/** Set Depreciation	  */
	public void setA_Depreciation_ID (int A_Depreciation_ID);

	/** Get Depreciation	  */
	public int getA_Depreciation_ID();

	public org.compiere.model.I_A_Depreciation getA_Depreciation() throws RuntimeException;

    /** Column name A_Disposal_Gain_Acct */
    public static final String COLUMNNAME_A_Disposal_Gain_Acct = "A_Disposal_Gain_Acct";

	/** Set Disposal Gain Acct	  */
	public void setA_Disposal_Gain_Acct (int A_Disposal_Gain_Acct);

	/** Get Disposal Gain Acct	  */
	public int getA_Disposal_Gain_Acct();

	public I_C_ValidCombination getA_Disposal_Gain_A() throws RuntimeException;

    /** Column name A_Disposal_Loss_Acct */
    public static final String COLUMNNAME_A_Disposal_Loss_Acct = "A_Disposal_Loss_Acct";

	/** Set Disposal Loss Acct	  */
	public void setA_Disposal_Loss_Acct (int A_Disposal_Loss_Acct);

	/** Get Disposal Loss Acct	  */
	public int getA_Disposal_Loss_Acct();

	public I_C_ValidCombination getA_Disposal_Loss_A() throws RuntimeException;

    /** Column name A_Disposal_Revenue_Acct */
    public static final String COLUMNNAME_A_Disposal_Revenue_Acct = "A_Disposal_Revenue_Acct";

	/** Set Disposal Revenue Acct	  */
	public void setA_Disposal_Revenue_Acct (int A_Disposal_Revenue_Acct);

	/** Get Disposal Revenue Acct	  */
	public int getA_Disposal_Revenue_Acct();

	public I_C_ValidCombination getA_Disposal_Revenue_A() throws RuntimeException;

    /** Column name C_AcctSchema_ID */
    public static final String COLUMNNAME_C_AcctSchema_ID = "C_AcctSchema_ID";

	/** Set Accounting Schema.
	  * Rules for accounting
	  */
	public void setC_AcctSchema_ID (int C_AcctSchema_ID);

	/** Get Accounting Schema.
	  * Rules for accounting
	  */
	public int getC_AcctSchema_ID();

	public org.compiere.model.I_C_AcctSchema getC_AcctSchema() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name FA_DefaultAccount_ID */
    public static final String COLUMNNAME_FA_DefaultAccount_ID = "FA_DefaultAccount_ID";

	/** Set FA_DefaultAccount	  */
	public void setFA_DefaultAccount_ID (int FA_DefaultAccount_ID);

	/** Get FA_DefaultAccount	  */
	public int getFA_DefaultAccount_ID();

    /** Column name FA_DefaultAccount_UU */
    public static final String COLUMNNAME_FA_DefaultAccount_UU = "FA_DefaultAccount_UU";

	/** Set FA_DefaultAccount_UU	  */
	public void setFA_DefaultAccount_UU (String FA_DefaultAccount_UU);

	/** Get FA_DefaultAccount_UU	  */
	public String getFA_DefaultAccount_UU();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name PostingType */
    public static final String COLUMNNAME_PostingType = "PostingType";

	/** Set Posting Type.
	  * The type of posted amount for the transaction
	  */
	public void setPostingType (String PostingType);

	/** Get Posting Type.
	  * The type of posted amount for the transaction
	  */
	public String getPostingType();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
