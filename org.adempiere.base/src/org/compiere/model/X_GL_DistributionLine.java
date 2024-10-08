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
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for GL_DistributionLine
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="GL_DistributionLine")
public class X_GL_DistributionLine extends PO implements I_GL_DistributionLine, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231222L;

    /** Standard Constructor */
    public X_GL_DistributionLine (Properties ctx, int GL_DistributionLine_ID, String trxName)
    {
      super (ctx, GL_DistributionLine_ID, trxName);
      /** if (GL_DistributionLine_ID == 0)
        {
			setGL_Distribution_ID (0);
			setGL_DistributionLine_ID (0);
			setLine (0);
// @SQL=SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM GL_DistributionLine WHERE GL_Distribution_ID=@GL_Distribution_ID@
			setOverwriteAcct (false);
			setOverwriteActivity (false);
			setOverwriteBPartner (false);
			setOverwriteCampaign (false);
			setOverwriteLocFrom (false);
			setOverwriteLocTo (false);
			setOverwriteOrg (false);
			setOverwriteOrgTrx (false);
			setOverwriteProduct (false);
			setOverwriteProject (false);
			setOverwriteSalesRegion (false);
			setOverwriteUser1 (false);
			setOverwriteUser2 (false);
			setPercent (Env.ZERO);
        } */
    }

    /** Standard Constructor */
    public X_GL_DistributionLine (Properties ctx, int GL_DistributionLine_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, GL_DistributionLine_ID, trxName, virtualColumns);
      /** if (GL_DistributionLine_ID == 0)
        {
			setGL_Distribution_ID (0);
			setGL_DistributionLine_ID (0);
			setLine (0);
// @SQL=SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM GL_DistributionLine WHERE GL_Distribution_ID=@GL_Distribution_ID@
			setOverwriteAcct (false);
			setOverwriteActivity (false);
			setOverwriteBPartner (false);
			setOverwriteCampaign (false);
			setOverwriteLocFrom (false);
			setOverwriteLocTo (false);
			setOverwriteOrg (false);
			setOverwriteOrgTrx (false);
			setOverwriteProduct (false);
			setOverwriteProject (false);
			setOverwriteSalesRegion (false);
			setOverwriteUser1 (false);
			setOverwriteUser2 (false);
			setPercent (Env.ZERO);
        } */
    }

    /** Standard Constructor */
    public X_GL_DistributionLine (Properties ctx, String GL_DistributionLine_UU, String trxName)
    {
      super (ctx, GL_DistributionLine_UU, trxName);
      /** if (GL_DistributionLine_UU == null)
        {
			setGL_Distribution_ID (0);
			setGL_DistributionLine_ID (0);
			setLine (0);
// @SQL=SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM GL_DistributionLine WHERE GL_Distribution_ID=@GL_Distribution_ID@
			setOverwriteAcct (false);
			setOverwriteActivity (false);
			setOverwriteBPartner (false);
			setOverwriteCampaign (false);
			setOverwriteLocFrom (false);
			setOverwriteLocTo (false);
			setOverwriteOrg (false);
			setOverwriteOrgTrx (false);
			setOverwriteProduct (false);
			setOverwriteProject (false);
			setOverwriteSalesRegion (false);
			setOverwriteUser1 (false);
			setOverwriteUser2 (false);
			setPercent (Env.ZERO);
        } */
    }

    /** Standard Constructor */
    public X_GL_DistributionLine (Properties ctx, String GL_DistributionLine_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, GL_DistributionLine_UU, trxName, virtualColumns);
      /** if (GL_DistributionLine_UU == null)
        {
			setGL_Distribution_ID (0);
			setGL_DistributionLine_ID (0);
			setLine (0);
// @SQL=SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM GL_DistributionLine WHERE GL_Distribution_ID=@GL_Distribution_ID@
			setOverwriteAcct (false);
			setOverwriteActivity (false);
			setOverwriteBPartner (false);
			setOverwriteCampaign (false);
			setOverwriteLocFrom (false);
			setOverwriteLocTo (false);
			setOverwriteOrg (false);
			setOverwriteOrgTrx (false);
			setOverwriteProduct (false);
			setOverwriteProject (false);
			setOverwriteSalesRegion (false);
			setOverwriteUser1 (false);
			setOverwriteUser2 (false);
			setPercent (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_GL_DistributionLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_GL_DistributionLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Account.
		@param Account_ID Account used
	*/
	public void setAccount_ID (int Account_ID)
	{
		if (Account_ID < 1)
			set_Value (COLUMNNAME_Account_ID, null);
		else
			set_Value (COLUMNNAME_Account_ID, Integer.valueOf(Account_ID));
	}

	/** Get Account.
		@return Account used
	  */
	public int getAccount_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Account_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Trx Organization.
		@param AD_OrgTrx_ID Performing or initiating organization
	*/
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID)
	{
		if (AD_OrgTrx_ID < 1)
			set_Value (COLUMNNAME_AD_OrgTrx_ID, null);
		else
			set_Value (COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
	}

	/** Get Trx Organization.
		@return Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_OrgTrx_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException
	{
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_ID)
			.getPO(getC_Activity_ID(), get_TrxName());
	}

	/** Set Activity.
		@param C_Activity_ID Business Activity
	*/
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1)
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException
	{
		return (org.compiere.model.I_C_Campaign)MTable.get(getCtx(), org.compiere.model.I_C_Campaign.Table_ID)
			.getPO(getC_Campaign_ID(), get_TrxName());
	}

	/** Set Campaign.
		@param C_Campaign_ID Marketing Campaign
	*/
	public void setC_Campaign_ID (int C_Campaign_ID)
	{
		if (C_Campaign_ID < 1)
			set_Value (COLUMNNAME_C_Campaign_ID, null);
		else
			set_Value (COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
	}

	/** Get Campaign.
		@return Marketing Campaign
	  */
	public int getC_Campaign_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Campaign_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Location getC_LocFrom() throws RuntimeException
	{
		return (org.compiere.model.I_C_Location)MTable.get(getCtx(), org.compiere.model.I_C_Location.Table_ID)
			.getPO(getC_LocFrom_ID(), get_TrxName());
	}

	/** Set Location From.
		@param C_LocFrom_ID Location that inventory was moved from
	*/
	public void setC_LocFrom_ID (int C_LocFrom_ID)
	{
		if (C_LocFrom_ID < 1)
			set_Value (COLUMNNAME_C_LocFrom_ID, null);
		else
			set_Value (COLUMNNAME_C_LocFrom_ID, Integer.valueOf(C_LocFrom_ID));
	}

	/** Get Location From.
		@return Location that inventory was moved from
	  */
	public int getC_LocFrom_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_LocFrom_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Location getC_LocTo() throws RuntimeException
	{
		return (org.compiere.model.I_C_Location)MTable.get(getCtx(), org.compiere.model.I_C_Location.Table_ID)
			.getPO(getC_LocTo_ID(), get_TrxName());
	}

	/** Set Location To.
		@param C_LocTo_ID Location that inventory was moved to
	*/
	public void setC_LocTo_ID (int C_LocTo_ID)
	{
		if (C_LocTo_ID < 1)
			set_Value (COLUMNNAME_C_LocTo_ID, null);
		else
			set_Value (COLUMNNAME_C_LocTo_ID, Integer.valueOf(C_LocTo_ID));
	}

	/** Get Location To.
		@return Location that inventory was moved to
	  */
	public int getC_LocTo_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_LocTo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
	{
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_ID)
			.getPO(getC_Project_ID(), get_TrxName());
	}

	/** Set Project.
		@param C_Project_ID Financial Project
	*/
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1)
			set_Value (COLUMNNAME_C_Project_ID, null);
		else
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_SalesRegion getC_SalesRegion() throws RuntimeException
	{
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_ID)
			.getPO(getC_SalesRegion_ID(), get_TrxName());
	}

	/** Set Sales Region.
		@param C_SalesRegion_ID Sales coverage region
	*/
	public void setC_SalesRegion_ID (int C_SalesRegion_ID)
	{
		if (C_SalesRegion_ID < 1)
			set_Value (COLUMNNAME_C_SalesRegion_ID, null);
		else
			set_Value (COLUMNNAME_C_SalesRegion_ID, Integer.valueOf(C_SalesRegion_ID));
	}

	/** Get Sales Region.
		@return Sales coverage region
	  */
	public int getC_SalesRegion_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegion_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	public org.compiere.model.I_GL_Distribution getGL_Distribution() throws RuntimeException
	{
		return (org.compiere.model.I_GL_Distribution)MTable.get(getCtx(), org.compiere.model.I_GL_Distribution.Table_ID)
			.getPO(getGL_Distribution_ID(), get_TrxName());
	}

	/** Set GL Distribution.
		@param GL_Distribution_ID General Ledger Distribution
	*/
	public void setGL_Distribution_ID (int GL_Distribution_ID)
	{
		if (GL_Distribution_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GL_Distribution_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GL_Distribution_ID, Integer.valueOf(GL_Distribution_ID));
	}

	/** Get GL Distribution.
		@return General Ledger Distribution
	  */
	public int getGL_Distribution_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_Distribution_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set GL Distribution Line.
		@param GL_DistributionLine_ID General Ledger Distribution Line
	*/
	public void setGL_DistributionLine_ID (int GL_DistributionLine_ID)
	{
		if (GL_DistributionLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GL_DistributionLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GL_DistributionLine_ID, Integer.valueOf(GL_DistributionLine_ID));
	}

	/** Get GL Distribution Line.
		@return General Ledger Distribution Line
	  */
	public int getGL_DistributionLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_DistributionLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set GL_DistributionLine_UU.
		@param GL_DistributionLine_UU GL_DistributionLine_UU
	*/
	public void setGL_DistributionLine_UU (String GL_DistributionLine_UU)
	{
		set_Value (COLUMNNAME_GL_DistributionLine_UU, GL_DistributionLine_UU);
	}

	/** Get GL_DistributionLine_UU.
		@return GL_DistributionLine_UU	  */
	public String getGL_DistributionLine_UU()
	{
		return (String)get_Value(COLUMNNAME_GL_DistributionLine_UU);
	}

	/** Set Line No.
		@param Line Unique line for this document
	*/
	public void setLine (int Line)
	{
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair()
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLine()));
    }

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product_ID(), get_TrxName());
	}

	/** Set Product.
		@param M_Product_ID Product, Service, Item
	*/
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1)
			set_Value (COLUMNNAME_M_Product_ID, null);
		else
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Organization.
		@param Org_ID Organizational entity within tenant
	*/
	public void setOrg_ID (int Org_ID)
	{
		if (Org_ID < 1)
			set_Value (COLUMNNAME_Org_ID, null);
		else
			set_Value (COLUMNNAME_Org_ID, Integer.valueOf(Org_ID));
	}

	/** Get Organization.
		@return Organizational entity within tenant
	  */
	public int getOrg_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Overwrite Account.
		@param OverwriteAcct Overwrite the account segment Account with the value specified
	*/
	public void setOverwriteAcct (boolean OverwriteAcct)
	{
		set_Value (COLUMNNAME_OverwriteAcct, Boolean.valueOf(OverwriteAcct));
	}

	/** Get Overwrite Account.
		@return Overwrite the account segment Account with the value specified
	  */
	public boolean isOverwriteAcct()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteAcct);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Activity.
		@param OverwriteActivity Overwrite the account segment Activity with the value specified
	*/
	public void setOverwriteActivity (boolean OverwriteActivity)
	{
		set_Value (COLUMNNAME_OverwriteActivity, Boolean.valueOf(OverwriteActivity));
	}

	/** Get Overwrite Activity.
		@return Overwrite the account segment Activity with the value specified
	  */
	public boolean isOverwriteActivity()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteActivity);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Bus.Partner.
		@param OverwriteBPartner Overwrite the account segment Business Partner with the value specified
	*/
	public void setOverwriteBPartner (boolean OverwriteBPartner)
	{
		set_Value (COLUMNNAME_OverwriteBPartner, Boolean.valueOf(OverwriteBPartner));
	}

	/** Get Overwrite Bus.Partner.
		@return Overwrite the account segment Business Partner with the value specified
	  */
	public boolean isOverwriteBPartner()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteBPartner);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Campaign.
		@param OverwriteCampaign Overwrite the account segment Campaign with the value specified
	*/
	public void setOverwriteCampaign (boolean OverwriteCampaign)
	{
		set_Value (COLUMNNAME_OverwriteCampaign, Boolean.valueOf(OverwriteCampaign));
	}

	/** Get Overwrite Campaign.
		@return Overwrite the account segment Campaign with the value specified
	  */
	public boolean isOverwriteCampaign()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteCampaign);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Location From.
		@param OverwriteLocFrom Overwrite the account segment Location From with the value specified
	*/
	public void setOverwriteLocFrom (boolean OverwriteLocFrom)
	{
		set_Value (COLUMNNAME_OverwriteLocFrom, Boolean.valueOf(OverwriteLocFrom));
	}

	/** Get Overwrite Location From.
		@return Overwrite the account segment Location From with the value specified
	  */
	public boolean isOverwriteLocFrom()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteLocFrom);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Location To.
		@param OverwriteLocTo Overwrite the account segment Location From with the value specified
	*/
	public void setOverwriteLocTo (boolean OverwriteLocTo)
	{
		set_Value (COLUMNNAME_OverwriteLocTo, Boolean.valueOf(OverwriteLocTo));
	}

	/** Get Overwrite Location To.
		@return Overwrite the account segment Location From with the value specified
	  */
	public boolean isOverwriteLocTo()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteLocTo);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Organization.
		@param OverwriteOrg Overwrite the account segment Organization with the value specified
	*/
	public void setOverwriteOrg (boolean OverwriteOrg)
	{
		set_Value (COLUMNNAME_OverwriteOrg, Boolean.valueOf(OverwriteOrg));
	}

	/** Get Overwrite Organization.
		@return Overwrite the account segment Organization with the value specified
	  */
	public boolean isOverwriteOrg()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteOrg);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Trx Organization.
		@param OverwriteOrgTrx Overwrite the account segment Transaction Organization with the value specified
	*/
	public void setOverwriteOrgTrx (boolean OverwriteOrgTrx)
	{
		set_Value (COLUMNNAME_OverwriteOrgTrx, Boolean.valueOf(OverwriteOrgTrx));
	}

	/** Get Overwrite Trx Organization.
		@return Overwrite the account segment Transaction Organization with the value specified
	  */
	public boolean isOverwriteOrgTrx()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteOrgTrx);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Product.
		@param OverwriteProduct Overwrite the account segment Product with the value specified
	*/
	public void setOverwriteProduct (boolean OverwriteProduct)
	{
		set_Value (COLUMNNAME_OverwriteProduct, Boolean.valueOf(OverwriteProduct));
	}

	/** Get Overwrite Product.
		@return Overwrite the account segment Product with the value specified
	  */
	public boolean isOverwriteProduct()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteProduct);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Project.
		@param OverwriteProject Overwrite the account segment Project with the value specified
	*/
	public void setOverwriteProject (boolean OverwriteProject)
	{
		set_Value (COLUMNNAME_OverwriteProject, Boolean.valueOf(OverwriteProject));
	}

	/** Get Overwrite Project.
		@return Overwrite the account segment Project with the value specified
	  */
	public boolean isOverwriteProject()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteProject);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite Sales Region.
		@param OverwriteSalesRegion Overwrite the account segment Sales Region with the value specified
	*/
	public void setOverwriteSalesRegion (boolean OverwriteSalesRegion)
	{
		set_Value (COLUMNNAME_OverwriteSalesRegion, Boolean.valueOf(OverwriteSalesRegion));
	}

	/** Get Overwrite Sales Region.
		@return Overwrite the account segment Sales Region with the value specified
	  */
	public boolean isOverwriteSalesRegion()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteSalesRegion);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite User1.
		@param OverwriteUser1 Overwrite the account segment User 1 with the value specified
	*/
	public void setOverwriteUser1 (boolean OverwriteUser1)
	{
		set_Value (COLUMNNAME_OverwriteUser1, Boolean.valueOf(OverwriteUser1));
	}

	/** Get Overwrite User1.
		@return Overwrite the account segment User 1 with the value specified
	  */
	public boolean isOverwriteUser1()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser1);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite User2.
		@param OverwriteUser2 Overwrite the account segment User 2 with the value specified
	*/
	public void setOverwriteUser2 (boolean OverwriteUser2)
	{
		set_Value (COLUMNNAME_OverwriteUser2, Boolean.valueOf(OverwriteUser2));
	}

	/** Get Overwrite User2.
		@return Overwrite the account segment User 2 with the value specified
	  */
	public boolean isOverwriteUser2()
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser2);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Overwrite User3.
	@param OverwriteUser3 
	Overwrite the account segment User 3 with the value specified
	  */
	public void setOverwriteUser3 (boolean OverwriteUser3)
	{
		set_Value (COLUMNNAME_OverwriteUser3, Boolean.valueOf(OverwriteUser3));
	}
	
	/** Get Overwrite User3.
		@return Overwrite the account segment User 3 with the value specified
	  */
	public boolean isOverwriteUser3 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser3);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Overwrite User4.
		@param OverwriteUser4 
		Overwrite the account segment User 4 with the value specified
	  */
	public void setOverwriteUser4 (boolean OverwriteUser4)
	{
		set_Value (COLUMNNAME_OverwriteUser4, Boolean.valueOf(OverwriteUser4));
	}
	
	/** Get Overwrite User4.
		@return Overwrite the account segment User 4 with the value specified
	  */
	public boolean isOverwriteUser4 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser4);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Overwrite User5.
		@param OverwriteUser5 
		Overwrite the account segment User 5 with the value specified
	  */
	public void setOverwriteUser5 (boolean OverwriteUser5)
	{
		set_Value (COLUMNNAME_OverwriteUser5, Boolean.valueOf(OverwriteUser5));
	}
	
	/** Get Overwrite User5.
		@return Overwrite the account segment User 5 with the value specified
	  */
	public boolean isOverwriteUser5 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser5);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Overwrite User6.
		@param OverwriteUser6 
		Overwrite the account segment User 6 with the value specified
	  */
	public void setOverwriteUser6 (boolean OverwriteUser6)
	{
		set_Value (COLUMNNAME_OverwriteUser6, Boolean.valueOf(OverwriteUser6));
	}
	
	/** Get Overwrite User6.
		@return Overwrite the account segment User 6 with the value specified
	  */
	public boolean isOverwriteUser6 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser6);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Overwrite User7.
		@param OverwriteUser7 
		Overwrite the account segment User 7 with the value specified
	  */
	public void setOverwriteUser7 (boolean OverwriteUser7)
	{
		set_Value (COLUMNNAME_OverwriteUser7, Boolean.valueOf(OverwriteUser7));
	}
	
	/** Get Overwrite User7.
		@return Overwrite the account segment User 7 with the value specified
	  */
	public boolean isOverwriteUser7 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser7);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Overwrite User8.
		@param OverwriteUser8 
		Overwrite the account segment User 8 with the value specified
	  */
	public void setOverwriteUser8 (boolean OverwriteUser8)
	{
		set_Value (COLUMNNAME_OverwriteUser8, Boolean.valueOf(OverwriteUser8));
	}
	
	/** Get Overwrite User8.
		@return Overwrite the account segment User 8 with the value specified
	  */
	public boolean isOverwriteUser8 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser8);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Overwrite User9.
		@param OverwriteUser9 
		Overwrite the account segment User 9 with the value specified
	  */
	public void setOverwriteUser9 (boolean OverwriteUser9)
	{
		set_Value (COLUMNNAME_OverwriteUser9, Boolean.valueOf(OverwriteUser9));
	}
	
	/** Get Overwrite User9.
		@return Overwrite the account segment User 9 with the value specified
	  */
	public boolean isOverwriteUser9 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser9);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Overwrite User10.
	@param OverwriteUser10 
	Overwrite the account segment User 10 with the value specified
	  */
	public void setOverwriteUser10 (boolean OverwriteUser10)
	{
		set_Value (COLUMNNAME_OverwriteUser10, Boolean.valueOf(OverwriteUser10));
	}
	
	/** Get Overwrite User10.
		@return Overwrite the account segment User 10 with the value specified
	  */
	public boolean isOverwriteUser10 () 
	{
		Object oo = get_Value(COLUMNNAME_OverwriteUser10);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Percent.
		@param Percent Percentage
	*/
	public void setPercent (BigDecimal Percent)
	{
		set_Value (COLUMNNAME_Percent, Percent);
	}

	/** Get Percent.
		@return Percentage
	  */
	public BigDecimal getPercent()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Percent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException
	{
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_ID)
			.getPO(getUser1_ID(), get_TrxName());
	}

	/** Set User Element List 1.
		@param User1_ID User defined list element #1
	*/
	public void setUser1_ID (int User1_ID)
	{
		if (User1_ID < 1)
			set_Value (COLUMNNAME_User1_ID, null);
		else
			set_Value (COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
	}

	/** Get User Element List 1.
		@return User defined list element #1
	  */
	public int getUser1_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser2() throws RuntimeException
	{
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_ID)
			.getPO(getUser2_ID(), get_TrxName());
	}

	/** Set User Element List 2.
		@param User2_ID User defined list element #2
	*/
	public void setUser2_ID (int User2_ID)
	{
		if (User2_ID < 1)
			set_Value (COLUMNNAME_User2_ID, null);
		else
			set_Value (COLUMNNAME_User2_ID, Integer.valueOf(User2_ID));
	}

	/** Get User Element List 2.
		@return User defined list element #2
	  */
	public int getUser2_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	public org.compiere.model.I_C_ElementValue getUser3() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser3_ID(), get_TrxName());	}

	/** Set User Element List 3.
		@param User3_ID 
		User defined list element #3
	  */
	public void setUser3_ID (int User3_ID)
	{
		if (User3_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User3_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User3_ID, Integer.valueOf(User3_ID));
	}

	/** Get User Element List 3.
		@return User defined list element #3
	  */
	public int getUser3_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User3_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser4() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser4_ID(), get_TrxName());	}

	/** Set User Element List 4.
		@param User4_ID 
		User defined list element #4
	  */
	public void setUser4_ID (int User4_ID)
	{
		if (User4_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User4_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User4_ID, Integer.valueOf(User4_ID));
	}

	/** Get User Element List 4.
		@return User defined list element #4
	  */
	public int getUser4_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User4_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser5() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser5_ID(), get_TrxName());	}

	/** Set User Element List 5.
		@param User5_ID 
		User defined list element #5
	  */
	public void setUser5_ID (int User5_ID)
	{
		if (User5_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User5_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User5_ID, Integer.valueOf(User5_ID));
	}

	/** Get User Element List 5.
		@return User defined list element #5
	  */
	public int getUser5_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User5_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser6() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser6_ID(), get_TrxName());	}

	/** Set User Element List 6.
		@param User6_ID 
		User defined list element #6
	  */
	public void setUser6_ID (int User6_ID)
	{
		if (User6_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User6_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User6_ID, Integer.valueOf(User6_ID));
	}

	/** Get User Element List 6.
		@return User defined list element #6
	  */
	public int getUser6_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User6_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser7() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser7_ID(), get_TrxName());	}

	/** Set User Element List 7.
		@param User7_ID 
		User defined list element #7
	  */
	public void setUser7_ID (int User7_ID)
	{
		if (User7_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User7_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User7_ID, Integer.valueOf(User7_ID));
	}

	/** Get User Element List 7.
		@return User defined list element #7
	  */
	public int getUser7_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User7_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser8() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser8_ID(), get_TrxName());	}

	/** Set User Element List 8.
		@param User8_ID 
		User defined list element #8
	  */
	public void setUser8_ID (int User8_ID)
	{
		if (User8_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User8_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User8_ID, Integer.valueOf(User8_ID));
	}

	/** Get User Element List 8.
		@return User defined list element #8
	  */
	public int getUser8_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User8_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser9() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser9_ID(), get_TrxName());	}

	/** Set User Element List 9.
		@param User9_ID 
		User defined list element #9
	  */
	public void setUser9_ID (int User9_ID)
	{
		if (User9_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User9_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User9_ID, Integer.valueOf(User9_ID));
	}

	/** Get User Element List 9.
		@return User defined list element #9
	  */
	public int getUser9_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User9_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	public org.compiere.model.I_C_ElementValue getUser10() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser10_ID(), get_TrxName());	}

	/** Set User Element List 10.
		@param User10_ID 
		User defined list element #10
	  */
	public void setUser10_ID (int User10_ID)
	{
		if (User10_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_User10_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_User10_ID, Integer.valueOf(User10_ID));
	}

	/** Get User Element List 10.
		@return User defined list element #10
	  */
	public int getUser10_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User10_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}