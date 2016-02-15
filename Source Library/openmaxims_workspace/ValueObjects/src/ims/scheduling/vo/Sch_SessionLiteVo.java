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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class Sch_SessionLiteVo extends ims.scheduling.vo.Sch_SessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Sch_SessionLiteVo()
	{
	}
	public Sch_SessionLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public Sch_SessionLiteVo(ims.scheduling.vo.beans.Sch_SessionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sessiondate = bean.getSessionDate() == null ? null : bean.getSessionDate().buildDate();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.Sch_SessionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sessiondate = bean.getSessionDate() == null ? null : bean.getSessionDate().buildDate();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.Sch_SessionLiteVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.Sch_SessionLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.Sch_SessionLiteVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("SESSIONDATE"))
			return getSessionDate();
		if(fieldName.equals("STARTTM"))
			return getStartTm();
		if(fieldName.equals("ENDTM"))
			return getEndTm();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getSessionDateIsNotNull()
	{
		return this.sessiondate != null;
	}
	public ims.framework.utils.Date getSessionDate()
	{
		return this.sessiondate;
	}
	public void setSessionDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.sessiondate = value;
	}
	public boolean getStartTmIsNotNull()
	{
		return this.starttm != null;
	}
	public ims.framework.utils.Time getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttm = value;
	}
	public boolean getEndTmIsNotNull()
	{
		return this.endtm != null;
	}
	public ims.framework.utils.Time getEndTm()
	{
		return this.endtm;
	}
	public void setEndTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.endtm = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
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
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.Sch_SessionLiteVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.scheduling.vo.Sch_SessionLiteVo] is too big. It should be less or equal to 255");
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
	
		Sch_SessionLiteVo clone = new Sch_SessionLiteVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.sessiondate == null)
			clone.sessiondate = null;
		else
			clone.sessiondate = (ims.framework.utils.Date)this.sessiondate.clone();
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		if(this.endtm == null)
			clone.endtm = null;
		else
			clone.endtm = (ims.framework.utils.Time)this.endtm.clone();
		clone.isactive = this.isactive;
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
		if (!(Sch_SessionLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Sch_SessionLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Sch_SessionLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Sch_SessionLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.description != null)
			count++;
		if(this.sessiondate != null)
			count++;
		if(this.starttm != null)
			count++;
		if(this.endtm != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String name;
	protected String description;
	protected ims.framework.utils.Date sessiondate;
	protected ims.framework.utils.Time starttm;
	protected ims.framework.utils.Time endtm;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}