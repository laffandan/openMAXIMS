//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.patientprocedures;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.PatientProcedures.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.PatientProcedures domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbLateralityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbLaterality().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRB existingInstance = (ims.core.vo.lookups.LateralityLRB)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLateralityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LateralityLRB)
		{
			ims.core.vo.lookups.LateralityLRB instance = (ims.core.vo.lookups.LateralityLRB)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLateralityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRB existingInstance = (ims.core.vo.lookups.LateralityLRB)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbLaterality().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLateralityLookup()
	{
		this.form.cmbLaterality().clear();
		ims.core.vo.lookups.LateralityLRBCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLateralityLRB(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbLaterality().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLateralityLookupValue(int id)
	{
		ims.core.vo.lookups.LateralityLRB instance = ims.core.vo.lookups.LookupHelper.getLateralityLRBInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbLaterality().setValue(instance);
	}
	protected final void defaultcmbLateralityLookupValue()
	{
		this.form.cmbLaterality().setValue((ims.core.vo.lookups.LateralityLRB)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LateralityLRB.class, engine.getFormName().getID(), ims.core.vo.lookups.LateralityLRB.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.pdtProcedure().setValue(null);
		this.form.tmeProcedure().setValue(null);
		this.form.cmbLaterality().setValue(null);
		this.form.chkSignifProc().setValue(false);
		this.form.txtNotes().setValue("");
	}
	protected void populateScreenFromData(ims.core.vo.PatientProcedureVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.pdtProcedure().setValue(value.getProcDateIsNotNull() ? value.getProcDate() : null);
		this.form.tmeProcedure().setValue(value.getProcTimeIsNotNull() ? value.getProcTime() : null);
		this.form.cmbLaterality().setValue(value.getProcLateralityIsNotNull() ? value.getProcLaterality() : null);
		if(value.getSignifProcIsNotNull())
			this.form.chkSignifProc().setValue(value.getSignifProc().booleanValue());
		this.form.txtNotes().setValue(value.getNotesIsNotNull() ? value.getNotes(): null);
	}
	protected ims.core.vo.PatientProcedureVo populateDataFromScreen(ims.core.vo.PatientProcedureVo value)
	{
		if(value == null)
			value = new ims.core.vo.PatientProcedureVo();

		value.setProcDate(this.form.pdtProcedure().getValue());
		value.setProcTime(this.form.tmeProcedure().getValue());
		value.setProcLaterality(this.form.cmbLaterality().getValue());
		value.setSignifProc(new Boolean(this.form.chkSignifProc().getValue()));
		value.setNotes(this.form.txtNotes().getValue());

		return value;
	}
	protected ims.core.vo.PatientProcedureVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.core.vo.PatientProcedureVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.PatientProcedures domain;
}