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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.MobilisationsTreatment business object (ID: 1019100006).
 */
public class MobilisationsTreatmentVo extends ims.therapies.treatment.vo.MobilisationsTreatmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MobilisationsTreatmentVo()
	{
	}
	public MobilisationsTreatmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public MobilisationsTreatmentVo(ims.therapies.vo.beans.MobilisationsTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmenttype = bean.getTreatmentType() == null ? null : ims.spinalinjuries.vo.lookups.MobilisationsTreatment.buildLookup(bean.getTreatmentType());
		this.other = bean.getOther();
		this.reason = bean.getReason();
		this.areatreated = bean.getAreaTreated();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.MobilisationsTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmenttype = bean.getTreatmentType() == null ? null : ims.spinalinjuries.vo.lookups.MobilisationsTreatment.buildLookup(bean.getTreatmentType());
		this.other = bean.getOther();
		this.reason = bean.getReason();
		this.areatreated = bean.getAreaTreated();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.MobilisationsTreatmentVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.MobilisationsTreatmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.MobilisationsTreatmentVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("TREATMENTTYPE"))
			return getTreatmentType();
		if(fieldName.equals("OTHER"))
			return getOther();
		if(fieldName.equals("REASON"))
			return getReason();
		if(fieldName.equals("AREATREATED"))
			return getAreaTreated();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentTypeIsNotNull()
	{
		return this.treatmenttype != null;
	}
	public ims.spinalinjuries.vo.lookups.MobilisationsTreatment getTreatmentType()
	{
		return this.treatmenttype;
	}
	public void setTreatmentType(ims.spinalinjuries.vo.lookups.MobilisationsTreatment value)
	{
		this.isValidated = false;
		this.treatmenttype = value;
	}
	public boolean getOtherIsNotNull()
	{
		return this.other != null;
	}
	public String getOther()
	{
		return this.other;
	}
	public static int getOtherMaxLength()
	{
		return 50;
	}
	public void setOther(String value)
	{
		this.isValidated = false;
		this.other = value;
	}
	public boolean getReasonIsNotNull()
	{
		return this.reason != null;
	}
	public String getReason()
	{
		return this.reason;
	}
	public static int getReasonMaxLength()
	{
		return 255;
	}
	public void setReason(String value)
	{
		this.isValidated = false;
		this.reason = value;
	}
	public boolean getAreaTreatedIsNotNull()
	{
		return this.areatreated != null;
	}
	public String getAreaTreated()
	{
		return this.areatreated;
	}
	public static int getAreaTreatedMaxLength()
	{
		return 255;
	}
	public void setAreaTreated(String value)
	{
		this.isValidated = false;
		this.areatreated = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.treatmenttype == null)
			listOfErrors.add("Treatment Type is a mandatory field");
		if(this.other != null)
			if(this.other.length() > 50)
				listOfErrors.add("The length of the field [other] in the value object [ims.therapies.vo.MobilisationsTreatmentVo] is too big. It should be less or equal to 50");
		if(this.reason != null)
			if(this.reason.length() > 255)
				listOfErrors.add("The length of the field [reason] in the value object [ims.therapies.vo.MobilisationsTreatmentVo] is too big. It should be less or equal to 255");
		if(this.areatreated != null)
			if(this.areatreated.length() > 255)
				listOfErrors.add("The length of the field [areatreated] in the value object [ims.therapies.vo.MobilisationsTreatmentVo] is too big. It should be less or equal to 255");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		MobilisationsTreatmentVo clone = new MobilisationsTreatmentVo(this.id, this.version);
		
		if(this.treatmenttype == null)
			clone.treatmenttype = null;
		else
			clone.treatmenttype = (ims.spinalinjuries.vo.lookups.MobilisationsTreatment)this.treatmenttype.clone();
		clone.other = this.other;
		clone.reason = this.reason;
		clone.areatreated = this.areatreated;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(MobilisationsTreatmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MobilisationsTreatmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MobilisationsTreatmentVo compareObj = (MobilisationsTreatmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getTreatmentType() == null && compareObj.getTreatmentType() != null)
				return -1;
			if(this.getTreatmentType() != null && compareObj.getTreatmentType() == null)
				return 1;
			if(this.getTreatmentType() != null && compareObj.getTreatmentType() != null)
				retVal = this.getTreatmentType().compareTo(compareObj.getTreatmentType());
		}
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatmenttype != null)
			count++;
		if(this.other != null)
			count++;
		if(this.reason != null)
			count++;
		if(this.areatreated != null)
			count++;
		if(this.sysinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.spinalinjuries.vo.lookups.MobilisationsTreatment treatmenttype;
	protected String other;
	protected String reason;
	protected String areatreated;
	protected ims.vo.SystemInformation sysinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
