/***********************************************************************
 * This file is part of iDempiere ERP Open Source                      *
 * http://www.idempiere.org                                            *
 *                                                                     *
 * Copyright (C) Contributors                                          *
 *                                                                     *
 * This program is free software; you can redistribute it and/or       *
 * modify it under the terms of the GNU General Public License         *
 * as published by the Free Software Foundation; either version 2      *
 * of the License, or (at your option) any later version.              *
 *                                                                     *
 * This program is distributed in the hope that it will be useful,     *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
 * GNU General Public License for more details.                        *
 *                                                                     *
 * You should have received a copy of the GNU General Public License   *
 * along with this program; if not, write to the Free Software         *
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
 * MA 02110-1301, USA.                                                 *
 *                                                                     *
 * Contributors:                                                       *
 * - hengsin                         								   *
 **********************************************************************/
package org.adempiere.base.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.annotation.Callout;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduct;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.MUOM;
import org.compiere.model.MUOMConversion;
import org.compiere.util.Env;

/**
 * 
 * @author hengsin
 *
 */
@Callout(tableName = {MRequisition.Table_Name, MRequisitionLine.Table_Name}, 
	columnName = {MRequisition.COLUMNNAME_M_PriceList_ID, MRequisitionLine.COLUMNNAME_C_UOM_ID, MRequisitionLine.COLUMNNAME_Qty})
public class TCS_CalloutRequisition extends CalloutEngine implements IColumnCallout {

	private final Map<String, IColumnCallout> calloutMap = new HashMap<String, IColumnCallout>();
	
		{
		calloutMap.put(MRequisition.COLUMNNAME_M_PriceList_ID, 
				(ctx, windowNo, mTab, mField, value, oldValue) -> priceList(ctx, windowNo, mTab, mField, value));
		calloutMap.put(MRequisitionLine.COLUMNNAME_C_UOM_ID, 
				(ctx, windowNo, mTab, mField, value, oldValue) -> qty(ctx, windowNo, mTab, mField, value));
		calloutMap.put(MRequisitionLine.COLUMNNAME_Qty, 
				(ctx, windowNo, mTab, mField, value, oldValue) -> qty(ctx, windowNo, mTab, mField, value));
		}
	
	@Override
	public String start(Properties ctx, int windowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		IColumnCallout callout = calloutMap.get(mField.getColumnName());
		return callout != null ? callout.start(ctx, windowNo, mTab, mField, value, oldValue) : "";
	}
	
	/**
	 * This is the code from CalloutRequisition in Taowi 1.0 / iDempiere Core V3.
	 * This is new method with the name priceList.
	 * The objective is to set Currency based on PriceList
	 * @trigger: M_PriceList_ID
	 * @set: C_Currency_ID
	 * @note: C_Currency_ID(migration script -> this is custom column)
	 * @param ctx
	 * @param WindowNo
	 * @param mTab
	 * @param mField
	 * @param value
	 * @return
	 */
	public String priceList(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		if (isCalloutActive() || value == null)
			return "";
		
		if (mField.getColumnName().equals(MRequisition.COLUMNNAME_M_PriceList_ID))
		{
			int priceListID = (Integer) mTab.getValue(MRequisition.COLUMNNAME_M_PriceList_ID);
			if (priceListID > 0) {
				MPriceList pl = MPriceList.get(Env.getCtx(), priceListID, null);
				mTab.setValue(MRequisition.COLUMNNAME_C_Currency_ID, pl.getC_Currency_ID());
			}
		}
		return "";
	}
	
	/**
	 * This is the code from CalloutRequisition in Taowi 1.0 / iDempiere Core V3.
	 * This is new method with the name qty.
	 * The objective is to support MultiUOM in RequisitionLine
	 * This callout begins with get the essential needs, such as Product.
	 * If product is not filled, then QtyRequired will be filled by Qty.
	 * If UOM changed, then UOM will be the C_UOM_To_ID.
	 * Then, Qty will be revalidate for the Scale and Precision based on C_UOM_To_ID.
	 * Then, the UOM Conversion method applied for the Product, C_UOM_To_ID, and for Qty and saved to the variable QtyRequired.
	 * Then, if the QtyRequired and Qty are same then there is no conversion, but still QtyRequired will be filled with this QtyRequired.
	 * If Qty changed, it will do the same logic like if UOM changed.
	 * @trigger: C_UOM_ID, Qty
	 * @set: QtyRequired
	 * @note: QtyRequired(migration script -> this is custom column)
	 * @param ctx
	 * @param WindowNo
	 * @param mTab
	 * @param mField
	 * @param value
	 * @return
	 */
	public String qty (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		if (isCalloutActive() || value == null)
			return "";
		
		int M_Product_ID = Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "M_Product_ID");
		BigDecimal qtyRequired = Env.ZERO;
		BigDecimal qty;

