//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.pci.forms.clientdemographics;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		PCI = new PCIContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getPatientFilterIsNotNull()
		{
			return !cx_CorePatientFilter.getValueIsNull(context);
		}
		public ims.core.vo.PatientFilter getPatientFilter()
		{
			return (ims.core.vo.PatientFilter)cx_CorePatientFilter.getValue(context);
		}
		public void setPatientFilter(ims.core.vo.PatientFilter value)
		{
			cx_CorePatientFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientFilter = new ims.framework.ContextVariable("Core.PatientFilter", "_cvp_Core.PatientFilter");
		public boolean getGPDetailsIsNotNull()
		{
			return !cx_CoreGPDetails.getValueIsNull(context);
		}
		public ims.core.vo.GpShortVo getGPDetails()
		{
			return (ims.core.vo.GpShortVo)cx_CoreGPDetails.getValue(context);
		}
		public void setGPDetails(ims.core.vo.GpShortVo value)
		{
			cx_CoreGPDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGPDetails = new ims.framework.ContextVariable("Core.GPDetails", "_cv_Core.GPDetails");
		public boolean getPatientToBeDisplayedIsNotNull()
		{
			return !cx_CorePatientToBeDisplayed.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientToBeDisplayed()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientToBeDisplayed.getValue(context);
		}
		public void setPatientToBeDisplayed(ims.core.vo.PatientShort value)
		{
			cx_CorePatientToBeDisplayed.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientToBeDisplayed = new ims.framework.ContextVariable("Core.PatientToBeDisplayed", "_cv_Core.PatientToBeDisplayed");

		private ims.framework.Context context;
	}
	public final class PCIContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PCIContext(ims.framework.Context context)
		{
			this.context = context;

			AddressHistory = new AddressHistoryContext(context);
		}
		public final class AddressHistoryContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private AddressHistoryContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getAllowSaveIsNotNull()
			{
				return !cx_PCIAddressHistoryAllowSave.getValueIsNull(context);
			}
			public Boolean getAllowSave()
			{
				return (Boolean)cx_PCIAddressHistoryAllowSave.getValue(context);
			}
		public void setAllowSave(Boolean value)
		{
				cx_PCIAddressHistoryAllowSave.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_PCIAddressHistoryAllowSave = new ims.framework.ContextVariable("PCI.AddressHistory.AllowSave", "_cv_PCI.AddressHistory.AllowSave");
			private ims.framework.Context context;
		}

		public boolean getClientAddressesIsNotNull()
		{
			return !cx_PCIClientAddresses.getValueIsNull(context);
		}
		public ims.pci.vo.ClientAddressVo getClientAddresses()
		{
			return (ims.pci.vo.ClientAddressVo)cx_PCIClientAddresses.getValue(context);
		}
		public void setClientAddresses(ims.pci.vo.ClientAddressVo value)
		{
			cx_PCIClientAddresses.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCIClientAddresses = new ims.framework.ContextVariable("PCI.ClientAddresses", "_cv_PCI.ClientAddresses");
		public boolean getIsChildAddressUpdatedIsNotNull()
		{
			return !cx_PCIIsChildAddressUpdated.getValueIsNull(context);
		}
		public Boolean getIsChildAddressUpdated()
		{
			return (Boolean)cx_PCIIsChildAddressUpdated.getValue(context);
		}
		public void setIsChildAddressUpdated(Boolean value)
		{
			cx_PCIIsChildAddressUpdated.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCIIsChildAddressUpdated = new ims.framework.ContextVariable("PCI.IsChildAddressUpdated", "_cv_PCI.IsChildAddressUpdated");
		public boolean getSchoolIsNotNull()
		{
			return !cx_PCISchool.getValueIsNull(context);
		}
		public ims.core.vo.SchoolShortVo getSchool()
		{
			return (ims.core.vo.SchoolShortVo)cx_PCISchool.getValue(context);
		}
		public void setSchool(ims.core.vo.SchoolShortVo value)
		{
			cx_PCISchool.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCISchool = new ims.framework.ContextVariable("PCI.School", "_cv_PCI.School");
		public boolean getCurrentSectorIsNotNull()
		{
			return !cx_PCICurrentSector.getValueIsNull(context);
		}
		public ims.core.vo.LocationLiteVo getCurrentSector()
		{
			return (ims.core.vo.LocationLiteVo)cx_PCICurrentSector.getValue(context);
		}
		public void setCurrentSector(ims.core.vo.LocationLiteVo value)
		{
			cx_PCICurrentSector.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCICurrentSector = new ims.framework.ContextVariable("PCI.CurrentSector", "_cv_PCI.CurrentSector");
		public boolean getBirthDetailsModeIsNotNull()
		{
			return !cx_PCIBirthDetailsMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getBirthDetailsMode()
		{
			return (ims.framework.enumerations.FormMode)cx_PCIBirthDetailsMode.getValue(context);
		}
		public void setBirthDetailsMode(ims.framework.enumerations.FormMode value)
		{
			cx_PCIBirthDetailsMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCIBirthDetailsMode = new ims.framework.ContextVariable("PCI.BirthDetailsMode", "_cv_PCI.BirthDetailsMode");

		public AddressHistoryContext AddressHistory;
		private ims.framework.Context context;
	}

	public CoreContext Core;
	public PCIContext PCI;
}
