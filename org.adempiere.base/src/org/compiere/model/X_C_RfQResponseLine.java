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
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.util.Env;

/** Generated Model for C_RfQResponseLine
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="C_RfQResponseLine")
public class X_C_RfQResponseLine extends PO implements I_C_RfQResponseLine, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231222L;

    /** Standard Constructor */
    public X_C_RfQResponseLine (Properties ctx, int C_RfQResponseLine_ID, String trxName)
    {
      super (ctx, C_RfQResponseLine_ID, trxName);
      /** if (C_RfQResponseLine_ID == 0)
        {
			setC_RfQLine_ID (0);
			setC_RfQResponse_ID (0);
			setC_RfQResponseLine_ID (0);
			setIsSelectedWinner (false);
			setIsSelfService (false);
        } */
    }

    /** Standard Constructor */
    public X_C_RfQResponseLine (Properties ctx, int C_RfQResponseLine_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, C_RfQResponseLine_ID, trxName, virtualColumns);
      /** if (C_RfQResponseLine_ID == 0)
        {
			setC_RfQLine_ID (0);
			setC_RfQResponse_ID (0);
			setC_RfQResponseLine_ID (0);
			setIsSelectedWinner (false);
			setIsSelfService (false);
        } */
    }

    /** Standard Constructor */
    public X_C_RfQResponseLine (Properties ctx, String C_RfQResponseLine_UU, String trxName)
    {
      super (ctx, C_RfQResponseLine_UU, trxName);
      /** if (C_RfQResponseLine_UU == null)
        {
			setC_RfQLine_ID (0);
			setC_RfQResponse_ID (0);
			setC_RfQResponseLine_ID (0);
			setIsSelectedWinner (false);
			setIsSelfService (false);
        } */
    }

    /** Standard Constructor */
    public X_C_RfQResponseLine (Properties ctx, String C_RfQResponseLine_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, C_RfQResponseLine_UU, trxName, virtualColumns);
      /** if (C_RfQResponseLine_UU == null)
        {
			setC_RfQLine_ID (0);
			setC_RfQResponse_ID (0);
			setC_RfQResponseLine_ID (0);
			setIsSelectedWinner (false);
			setIsSelfService (false);
        } */
    }

    /** Load Constructor */
    public X_C_RfQResponseLine (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org
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
      StringBuilder sb = new StringBuilder ("X_C_RfQResponseLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_RfQLine getC_RfQLine() throws RuntimeException
	{
		return (org.compiere.model.I_C_RfQLine)MTable.get(getCtx(), org.compiere.model.I_C_RfQLine.Table_ID)
			.getPO(getC_RfQLine_ID(), get_TrxName());
	}

	/** Set RfQ Line.
		@param C_RfQLine_ID Request for Quotation Line
	*/
	public void setC_RfQLine_ID (int C_RfQLine_ID)
	{
		if (C_RfQLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_RfQLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_RfQLine_ID, Integer.valueOf(C_RfQLine_ID));
	}

	/** Get RfQ Line.
		@return Request for Quotation Line
	  */
	public int getC_RfQLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_RfQLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_RfQResponse getC_RfQResponse() throws RuntimeException
	{
		return (org.compiere.model.I_C_RfQResponse)MTable.get(getCtx(), org.compiere.model.I_C_RfQResponse.Table_ID)
			.getPO(getC_RfQResponse_ID(), get_TrxName());
	}

	/** Set RfQ Response.
		@param C_RfQResponse_ID Request for Quotation Response from a potential Vendor
	*/
	public void setC_RfQResponse_ID (int C_RfQResponse_ID)
	{
		if (C_RfQResponse_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_RfQResponse_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_RfQResponse_ID, Integer.valueOf(C_RfQResponse_ID));
	}

	/** Get RfQ Response.
		@return Request for Quotation Response from a potential Vendor
	  */
	public int getC_RfQResponse_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_RfQResponse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set RfQ Response Line.
		@param C_RfQResponseLine_ID Request for Quotation Response Line
	*/
	public void setC_RfQResponseLine_ID (int C_RfQResponseLine_ID)
	{
		if (C_RfQResponseLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_RfQResponseLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_RfQResponseLine_ID, Integer.valueOf(C_RfQResponseLine_ID));
	}

	/** Get RfQ Response Line.
		@return Request for Quotation Response Line
	  */
	public int getC_RfQResponseLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_RfQResponseLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_RfQResponseLine_UU.
		@param C_RfQResponseLine_UU C_RfQResponseLine_UU
	*/
	public void setC_RfQResponseLine_UU (String C_RfQResponseLine_UU)
	{
		set_Value (COLUMNNAME_C_RfQResponseLine_UU, C_RfQResponseLine_UU);
	}

	/** Get C_RfQResponseLine_UU.
		@return C_RfQResponseLine_UU	  */
	public String getC_RfQResponseLine_UU()
	{
		return (String)get_Value(COLUMNNAME_C_RfQResponseLine_UU);
	}

	/** Set Work Complete.
		@param DateWorkComplete Date when work is (planned to be) complete
	*/
	public void setDateWorkComplete (Timestamp DateWorkComplete)
	{
		set_Value (COLUMNNAME_DateWorkComplete, DateWorkComplete);
	}

	/** Get Work Complete.
		@return Date when work is (planned to be) complete
	  */
	public Timestamp getDateWorkComplete()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateWorkComplete);
	}

	/** Set Work Start.
		@param DateWorkStart Date when work is (planned to be) started
	*/
	public void setDateWorkStart (Timestamp DateWorkStart)
	{
		set_Value (COLUMNNAME_DateWorkStart, DateWorkStart);
	}

	/** Get Work Start.
		@return Date when work is (planned to be) started
	  */
	public Timestamp getDateWorkStart()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateWorkStart);
	}

	/** Set Delivery Days.
		@param DeliveryDays Number of Days (planned) until Delivery
	*/
	public void setDeliveryDays (int DeliveryDays)
	{
		set_Value (COLUMNNAME_DeliveryDays, Integer.valueOf(DeliveryDays));
	}

	/** Get Delivery Days.
		@return Number of Days (planned) until Delivery
	  */
	public int getDeliveryDays()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DeliveryDays);
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

	/** Set Comment/Help.
		@param Help Comment or Hint
	*/
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp()
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Selected Winner.
		@param IsSelectedWinner The response is the selected winner
	*/
	public void setIsSelectedWinner (boolean IsSelectedWinner)
	{
		set_Value (COLUMNNAME_IsSelectedWinner, Boolean.valueOf(IsSelectedWinner));
	}

	/** Get Selected Winner.
		@return The response is the selected winner
	  */
	public boolean isSelectedWinner()
	{
		Object oo = get_Value(COLUMNNAME_IsSelectedWinner);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Self-Service.
		@param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
	*/
	public void setIsSelfService (boolean IsSelfService)
	{
		set_Value (COLUMNNAME_IsSelfService, Boolean.valueOf(IsSelfService));
	}

	/** Get Self-Service.
		@return This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public boolean isSelfService()
	{
		Object oo = get_Value(COLUMNNAME_IsSelfService);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Base Price.
	@param BasePrice Base Price	  */
	public void setBasePrice (BigDecimal BasePrice)
	{
		set_Value (COLUMNNAME_BasePrice, BasePrice);
	}
	
	/** Get Base Price.
		@return Base Price	  */
	public BigDecimal getBasePrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BasePrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
	{
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}
	
	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_Value (COLUMNNAME_C_Charge_ID, null);
		else 
			set_Value (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}
	
	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Set Faktor Kondisi.
	@param FaktorKondisi Faktor Kondisi	  */
	public void setFaktorKondisi (BigDecimal FaktorKondisi)
	{
		set_Value (COLUMNNAME_FaktorKondisi, FaktorKondisi);
	}
	
	/** Get Faktor Kondisi.
		@return Faktor Kondisi	  */
	public BigDecimal getFaktorKondisi () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FaktorKondisi);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Set Description Only.
	@param IsDescription 
	if true, the line is just description and no transaction
	 */
	public void setIsDescription (boolean IsDescription)
	{
		set_ValueNoCheck (COLUMNNAME_IsDescription, Boolean.valueOf(IsDescription));
	}
	
	/** Get Description Only.
		@return if true, the line is just description and no transaction
	  */
	public boolean isDescription () 
	{
		Object oo = get_Value(COLUMNNAME_IsDescription);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Line.
	@param LineNo 
	Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}
	
	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}	
	
	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
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
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Price.
		@param Price 
		Price
	  */
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Unit Price.
		@param PriceActual 
		Actual Price 
	  */
	public void setPriceActual (BigDecimal PriceActual)
	{
		set_Value (COLUMNNAME_PriceActual, PriceActual);
	}

	/** Get Unit Price.
		@return Actual Price 
	  */
	public BigDecimal getPriceActual () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceActual);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Price (Faktor Kondisi).
		@param PriceKondisi Price (Faktor Kondisi)	  */
	public void setPriceKondisi (BigDecimal PriceKondisi)
	{
		set_Value (COLUMNNAME_PriceKondisi, PriceKondisi);
	}

	/** Get Price (Faktor Kondisi).
		@return Price (Faktor Kondisi)	  */
	public BigDecimal getPriceKondisi () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceKondisi);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Standard Price.
		@param PriceStd 
		Standard Price
	  */
	public void setPriceStd (BigDecimal PriceStd)
	{
		set_Value (COLUMNNAME_PriceStd, PriceStd);
	}

	/** Get Standard Price.
		@return Standard Price
	  */
	public BigDecimal getPriceStd () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceStd);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Set Quantity.
	@param Qty 
	Quantity
	  */
	public void setQty (BigDecimal Qty)
	{
		set_Value (COLUMNNAME_Qty, Qty);
	}
	
	/** Get Quantity.
		@return Quantity
	  */
	public BigDecimal getQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

}