		//	No Product
		if (M_Product_ID == 0)
		{
			qty = (BigDecimal)mTab.getValue("Qty");
			qtyRequired = qty;
			mTab.setValue(MRequisitionLine.COLUMNNAME_QtyRequired, qtyRequired);
		}
		
		//	UOM Changed - convert from Entered -> Product
		else if (mField.getColumnName().equals("C_UOM_ID"))
		{
			//qty conversion
			int C_UOM_To_ID = ((Integer)value).intValue();
			qty = (BigDecimal)mTab.getValue("Qty");
			BigDecimal qty1 = qty.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), RoundingMode.HALF_UP);
			if (qty.compareTo(qty1) != 0)
			{
				if (log.isLoggable(Level.FINE)) log.fine("Corrected Qty Scale UOM=" + C_UOM_To_ID
					+ "; Qty=" + qty + "->" + qty1);
				qty = qty1;
				mTab.setValue(MRequisitionLine.COLUMNNAME_Qty, qty);
			}
			qtyRequired = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, qty);
			if (qtyRequired == null)
				qtyRequired = qty;
			
			mTab.setValue(MRequisitionLine.COLUMNNAME_QtyRequired, qtyRequired);
			
			//set conversion context variable
			boolean conversion = qty.compareTo(qtyRequired) != 0;
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");	
		}
		
		//	QtyEntered changed - calculate QtyOrdered
		else if (mField.getColumnName().equals("Qty"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "C_UOM_ID");
			qty = (BigDecimal)value;
			BigDecimal qty1 = qty.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), RoundingMode.HALF_UP);
			if (qty.compareTo(qty1) != 0)
			{
				if (log.isLoggable(Level.FINE)) log.fine("Corrected QtyEntered Scale UOM=" + C_UOM_To_ID
					+ "; QtyEntered=" + qty + "->" + qty1);
				qty = qty1;
				mTab.setValue(MRequisitionLine.COLUMNNAME_Qty, qty);
			}
			qtyRequired = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, qty);
			if (qtyRequired == null)
				qtyRequired = qty;
			boolean conversion = qty.compareTo(qtyRequired) != 0;
			if (log.isLoggable(Level.FINE)) log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyEntered=" + qty
				+ " -> " + conversion
				+ " QtyOrdered=" + qtyRequired);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue(MRequisitionLine.COLUMNNAME_QtyRequired, qtyRequired);
		}
		
		//	QtyOrdered changed - calculate QtyEntered (should not happen)
		else if (mField.getColumnName().equals("QtyRequired"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "C_UOM_ID");
			qtyRequired = (BigDecimal)value;
			int precision = MProduct.get(ctx, M_Product_ID).getUOMPrecision();
			BigDecimal qtyRequired1 = qtyRequired.setScale(precision, RoundingMode.HALF_UP);
			if (qtyRequired.compareTo(qtyRequired1) != 0)
			{
				if (log.isLoggable(Level.FINE)) log.fine("Corrected QtyRequired Scale "
					+ qtyRequired + "->" + qtyRequired1);
				qtyRequired = qtyRequired1;
				mTab.setValue(MRequisitionLine.COLUMNNAME_QtyRequired, qtyRequired);
			}
			qty = MUOMConversion.convertProductTo (ctx, M_Product_ID,
				C_UOM_To_ID, qtyRequired);
			if (qty == null)
				qty = qtyRequired;
			boolean conversion = qtyRequired.compareTo(qty) != 0;
			if (log.isLoggable(Level.FINE)) log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyRequired=" + qtyRequired
				+ " -> " + conversion
				+ " QtyRequired=" + qty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue(MRequisitionLine.COLUMNNAME_Qty, qty);
		}
		else
		{
			qtyRequired = (BigDecimal)mTab.getValue("Qty");
		}

		//
		return "";
	}	//	qty
}
