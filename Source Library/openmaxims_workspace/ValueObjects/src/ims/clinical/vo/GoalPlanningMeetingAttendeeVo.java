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

package ims.clinical.vo;

/**
 * Linked to clinical.GoalPlanningMeetingAttendee business object (ID: 1072100022).
 */
public class GoalPlanningMeetingAttendeeVo extends ims.clinical.vo.GoalPlanningMeetingAttendeeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GoalPlanningMeetingAttendeeVo()
	{
	}
	public GoalPlanningMeetingAttendeeVo(Integer id, int version)
	{
		super(id, version);
	}
	public GoalPlanningMeetingAttendeeVo(ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo();
		this.familymember = bean.getFamilyMember();
		this.note = bean.getNote();
		this.status = bean.getStatus() == null ? null : ims.clinical.vo.lookups.AttendanceStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo(map);
		this.familymember = bean.getFamilyMember();
		this.note = bean.getNote();
		this.status = bean.getStatus() == null ? null : ims.clinical.vo.lookups.AttendanceStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean();
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
		if(fieldName.equals("HCP"))
			return getHcp();
		if(fieldName.equals("FAMILYMEMBER"))
			return getFamilyMember();
		if(fieldName.equals("NOTE"))
			return getNote();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHcpIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.HcpLiteVo getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.hcp = value;
	}
	public boolean getFamilyMemberIsNotNull()
	{
		return this.familymember != null;
	}
	public String getFamilyMember()
	{
		return this.familymember;
	}
	public static int getFamilyMemberMaxLength()
	{
		return 55;
	}
	public void setFamilyMember(String value)
	{
		this.isValidated = false;
		this.familymember = value;
	}
	public boolean getNoteIsNotNull()
	{
		return this.note != null;
	}
	public String getNote()
	{
		return this.note;
	}
	public static int getNoteMaxLength()
	{
		return 255;
	}
	public void setNote(String value)
	{
		this.isValidated = false;
		this.note = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.clinical.vo.lookups.AttendanceStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.clinical.vo.lookups.AttendanceStatus value)
	{
		this.isValidated = false;
		this.status = value;
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
		if(this.hcp != null)
		{
			if(!this.hcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.hcp != null)
		{
			String[] listOfOtherErrors = this.hcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.familymember != null)
			if(this.familymember.length() > 55)
				listOfErrors.add("The length of the field [familymember] in the value object [ims.clinical.vo.GoalPlanningMeetingAttendeeVo] is too big. It should be less or equal to 55");
		if(this.note != null)
			if(this.note.length() > 255)
				listOfErrors.add("The length of the field [note] in the value object [ims.clinical.vo.GoalPlanningMeetingAttendeeVo] is too big. It should be less or equal to 255");
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
	
		GoalPlanningMeetingAttendeeVo clone = new GoalPlanningMeetingAttendeeVo(this.id, this.version);
		
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.HcpLiteVo)this.hcp.clone();
		clone.familymember = this.familymember;
		clone.note = this.note;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.clinical.vo.lookups.AttendanceStatus)this.status.clone();
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
		if (!(GoalPlanningMeetingAttendeeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GoalPlanningMeetingAttendeeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((GoalPlanningMeetingAttendeeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((GoalPlanningMeetingAttendeeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.hcp != null)
			count++;
		if(this.familymember != null)
			count++;
		if(this.note != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.HcpLiteVo hcp;
	protected String familymember;
	protected String note;
	protected ims.clinical.vo.lookups.AttendanceStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
